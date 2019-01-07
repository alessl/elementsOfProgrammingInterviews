package com.leonenko.epi._24_honor_TODO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Alex on 6/21/2017.
 *
 * http://www.geeksforgeeks.org/k-th-element-two-sorted-arrays/
 */
public class _2416_KSmallestInTwoSortedArrays_TODO {

    public static void main(String[] args) {
        // 1, 4, 7, 8, 8, 10, 12, 20, 25, 25, 30
        List<Integer> a1 = Arrays.asList(4, 10, 12, 25, 30);
        List<Integer> a2 = Arrays.asList(1, 7, 8, 8, 20);
        printMedian(a1, a2, 1);
        printMedian(a1, a2, 2);
        printMedian(a1, a2, 3);
        printMedian(a1, a2, 4);
        printMedian(a1, a2, 5);
        printMedian(a1, a2, 8);
        printMedian(a1, a2, 9);
    }

    private static void printMedian(List<Integer> first, List<Integer> second, int k) {
        List<Integer> merged = new ArrayList<>();
        merged.addAll(first);
        merged.addAll(second);
        Collections.sort(merged);

        System.out.printf("smallest(%s) %s = %s%n", k, merged, getKSmallest(first, second, k));
    }

    private static int getKSmallest(
            List<Integer> first, List<Integer> second, int k) {
        int left = Integer.max(0, k - second.size());
        int right = Integer.min(first.size(), k);
        while (left < right) {
            int mid = left + (right - left) / 2;
            int firstMid1 = mid - 1 >= 0 ? first.get(mid - 1) : Integer.MIN_VALUE ;
            int firstMid2 = mid < first.size() ? first.get(mid) : Integer.MAX_VALUE;
            int secondMid1 = k - mid - 1 >= 0 ? second.get(k - mid - 1) : Integer.MIN_VALUE ;
            int secondMid2 = k - mid < second.size() ? second.get(k - mid) : Integer.MAX_VALUE;
            if (firstMid2 < secondMid1) {
                left = mid + 1;
            } else if (firstMid1 > secondMid2) {
                right = mid - 1;
            } else {
                return Math.max(firstMid1, secondMid1);
            }
        }
        int firstValue = left - 1 < 0 ? Integer.MIN_VALUE : first.get(left - 1);
        int secondValue = k - left - 1 < 0 ? Integer.MIN_VALUE : second.get(k - left - 1);
        return Math.max(firstValue, secondValue);
    }
}
