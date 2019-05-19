package com.leonenko.epi._7_list_TODO;

import org.junit.jupiter.api.Test;

import java.util.List;

class _77_RemoveKthElementFromListTest {

    private final ListNode<Integer> head =
            ListNode.singlyLinkedListOf(List.of(1, 2, 3, 4, 5, 6, 7));

    @Test
    void testRemoveKthNodeFromEnd() {
        var newHead = _77_RemoveKthElementFromList.removeKthNodeFromEnd(head, 2);
        TestUtils.assertListContainsKeys(newHead, List.of(1, 2, 3, 4, 5, 7));
    }

    @Test
    void testRemoveLastNode() {
        var newHead = _77_RemoveKthElementFromList.removeKthNodeFromEnd(head, 1);
        TestUtils.assertListContainsKeys(newHead, List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void testRemoveFirstNode() {
        var newHead = _77_RemoveKthElementFromList.removeKthNodeFromEnd(head, 7);
        TestUtils.assertListContainsKeys(newHead, List.of(2, 3, 4, 5, 6, 7));
    }
}