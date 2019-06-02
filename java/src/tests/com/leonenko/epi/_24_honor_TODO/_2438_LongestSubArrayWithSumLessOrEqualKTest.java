package com.leonenko.epi._24_honor_TODO;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._24_honor_TODO._2438_LongestSubArrayWithSumLessOrEqualK.getSubArray;
import static org.assertj.core.api.Assertions.assertThat;

class _2438_LongestSubArrayWithSumLessOrEqualKTest {

    @Test
    void test() {
        var array = new int[] {342, -10, 639, 342, -14, 565, -924, 635, 167, -70};
        var subArray = getSubArray(array, 184);
        assertThat(subArray).containsExactly(-10, 639, 342, -14, 565, -924, 635, 167);
    }
}