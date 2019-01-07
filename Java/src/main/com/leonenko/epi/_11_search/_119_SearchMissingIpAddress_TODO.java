package com.leonenko.epi._11_search;

import java.util.BitSet;

public class _119_SearchMissingIpAddress_TODO {

    private static final int WORD_SIZE = 16;
    private static final int NUM_BUCKETS = 1 << WORD_SIZE;

    static int findMissingElement(Iterable<Integer> consecutiveElements) {
        var count = new int[NUM_BUCKETS];

        for (var element : consecutiveElements) {
            count[element >>> WORD_SIZE]++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] < NUM_BUCKETS) {
                var bitSet = new BitSet(NUM_BUCKETS);

                for (var element : consecutiveElements) {
                    if (i == (element >>> WORD_SIZE)) {
                        bitSet.set((NUM_BUCKETS - 1) & element);
                    }
                }

                for (int j = 0; j < NUM_BUCKETS; j++) {
                    if (!bitSet.get(j)) {
                        return (i << WORD_SIZE) | j;
                    }
                }
            }
        }

        return -1;
    }
}
