package com.leonenko.epi._24_honor_TODO;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._24_honor_TODO._247_LongestContiguousIncreasingSubArray.getMaxIncSubArray;
import static org.assertj.core.api.Assertions.assertThat;

class _247_LongestContiguousIncreasingSubArrayTest {

    @Test
    void test() {
        var array = new int[] {
                2, 11, 3, 5, 13, 15, 7, 19, 20, 17, 25, 27, 30, 31, 50, 10, 11};
        var maxIncSubArray = getMaxIncSubArray(array);
        assertThat(maxIncSubArray).containsExactly(17, 25, 27, 30, 31, 50);
    }
}