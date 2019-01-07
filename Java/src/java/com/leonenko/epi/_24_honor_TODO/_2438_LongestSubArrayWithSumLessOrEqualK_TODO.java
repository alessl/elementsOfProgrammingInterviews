package com.leonenko.epi._24_honor_TODO;

import java.util.Arrays;

/**
 * Created by Alex on 5/4/2017.
 */
public class _2438_LongestSubArrayWithSumLessOrEqualK_TODO {

    public static void main(String[] args) {
        int[] array = {342, -10, 639, 342, -14, 565, -924, 635, 167, -70};
        System.out.println("Array: " + Arrays.toString(array));
        int[] subArray = getSubArray(array, 184);
        System.out.println(
                "SubArray:" + Arrays.toString(subArray)
                        + ", Sum: " + Arrays.stream(subArray).sum());
    }

    private static int[] getSubArray(int[] a, int maxSum) {
        int[] prefixSum = new int[a.length];
        prefixSum[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + a[i];
        }
        System.out.println(Arrays.toString(prefixSum));

        int[] minPrefixSum = new int[a.length];
        minPrefixSum[a.length - 1] = prefixSum[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) {
            minPrefixSum[i] = Math.min(minPrefixSum[i + 1], minPrefixSum[i]);
        }
        System.out.println(Arrays.toString(minPrefixSum));

        int maxLen = 0;
        int maxStart = 0;
        int start = 0;
        int end = 0;
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
