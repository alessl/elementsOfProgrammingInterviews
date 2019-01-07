package com.leonenko.epi._10_heap;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.leonenko.epi._10_heap._103_SortKSortedList.sortKSortedList;
import static org.assertj.core.api.Assertions.assertThat;

class _103_SortKSortedList_Test {

    @Test
    void testSort() {
        var k = 3;
        var list = Stream.of(3, 1, 0, 2, 7, 4, 5, 6)
                         .collect(Collectors.toList());

        var sortedList = sortKSortedList(list, k);

        assertThat(sortedList).containsExactly(0, 1, 2, 3, 4, 5, 6, 7);
    }
}