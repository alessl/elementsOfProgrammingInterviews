package com.leonenko.epi._7_list_TODO;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._7_list_TODO.TestUtils.assertListContainsKeys;

class _71_MergeTwoSortedListsTest {

    @Test
    void testSimple() {
        var keys1 = List.of(1, 3, 5);
        var list1 = ListNode.generateList(keys1);
        assertListContainsKeys(list1, keys1);

        var keys2 = List.of(2, 4);
        var list2 = ListNode.generateList(keys2);
        assertListContainsKeys(list2, keys2);

        var mergedList = _71_MergeTwoSortedLists.mergeLists(list1, list2);
        assertListContainsKeys(mergedList, List.of(1, 2, 3, 4, 5));
    }

    @Test
    void testAllElementsSmaller() {
        var keys1 = List.of(1, 2, 3);
        var list1 = ListNode.generateList(keys1);
        assertListContainsKeys(list1, keys1);

        var keys2 = List.of(4, 5);
        var list2 = ListNode.generateList(keys2);
        assertListContainsKeys(list2, keys2);

        var mergedList = _71_MergeTwoSortedLists.mergeLists(list1, list2);
        assertListContainsKeys(mergedList, List.of(1, 2, 3, 4, 5));
    }

    @Test
    void testDuplicates() {
        var keys1 = List.of(1, 2, 3, 5);
        var list1 = ListNode.generateList(keys1);
        assertListContainsKeys(list1, keys1);

        var keys2 = List.of(2, 3, 4, 5);
        var list2 = ListNode.generateList(keys2);
        assertListContainsKeys(list2, keys2);

        var mergedList = _71_MergeTwoSortedLists.mergeLists(list1, list2);
        assertListContainsKeys(mergedList, List.of(1, 2, 2, 3, 3, 4, 5, 5));
    }

}