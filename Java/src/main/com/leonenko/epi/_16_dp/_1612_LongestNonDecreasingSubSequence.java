package com.leonenko.epi._16_dp;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by Alex on 5/8/2017.
 */
public class _1612_LongestNonDecreasingSubSequence {

    static int getLongestNonDecreasingSubSequence(int[] a) {
        var maxLen = IntStream.generate(() -> 1)
                              .limit(a.length)
                              .toArray();

        for (var i = 1; i < a.length; i++) {
            for (var j = 0; j < i; j++) {
                if (a[i] >= a[j]) {
                    maxLen[i] = Math.max(maxLen[i], maxLen[j] + 1);
                }
            }
        }

        return Arrays.stream(maxLen)
                     .max()
                     .orElse(1);
    }
}
