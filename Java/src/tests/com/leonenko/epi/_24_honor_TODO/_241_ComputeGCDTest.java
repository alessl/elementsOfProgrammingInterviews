package com.leonenko.epi._24_honor_TODO;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.leonenko.epi._24_honor_TODO._241_ComputeGCD.getGCD;

class _241_ComputeGCDTest {

    @Test
    void testGetGCD() {
        Assertions.assertThat(getGCD(21, 27)).isEqualTo(3);
        Assertions.assertThat(getGCD(9, 27)).isEqualTo(9);
        Assertions.assertThat(getGCD(247, 589)).isEqualTo(19);
        Assertions.assertThat(getGCD(250, 589)).isEqualTo(1);
    }
}