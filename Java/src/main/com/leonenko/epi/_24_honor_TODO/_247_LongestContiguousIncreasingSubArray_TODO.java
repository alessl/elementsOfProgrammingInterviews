package com.leonenko.epi._24_honor_TODO;

import java.util.Arrays;

/**
 * Created by Alex on 5/4/2017.
 */
public class _247_LongestContiguousIncreasingSubArray_TODO {

    public static void main(String[] args) {
        int[] array = {2, 11, 3, 5, 13, 15, 7, 19, 20, 17, 25, 27, 30, 31, 50, 10, 11};
        System.out.println(Arrays.toString(array));

        int[] maxIncSubArray = getMaxIncSubArray(array);
        System.out.println(Arrays.toString(maxIncSubArray));
    }

    static int[] getMaxIncSubArray(int[] array) {
        int maxStart = 0;
        int maxLen = 1;

        int start = 0;
        int end = 0;
        while (end < array.length - 1) {
            while (end < array.length - 1
                    && array[end] < array[end + 1]) {
                end++;
            }

            int len = end - start + 1;

            if (maxLen < len) {
                maxLen = len;
                maxStart = start;
            }

            int newStart = end + len;

            while (newStart < array.length
                    && array[newStart - 1] < array[newStart]) {
                newStart--;
            }

            start = newStart;
            end += len;
        }

        return Arrays.copyOfRange(array, maxStart, maxStart + maxLen);
    }
}
