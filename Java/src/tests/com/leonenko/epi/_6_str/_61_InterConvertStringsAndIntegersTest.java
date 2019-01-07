package com.leonenko.epi._6_str;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._6_str._61_InterConvertStringsAndIntegers.*;
import static com.leonenko.epi._6_str._61_InterConvertStringsAndIntegers.strToInt;
import static org.assertj.core.api.Assertions.assertThat;

class _61_InterConvertStringsAndIntegersTest {

    private static final int NUM_VALUE = 12345;
    private static final String STR_VALUE = "12345";

    @Test
    void testToString() {
        assertThat(intToStr(NUM_VALUE)).isEqualTo(STR_VALUE);
    }

    @Test
    void testToInt() {
        assertThat(strToInt(STR_VALUE)).isEqualTo(NUM_VALUE);
    }
}