package com.leonenko.epi._24_honor_TODO;

import java.util.List;

/**
 * Created by Alex on 6/21/2017.
 *
 * http://www.geeksforgeeks.org/k-th-element-two-sorted-arrays/
 */
public class _2416_KSmallestInTwoSortedArrays {

    static int getKSmallest(
            List<Integer> first,
            List<Integer> second,
            int k) {

        var left = Integer.max(0, k - second.size());
        var right = Integer.min(first.size(), k);

        while (left < right) {
            var mid = left + (right - left) / 2;

            var firstMid1 = mid - 1 >= 0
                    ? first.get(mid - 1)
                    : Integer.MIN_VALUE;

            var firstMid2 = mid < first.size()
                    ? first.get(mid)
                    : Integer.MAX_VALUE;

            var secondMid1 = k - mid - 1 >= 0
                    ? second.get(k - mid - 1)
                    : Integer.MIN_VALUE;

            var secondMid2 = k - mid < second.size()
                    ? second.get(k - mid)
                    : Integer.MAX_VALUE;

            if (firstMid2 < secondMid1) {
                left = mid + 1;
            } else if (firstMid1 > secondMid2) {
                right = mid - 1;
            } else {
                return Math.max(firstMid1, secondMid1);
            }
        }

        var firstValue = left - 1 < 0
                ? Integer.MIN_VALUE
                : first.get(left - 1);

        var secondValue = k - left - 1 < 0
                ? Integer.MIN_VALUE
                : second.get(k - left - 1);

        return Math.max(firstValue, secondValue);
    }
}
