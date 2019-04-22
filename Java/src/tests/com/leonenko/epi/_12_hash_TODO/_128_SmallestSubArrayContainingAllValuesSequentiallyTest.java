package com.leonenko.epi._12_hash_TODO;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._12_hash_TODO._128_SmallestSubArrayContainingAllValuesSequentially.getMinLengthSubArrayContainingAllSequentially;
import static org.assertj.core.api.Assertions.assertThat;

class _128_SmallestSubArrayContainingAllValuesSequentiallyTest {

    @Test
    void testGetSubArray1() {
        var minSubArray = getMinLengthSubArrayContainingAllSequentially(
                new String[] {
                        "banana",
                        "apple",
                        "dog",
                        "cat",
                        "banana",
                        "dog",
                        "cat",
                        "orange",
                },
                new String[] {"banana", "cat"});

        assertThat(minSubArray).containsExactly("banana", "dog", "cat");
    }

    @Test
    void testGetSubArray2() {
        var minSubArray = getMinLengthSubArrayContainingAllSequentially(
                new String[] {
                        "banana",
                        "apple",
                        "dog",
                        "cat",
                        "apple",
                        "banana",
                        "banana",
                        "cat",
                        "orange",
                        "kiwi",
                        "banana",
                },
                new String[] {"banana", "cat"});

        assertThat(minSubArray).containsExactly("banana", "cat");
    }

    @Test
    void testGetSubArray3() {
        var minSubArray = getMinLengthSubArrayContainingAllSequentially(
                new String[] {
                        "banana",
                        "banana",
                        "banana",
                        "orange",
                        "cat",
                        "kiwi",
                },
                new String[] {"banana", "cat"});

        assertThat(minSubArray).containsExactly("banana", "orange", "cat");
    }
}