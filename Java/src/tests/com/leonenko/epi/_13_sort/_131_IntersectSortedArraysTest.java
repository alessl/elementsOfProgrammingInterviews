package com.leonenko.epi._13_sort;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._13_sort._131_IntersectSortedArrays.intersectByBinarySearch;
import static com.leonenko.epi._13_sort._131_IntersectSortedArrays.intersectByMerge;
import static org.assertj.core.api.Assertions.assertThat;

class _131_IntersectSortedArraysTest {

    private final int[] array1 = {1, 3, 5, 7, 9};
    private final int[] array2 = {0, 2, 4, 6, 8};

    @Test
    void testIntersectByMerge() {
        assertThat(intersectByMerge(array1, array2))
                .containsExactly(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Test
    void testIntersectByBinarySearch() {
        assertThat(intersectByBinarySearch(array1, array2))
                .containsExactly(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }
}