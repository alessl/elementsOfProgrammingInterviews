package com.leonenko.epi._10_heap;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._10_heap._102_SortIncrDecrList_1.sortListWithIncrDecrSubList;
import static org.assertj.core.api.Assertions.assertThat;

class _102_SortIncrDecrList_1Test {

    @Test
    void testSortListsOfSameLength() {
        var list = List.of(1, 3, 5, 4, 2, 0);
        var sortedList = sortListWithIncrDecrSubList(list);

        assertThat(sortedList).containsExactly(0, 1, 2, 3, 4, 5);
    }

    @Test
    void testSortListsOfDifferentLengths() {
        var list = List.of(1, 3, 5, 4, 2, 6, 8, 7);
        var sortedList = sortListWithIncrDecrSubList(list);

        assertThat(sortedList).containsExactly(1, 2, 3, 4, 5, 6, 7, 8);
    }
}