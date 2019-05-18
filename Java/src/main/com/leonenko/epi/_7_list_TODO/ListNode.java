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

    public int size() {
        return (int) Stream.iterate(
                this,
                Objects::nonNull,
                node -> node.next)
                .count();
    }

    public ListNode<T> tail() {
        return Stream.iterate(
                this,
                Objects::nonNull,
                node -> node.next)
                .dropWhile(node -> node.getNext() != null)
                .findFirst()
                .orElse(null);
    }

    public ListNode<T> node(T key) {
        return Stream.iterate(
                this,
                Objects::nonNull,
                node -> node.next)
                .filter(node -> node.getKey().compareTo(key) == 0)
                .findFirst()
                .orElse(null);
    }

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

    static ListNode<Integer> doublyLinkedListOf(List<Integer> keys) {
        var head = singlyLinkedListOf(keys);

        ListNode<Integer> prev = null;
        ListNode<Integer> iter = head;

        while (iter != null) {
            iter.setPrev(prev);
            prev = iter;
            iter = iter.getNext();
        }

        return head;
    }

    static ListNode<Integer> singlyLinkedListOf(List<Integer> keys) {
        var tailIndex = 1;
        var headIndex = 0;

        return keys.stream()
                .map(ListNode::new)
                .collect(() -> {
                            var head = new ListNode<>(Integer.MIN_VALUE);
                            return Arrays.asList(head, head);
                        },
                        (headTail, node) -> {
                            headTail.get(tailIndex).setNext(node);
                            headTail.set(tailIndex, node);
                        },
                        (headTail1, headTail2) -> {
                            headTail1.get(tailIndex).setNext(headTail2.get(headIndex));
                            headTail1.set(tailIndex, headTail2.get(tailIndex));
                        })
                .get(headIndex)
                .getNext();
    }

}
