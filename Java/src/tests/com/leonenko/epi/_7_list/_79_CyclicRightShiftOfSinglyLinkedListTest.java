package com.leonenko.epi._7_list;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._7_list._79_CyclicRightShiftOfSinglyLinkedList.rotate;

class _79_CyclicRightShiftOfSinglyLinkedListTest {

    private final ListNode<Integer> head = ListNode.singlyLinkedListOf(List.of(1, 2, 3, 4, 5));

    @Test
    void testRotate1() {
        TestUtils.assertListContainsKeys(rotate(head, 2), List.of(4, 5, 1, 2, 3));
    }

    @Test
    void testRotate2() {
        TestUtils.assertListContainsKeys(rotate(head, 3), List.of(3, 4, 5, 1, 2));
    }

    @Test
    void testRotate3() {
        TestUtils.assertListContainsKeys(rotate(head, 4), List.of(2, 3, 4, 5, 1));
    }

    @Test
    void testRotateDistanceGreaterThanSize() {
        TestUtils.assertListContainsKeys(rotate(head, 9), List.of(2, 3, 4, 5, 1));
    }

    @Test
    void testRotateDistanceIs0() {
        TestUtils.assertListContainsKeys(rotate(head, 0), List.of(1, 2, 3, 4, 5));
    }

    @Test
    void testRotateDistanceIsMultipleOfSize() {
        TestUtils.assertListContainsKeys(rotate(head, 5), List.of(1, 2, 3, 4, 5));
        TestUtils.assertListContainsKeys(rotate(head, 10), List.of(1, 2, 3, 4, 5));
        TestUtils.assertListContainsKeys(rotate(head, 15), List.of(1, 2, 3, 4, 5));
    }
}