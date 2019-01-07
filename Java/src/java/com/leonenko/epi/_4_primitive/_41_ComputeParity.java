package com.leonenko.epi._4_primitive;

import java.util.stream.IntStream;

/**
 * Created by Alex on 5/5/2017.
 */
public class _41_ComputeParity {

    private static final int WORD_SIZE = 8;
    private static final int MASK = 0xff;
    private static final int[] WORD_PARITY_TABLE = createLookupTable();

    static int computeParityZeroLowestOneBit(int number) {
        var parity = 0;
        var tmp = number;

        while (tmp > 0) {
            parity ^= 1;
            tmp &= (tmp - 1);
        }

        return parity;
    }

    static int computeParityXorHalves(int number) {
        var parity = number;

        parity ^= parity >>> 31;
        parity ^= parity >>> 16;
        parity ^= parity >>> 8;
        parity ^= parity >>> 4;
        parity ^= parity >>> 2;
        parity ^= parity >>> 1;
        parity &= 1;

        return parity;
    }

    static int computeParityWithTable(int number) {
        var word1 = WORD_PARITY_TABLE[(number >>> 3 * WORD_SIZE) & MASK];
        var word2 = WORD_PARITY_TABLE[(number >>> 2 * WORD_SIZE) & MASK];
        var word3 = WORD_PARITY_TABLE[(number >>> WORD_SIZE) & MASK];
        var word4 = WORD_PARITY_TABLE[number & MASK];

        return word1 ^ word2 ^ word3 ^ word4;
    }

    private static int[] createLookupTable() {
        return IntStream.range(0, Byte.MAX_VALUE - Byte.MIN_VALUE + 1)
                        .map(i -> Integer.bitCount(i) % 2)
                        .toArray();
    }
}
