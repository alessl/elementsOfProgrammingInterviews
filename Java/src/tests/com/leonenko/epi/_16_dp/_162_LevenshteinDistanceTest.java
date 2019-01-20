package com.leonenko.epi._16_dp;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._16_dp._162_LevenshteinDistance.*;
import static org.assertj.core.api.Assertions.assertThat;

class _162_LevenshteinDistanceTest {

    @Test
    void testGetMinimumDistance1() {
        assertThat(getMinimumDistance("Saturday", "Sundays")).isEqualTo(4);
        assertThat(getMinimumDistance("Carthorse", "Orchestra")).isEqualTo(8);
    }

    @Test
    void testGetMinimumDistanceDP() {
        assertThat(getMinimumDistanceDP("Saturday", "Sundays")).isEqualTo(4);
    }

    @Test
    void testNoDeletionsToMakePalindrome() {
        assertThat(getMinDeletionsToMakePalindrome("aabbaa")).isEqualTo(0);
        assertThat(getMinDeletionsToMakePalindrome("bb")).isEqualTo(0);
        assertThat(getMinDeletionsToMakePalindrome("bab")).isEqualTo(0);
    }

    @Test
    void testGetMinimumDeletionsToMakePalindrome() {
        assertThat(getMinDeletionsToMakePalindrome("aaabbaacc")).isEqualTo(3);
        assertThat(getMinDeletionsToMakePalindrome("ccabba")).isEqualTo(2);
        assertThat(getMinDeletionsToMakePalindrome("cacbcbac")).isEqualTo(1);
        assertThat(getMinDeletionsToMakePalindrome("cabad")).isEqualTo(2);
        assertThat(getMinDeletionsToMakePalindrome("cabfad")).isEqualTo(3);
    }
}