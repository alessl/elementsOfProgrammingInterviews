package com.leonenko.epi._24_honor_TODO;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._24_honor_TODO._2416_KSmallestInTwoSortedArrays.getKSmallest;
import static org.assertj.core.api.Assertions.assertThat;

class _2416_KSmallestInTwoSortedArraysTest {

    @Test
    void test() {
        // 1, 4, 7, 8, 8, 10, 12, 20, 25, 25, 30

        var list1 = List.of(4, 10, 12, 25, 30);
        var list2 = List.of(1, 7, 8, 8, 20);

        assertKthElement(
                list1,
                list2,
                3,
                7);
        assertKthElement(
                list1,
                list2,
                4,
                8);
        assertKthElement(
                list1,
                list2,
                5,
                8);
        assertKthElement(
                list1,
                list2,
                8,
                20);
    }

    private static void assertKthElement(
            List<Integer> first,
            List<Integer> second,
            int k,
            int expectedKthElement) {

        assertThat(getKSmallest(first, second, k)).isEqualTo(expectedKthElement);
    }
}