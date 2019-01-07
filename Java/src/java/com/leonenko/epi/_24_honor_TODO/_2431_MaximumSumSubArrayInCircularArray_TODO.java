package com.leonenko.epi._24_honor_TODO;

import java.util.Arrays;
import java.util.Comparator;

import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.reverseOrder;

/**
 * Created by Alex on 5/11/2017.
 */
public class _2431_MaximumSumSubArrayInCircularArray_TODO {

    public static void main(String[] args) {
        printCircularMaxSubArray(
                new int[] {1, -5, 2, 3, 5, -10, 5, -1, 8, 2, -10});
        printCircularMaxSubArray(
                new int[] {100, -5, 3, -3, -500, -100, 2, -20, 5, -1, 8, 50, 100});
        printCircularMaxSubArray(new int[]{100, -500, -100, -10, 50, 100});
    }

    private static void printCircularMaxSubArray(int[] a) {
        System.out.println(Arrays.toString(a));
        int[] maxSubArray = findMaxSumSubArray(a);
        System.out.printf(
                "%s, sum=%s%n", Arrays.toString(maxSubArray), Arrays.stream(maxSubArray).sum());
    }

    private static int[] findMaxSumSubArray(int[] a) {
        RangeSum maxRange = getMaxRangeSumByComparator(a, naturalOrder());
        RangeSum minRange = getMaxRangeSumByComparator(a, reverseOrder());
        int arraySum = Arrays.stream(a).sum();
        if (maxRange.sum > arraySum - minRange.sum) {
            return Arrays.copyOfRange(a, maxRange.start, maxRange.end);
        }
        int lenBeforeWrap = a.length - minRange.end - 1;
        int lenAfterWrap = minRange.start;
        int[] subArray = new int[lenBeforeWrap + lenAfterWrap];
        System.arraycopy(a, 0, subArray, 0, minRange.start);
        System.arraycopy(a, minRange.end + 1, subArray, minRange.start, lenBeforeWrap);
        return subArray;
    }

    private static RangeSum getMaxRangeSumByComparator(int[] a, Comparator<Integer> comparator) {
        int maxSum = 0;
        int maxStart = 0;
        int maxEnd = 0;
        int currSum = 0;
        int currStart = 0;
        for (int i = 0; i < a.length; i++) {
            currSum += a[i];
            if (comparator.compare(currSum, a[i]) < 0) {
                currSum = a[i];
                currStart = i;
            }
            if (comparator.compare(currSum, maxSum) > 0) {
                maxSum = currSum;
                maxStart = currStart;
                maxEnd = i;
            }
        }
        return new RangeSum(maxStart, maxEnd, maxSum);
    }

    private static final class RangeSum {
        private final int start;
        private final int end;
        private final int sum;

        RangeSum(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
        }
    }
}
