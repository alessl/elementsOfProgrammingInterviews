package com.leonenko.epi._7_list_TODO;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._7_list_TODO._74_CheckOverlappingListsNoCycles.isOverlap;
import static org.assertj.core.api.Assertions.assertThat;

class _74_CheckOverlappingListsNoCyclesTest {

    private final ListNode<Integer> firstHead = ListNode.singlyLinkedListOf(List.of(1, 2, 3, 4, 5));
    private final ListNode<Integer> secondHead = ListNode.singlyLinkedListOf(List.of(1, 2, 3));

    @Test
    void testOverlap() {
        var secondTail = secondHead.tail();
        secondTail.setNext(firstHead.node(4));

        assertThat(isOverlap(firstHead, secondHead)).isTrue();
    }

    @Test
    void testNoOverlap() {
        assertThat(isOverlap(firstHead, secondHead)).isFalse();
    }

}