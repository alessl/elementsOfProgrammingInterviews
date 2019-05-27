package com.leonenko.epi._24_honor_TODO;

import java.util.Arrays;

/**
 * Created by Alex on 5/6/2017.
 */
public class _2428_CountInversions {

    static int getNumInversions(int[] a) {
        return sortAndCount(a, 0, a.length - 1, new int[a.length]);
    }

    private static int sortAndCount(int[] a, int from, int to, int[] temp) {
        if (from >= to) {
            return 0;
        }
        int mid = from + (to - from) / 2;

        int numInversions =
                sortAndCount(a, from, mid, temp) + sortAndCount(a, mid + 1, to, temp);
        System.arraycopy(a, from, temp, from, to - from + 1);

        numInversions += mergeAndCount(a, from, mid, to, temp);
        return numInversions;
    }

    private static int mergeAndCount(
            int[] a, int from, int mid, int to, int[] temp) {
        int left = from;
        int right = mid + 1;
        int mergeIndex = from;
        int numInversions = 0;
        while (left <= mid && right <= to) {
            if (temp[left] <= temp[right]) {
                a[mergeIndex] = temp[left++];
            } else {
                numInversions += mid - left + 1;
                a[mergeIndex] = temp[right++];
            }
            mergeIndex++;
        }
        while (left <= mid) {
            a[mergeIndex++] = temp[left++];
        }
        while (right <= to) {
            a[mergeIndex++] = temp[right++];
        }
        return numInversions;
    }
}
