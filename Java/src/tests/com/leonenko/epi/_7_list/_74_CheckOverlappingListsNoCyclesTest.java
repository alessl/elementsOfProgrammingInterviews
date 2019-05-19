package com.leonenko.epi._7_list;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._7_list._74_CheckOverlappingListsNoCycles.isOverlap;
import static org.assertj.core.api.Assertions.assertThat;

class _74_CheckOverlappingListsNoCyclesTest {

    private final ListNode<Integer> firstHead = ListNode.singlyLinkedListOf(List.of(1, 2, 3, 4, 5));
    private final ListNode<Integer> secondHead = ListNode.singlyLinkedListOf(List.of(1, 2, 3));

    @Test
    void testOverlapSameLengthLists() {
        secondHead.addTail(firstHead.findNode(4));

        assertThat(isOverlap(firstHead, secondHead)).isTrue();
    }

    @Test
    void testOverlapFirstIsLonger() {
        var newFirstHead = ListNode.singleton(0);
        newFirstHead.setNext(firstHead);

        secondHead.addTail(firstHead.findNode(4));

        assertThat(isOverlap(newFirstHead, secondHead)).isTrue();
    }

    @Test
    void testOverlapSecondIsLonger() {
        var newSecondHead = ListNode.singleton(0);
        newSecondHead.setNext(secondHead);

        newSecondHead.addTail(firstHead.findNode(4));

        assertThat(isOverlap(firstHead, newSecondHead)).isTrue();
    }

    @Test
    void testNoOverlap() {
        assertThat(isOverlap(firstHead, secondHead)).isFalse();
    }

}