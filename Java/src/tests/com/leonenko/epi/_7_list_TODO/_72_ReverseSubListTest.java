package com.leonenko.epi._7_list_TODO;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class _72_ReverseSubListTest {

    @Test
    void reverseSubList() {
        var listHead = ListNode.singlyLinkedListOf(List.of(1, 2, 6, 5, 4, 3, 7));
        var reversedListHead = _72_ReverseSubList.reverseSubList(listHead, 2, 5);

        assertList(reversedListHead, List.of(1, 2, 3, 4, 5, 6, 7));
    }

    @Test
    void reverseListAll() {
        var listHead = ListNode.singlyLinkedListOf(List.of(5, 4, 3, 2, 1));
        var reversedListHead = _72_ReverseSubList.reverseSubList(listHead, 0, 4);

        assertList(reversedListHead, List.of(1, 2, 3, 4, 5));
    }

    @Test
    void reverseSubListMidToEnd() {
        var listHead = ListNode.singlyLinkedListOf(List.of(1, 2, 3, 6, 5, 4));
        var reversedListHead = _72_ReverseSubList.reverseSubList(listHead, 3, 5);

        assertList(reversedListHead, List.of(1, 2, 3, 4, 5, 6));
    }

    private static void assertList(Iterable<Integer> list, List<Integer> keys) {
        assertThat(list).containsExactlyElementsOf(keys);
    }
}