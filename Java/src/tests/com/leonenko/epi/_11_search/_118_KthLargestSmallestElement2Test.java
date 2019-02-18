package com.leonenko.epi._11_search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static com.leonenko.epi._11_search._118_KthLargestSmallestElement2.getKLargest;
import static com.leonenko.epi._11_search._118_KthLargestSmallestElement2.getSmallestK;
import static org.assertj.core.api.Assertions.assertThat;

class _118_KthLargestSmallestElement2Test {

    private int[] array;

    @BeforeEach
    void setUp() {
        var random = new Random();

        array = random.ints(20, 0, 100 + 1)
                      .toArray();
    }

    @Test
    void testKLargest() {
        assertKLargest(4);
        assertKLargest(1);
        assertKLargest(array.length);
    }

    private void assertKLargest(int k) {
        assertThat(getKLargest(array, k)).isEqualTo(getExpectedKLargest(k));
    }

    private int getExpectedKLargest(int k) {
        return Arrays.stream(array)
                     .sorted()
                     .toArray()[array.length - k];
    }

    @Test
    void testKSmallest() {
        assertKSmallest(4);
        assertKSmallest(1);
        assertKSmallest(array.length);

    }

    private void assertKSmallest(int k) {
        assertThat(getSmallestK(array, k)).isEqualTo(getExpectedKSmallest(k));
    }

    private int getExpectedKSmallest(int k) {
        return Arrays.stream(array)
                     .sorted()
                     .toArray()[k - 1];
    }
}