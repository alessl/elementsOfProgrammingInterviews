package com.leonenko.epi._13_sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.leonenko.epi._13_sort._132_MergeSortedArrays.mergeIntoBig;
import static org.assertj.core.api.Assertions.assertThat;

class _132_MergeSortedArraysTest {

    @Test
    void testMergeIntoBigWhenBothArraysHaveSameNumberOfElements() {
        var smallArray = new int[] {1, 3, 5, 7, 9};
        var bigArray = new int[] {0, 2, 4, 6, 8};

        assertMerge(smallArray, bigArray);
    }

    @Test
    void testMergeIntoBigWhenSmallArrayHasFewerElements() {
        var smallArray = new int[] {1, 3, 5};
        var bigArray = new int[] {0, 2, 4, 6, 7, 8};

        assertMerge(smallArray, bigArray);
    }

    @Test
    void testMergeIntoBigWhenSmallArrayHasMoreElements() {
        var smallArray = new int[] {1, 3, 5, 7, 8, 9};
        var bigArray = new int[] {0, 2, 4, 6};

        assertMerge(smallArray, bigArray);
    }

    private void assertMerge(int[] smallArray, int[] bigArray) {
        bigArray = Arrays.copyOf(bigArray, bigArray.length + smallArray.length);

        var expectedMergedArray = getExpectedMergedArray(smallArray, bigArray);

        mergeIntoBig(smallArray, bigArray);

        assertThat(bigArray).containsExactly(expectedMergedArray);
    }

    private int[] getExpectedMergedArray(int[] firstArray, int[] secondArray) {
        int[] mergedArray = new int[secondArray.length];
        Arrays.setAll(mergedArray,
                i -> i < firstArray.length ? firstArray[i] : secondArray[i - firstArray.length]);
        Arrays.sort(mergedArray);

        return mergedArray;
    }
}