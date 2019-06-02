package com.leonenko.epi._24_honor_TODO;

import java.util.Arrays;

/**
 * Created by Alex on 5/4/2017.
 */
public class _2438_LongestSubArrayWithSumLessOrEqualK {

    static int[] getSubArray(int[] a, int maxSum) {
        var prefixSum = new int[a.length];

        prefixSum[0] = a[0];

        for (int i = 1; i < a.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + a[i];
        }

        System.out.println(Arrays.toString(prefixSum));

        var minPrefixSum = new int[a.length];

        minPrefixSum[a.length - 1] = prefixSum[a.length - 1];

        for (int i = a.length - 2; i >= 0; i--) {
            minPrefixSum[i] = Math.min(minPrefixSum[i + 1], minPrefixSum[i]);
        }

        System.out.println(Arrays.toString(minPrefixSum));

        var maxLen = 0;
        var maxStart = 0;
        var start = 0;
        var end = 0;

        while (end < a.length){
            int sum = start > 0 ? minPrefixSum[end] - prefixSum[start - 1] : prefixSum[start];
            if (sum < maxSum) {
                if (end - start + 1 > maxLen) {
                    maxLen = end - start + 1;
                    maxStart = start;
                }
                end++;
            } else {
                start++;
            }
        }

        return Arrays.copyOfRange(a, maxStart, maxStart + maxLen);
    }
}
