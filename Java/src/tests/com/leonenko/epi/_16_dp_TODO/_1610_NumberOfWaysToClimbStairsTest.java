package com.leonenko.epi._16_dp_TODO;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._16_dp_TODO._1610_NumberOfWaysToClimbStairs.getNumWaysToClimbStairs;
import static org.assertj.core.api.Assertions.assertThat;

class _1610_NumberOfWaysToClimbStairsTest {

    @Test
    void testGetNumWaysToClimbStairs() {
        assertThat(getNumWaysToClimbStairs(4, 2)).isEqualTo(5);
    }
}