package com.leonenko.epi._16_dp;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._16_dp._164_BinomialCoefficients.computeBinomialCoefficient;
import static org.assertj.core.api.Assertions.assertThat;

class _164_BinomialCoefficientsTest {

    @Test
    void testCmputeBinomialCoefficient() {
        assertThat(computeBinomialCoefficient(5, 2)).isEqualTo(10);
    }
}