package com.leonenko.epi._7_list;

import org.junit.jupiter.api.Test;

import java.util.List;

class _710_EvenOddMergeTest {

    @Test
    void testEvenLast() {
        var originalList = ListNode.singlyLinkedListOf(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8));

        var evenOddMergedList = _710_EvenOddMerge.merge(originalList);

        TestUtils.assertListContainsKeys(evenOddMergedList, List.of(0, 2, 4, 6, 8, 1, 3, 5, 7));
    }

    @Test
    void testOddLast() {
        var originalList = ListNode.singlyLinkedListOf(List.of(0, 1, 2, 3, 4, 5, 6, 7));

        var evenOddMergedList = _710_EvenOddMerge.merge(originalList);

        TestUtils.assertListContainsKeys(evenOddMergedList, List.of(0, 2, 4, 6, 1, 3, 5, 7));
    }
}