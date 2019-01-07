package com.leonenko.epi._4_primitive;

import java.util.stream.LongStream;

/**
 * Created by Alex on 5/5/2017.
 */
class _43_ReverseBits {

    private static final int WORD_SIZE = 16;
    private static final int MASK = 0xffff;
    private static final long[] WORD_REVERSAL_TABLE = createLookupTable();

    static long reverseBits(long number) {
        var word1 = WORD_REVERSAL_TABLE[(int) ((number >>> 3 * WORD_SIZE) & MASK)];
        var word2 = WORD_REVERSAL_TABLE[(int) ((number >>> 2 * WORD_SIZE) & MASK)] << WORD_SIZE;
        var word3 = WORD_REVERSAL_TABLE[(int) ((number >>> WORD_SIZE) & MASK)] << (2 * WORD_SIZE);
        var word4 = WORD_REVERSAL_TABLE[(int) (number & MASK)] << (3 * WORD_SIZE);
        return word1 | word2 | word3 | word4;
    }

    private static long[] createLookupTable() {
        return LongStream.range(0, Short.MAX_VALUE - Short.MIN_VALUE + 1)
                         .map(i -> Long.reverse(i) >> 48 & MASK)
                         .toArray();
    }
}
