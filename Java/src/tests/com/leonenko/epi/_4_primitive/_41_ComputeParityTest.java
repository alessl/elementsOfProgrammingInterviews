package com.leonenko.epi._4_primitive;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static java.lang.Integer.bitCount;
import static java.lang.Integer.parseInt;
import static org.assertj.core.api.Assertions.assertThat;

class _41_ComputeParityTest {

    private static final String NUM_1 = "100110";
    private static final String NUM_2 = "1001101";
    private static final String NUM_3 = "0";

    @Test
    void testComputeParityZeroLowestOneBit() {
        assertParity(_41_ComputeParity::computeParityZeroLowestOneBit);
    }

    @Test
    void testComputeParityXorHalves() {
        assertParity(_41_ComputeParity::computeParityXorHalves);
    }

    @Test
    void testComputeParityLookupTable() {
        assertParity(_41_ComputeParity::computeParityWithTable);
    }

    private static void assertParity(Function<Integer, Integer> parityComputer) {
        assertParity(NUM_1, parityComputer);
        assertParity(NUM_2, parityComputer);
        assertParity(NUM_3, parityComputer);
    }

    private static void assertParity(String numberAsBinaryString,
                                     Function<Integer, Integer> parityComputer) {
        var numberAsInt = parseInt(numberAsBinaryString, 2);
        var expectedParity = bitCount(numberAsInt) % 2 == 0 ? 0 : 1;

        assertThat(parityComputer.apply(numberAsInt)).isEqualTo(expectedParity);
    }
}