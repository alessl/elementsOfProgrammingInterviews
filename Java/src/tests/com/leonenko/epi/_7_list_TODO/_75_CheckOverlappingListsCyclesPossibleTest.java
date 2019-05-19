package com.leonenko.epi._7_list_TODO;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._7_list_TODO._75_CheckOverlappingListsCyclesPossible.isOverlap;
import static org.assertj.core.api.Assertions.assertThat;

class _75_CheckOverlappingListsCyclesPossibleTest {

    private final ListNode<Integer> firstHead = ListNode.singlyLinkedListOf(List.of(1, 2, 3, 4, 5));
    private final ListNode<Integer> secondHead = ListNode.singlyLinkedListOf(List.of(1, 2, 3));

    @Test
    void testOverlapNoCycle() {
        secondHead.addTail(firstHead.findNode(3));

        assertThat(isOverlap(firstHead, secondHead)).isTrue();
    }

    @Test
    void testOverlapSameCycle() {
        secondHead.addTail(firstHead.findNode(3));
        firstHead.addTail(firstHead.findNode(4));

        assertThat(isOverlap(firstHead, secondHead)).isTrue();
    }

    @Test
    void testOverlapDifferentCycles() {
        secondHead.addTail(firstHead.findNode(4));
        firstHead.addTail(firstHead.findNode(2));

        assertThat(isOverlap(firstHead, secondHead)).isTrue();
    }

    @Test
    void testNoOverlapNoCycle() {
        assertThat(isOverlap(firstHead, secondHead)).isFalse();
    }

    @Test
    void testNoOverlapFirstHasCycle() {
        firstHead.addTail(firstHead);

        assertThat(isOverlap(firstHead, secondHead)).isFalse();
    }

    @Test
    void testNoOverlapSecondHasCycle() {
        secondHead.addTail(secondHead);

        assertThat(isOverlap(firstHead, secondHead)).isFalse();
    }
}