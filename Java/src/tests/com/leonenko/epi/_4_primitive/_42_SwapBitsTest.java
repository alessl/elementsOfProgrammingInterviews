package com.leonenko.epi._4_primitive;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._4_primitive._42_SwapBits.swapBits;
import static org.assertj.core.api.Assertions.assertThat;

class _42_SwapBitsTest {

    @Test
    void testSwapBits() {
        assertBitSwap(0b11101, 1, 3, 0b10111);
        assertBitSwap(0b10101, 1, 3, 0b10101);
        assertBitSwap(0b11110, 0, 2, 0b11011);
    }

    private void assertBitSwap(int number, int firstBit, int secondBit, int expectedNumber) {
        var numberWithSwappedBits = swapBits(number, firstBit, secondBit);

        var binaryString = Integer.toBinaryString(numberWithSwappedBits);
        var expectedBinaryString = Integer.toBinaryString(expectedNumber);

        assertThat(binaryString).contains(expectedBinaryString);
    }
}