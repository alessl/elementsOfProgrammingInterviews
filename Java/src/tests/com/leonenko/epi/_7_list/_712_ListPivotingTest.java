package com.leonenko.epi._7_list;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._7_list.TestUtils.assertListContainsKeys;
import static com.leonenko.epi._7_list._712_ListPivoting.pivot;

class _712_ListPivotingTest {

    private final ListNode<Integer> list = ListNode.singlyLinkedListOf(List.of(5, 1, 3, 4, 4, 6, 6, 2));

    @Test
    void pivotDups() {
        assertListContainsKeys(pivotList(4), List.of(1, 3, 2, 4, 4, 5, 6, 6));
    }

    @Test
    void maxIsPivot() {
        assertListContainsKeys(pivotList(6), List.of(5, 1, 3, 4, 4, 2, 6, 6));
    }

    @Test
    void minIsPivot() {
        assertListContainsKeys(pivotList(1), List.of(1, 5, 3, 4, 4, 6, 6, 2));
    }

    private ListNode<Integer> pivotList(int pivotKey) {
        return pivot(list, pivotKey);
    }
}