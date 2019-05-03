package com.leonenko.epi._7_list_TODO;

import lombok.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Created by Alex on 5/12/2017.
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public final class ListNode<T extends Comparable<T>> implements Comparable<ListNode<T>>,
                                                                Iterable<T> {
    private final T key;
    private ListNode<T> next;
    private ListNode<T> prev;

    @Override
    public String toString() {
        String nextStr = this.next != null ? this.next.toString() : "$";
        return String.format("%s->%s", key, nextStr);
    }

    @Override
    public int compareTo(ListNode<T> o) {
        return key.compareTo(o.key);
    }

    @Override
    public Iterator<T> iterator() {
        return Stream.iterate(this, Objects::nonNull, node -> node.next)
                .map(ListNode::getKey)
                .iterator();
    }

    static ListNode<Integer> generateList(List<Integer> keys) {
        List<ListNode<Integer>> headAndTail = keys.stream()
                .map(ListNode::new)
                .collect(() -> {
                            var head = new ListNode<Integer>(null);
                            return Arrays.asList(head, head); },
                        (headAndTail1, node) -> {
                            headAndTail1.get(1).setNext(node);
                            headAndTail1.set(1, node); },
                        (headAndTail1, headAndTail2) -> {
                            headAndTail1.get(1).setNext(headAndTail2.get(0));
                            headAndTail1.set(1, headAndTail2.get(1)); });
        return headAndTail.get(0).getNext();
    }

}
