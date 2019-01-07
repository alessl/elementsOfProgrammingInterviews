package com.leonenko.epi._4_primitive;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.leonenko.epi._4_primitive._43_ReverseBits.reverseBits;
import static org.assertj.core.api.Assertions.assertThat;

class _43_ReverseBitsTest {

    @Test
    void test1() {
        var randomNumberGenerator = new Random();
        var number = randomNumberGenerator.nextLong();

        var reverseNumber = reverseBits(number);

        System.out.println(binaryStr(number) + "=>" + binaryStr(reverseNumber));

        assertThat(number).isNotEqualTo(reverseNumber);
        assertThat(number).isEqualTo(reverseBits(reverseNumber));
    }

    private String binaryStr(long i) {
        return Long.toBinaryString(i);
    }
}