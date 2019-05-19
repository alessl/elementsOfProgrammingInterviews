package com.leonenko.epi._7_list_TODO;

import org.junit.jupiter.api.Test;

import java.util.List;

class _78_RemoveDuplicatesFromSortedListTest {

    @Test
    void test() {
        var listDups = ListNode.singlyLinkedListOf(List.of(
                0, 0, 10, 30, 40, 40, 50, 70, 70, 70, 70));

        var listNoDups = _78_RemoveDuplicatesFromSortedList.removeDuplicates(listDups);

        TestUtils.assertListContainsKeys(listNoDups, List.of(0, 10, 30, 40, 50, 70));
    }
}