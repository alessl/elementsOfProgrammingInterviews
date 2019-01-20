package com.leonenko.epi._16_dp_TODO;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._16_dp_TODO._1612_LongestNonDecreasingSubSequence.getLongestNonDecreasingSubSequence;
import static org.assertj.core.api.Assertions.assertThat;

class _1612_LongestNonDecreasingSubSequenceTest {

    @Test
    void testGetLongestNonDecreasingSubSequence() {
        int[] a = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 0};
        assertThat(getLongestNonDecreasingSubSequence(a)).isEqualTo(4);
    }
}