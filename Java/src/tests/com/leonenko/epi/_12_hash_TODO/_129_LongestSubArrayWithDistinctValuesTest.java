package com.leonenko.epi._12_hash_TODO;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._12_hash_TODO._129_LongestSubArrayWithDistinctValues.getSubArray;
import static org.assertj.core.api.Assertions.assertThat;

class _129_LongestSubArrayWithDistinctValuesTest {

    @Test
    void testGetSubArray1() {
        var words = new String[] {
                "apple",
                "banana",
                "kiwi",
                "banana",
                "apple",
                "dog",
                "orange",
                "cat",
                "apple",
                "banana",
                "dog",
                "cat",
        };

        var longestSubArrayWithDistinctValues = getSubArray(words);

        assertThat(longestSubArrayWithDistinctValues)
                .containsExactly("kiwi", "banana", "apple", "dog", "orange", "cat");
    }
}