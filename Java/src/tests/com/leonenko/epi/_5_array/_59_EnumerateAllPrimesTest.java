package com.leonenko.epi._5_array;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._5_array._59_EnumerateAllPrimes.generatePrimes;
import static org.assertj.core.api.Assertions.assertThat;

class _59_EnumerateAllPrimesTest {

    @Test
    void testGetPrimes() {
        assertThat(generatePrimes(10)).containsExactly(2, 3, 5, 7);
        assertThat(generatePrimes(100)).containsExactly(
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
                43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97);
    }

    @Test
    void testNoPrimes() {
        assertThat(generatePrimes(1)).isEmpty();
    }

    @Test
    void testGetOnePrime() {
        assertThat(generatePrimes(2)).containsExactly(2);
    }
}