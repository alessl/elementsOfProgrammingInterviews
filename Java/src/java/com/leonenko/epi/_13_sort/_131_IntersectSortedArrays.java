package com.leonenko.epi._13_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alex on 5/12/2017.
 */
public class _131_IntersectSortedArrays {

    static int[] intersectByMerge(int[] firstArray, int[] secondArray) {
        var intersection = new LinkedList<Integer>();
        var firstIdx = 0;
        var secondIdx = 0;

        while (firstIdx < firstArray.length && secondIdx < secondArray.length) {
            var isFirstEqualToSecond = firstArray[firstIdx] == secondArray[secondIdx];
            var isCurrentNotEqualToLast =
                    intersection.isEmpty() || intersection.getLast() != firstArray[firstIdx];

            if (isFirstEqualToSecond && isCurrentNotEqualToLast) {
                intersection.add(firstArray[firstIdx]);
                firstIdx++;
                secondIdx++;
            } else if (firstArray[firstIdx] < secondArray[secondIdx]) {
                firstIdx++;
            } else {
                secondIdx++;
            }
        }

        return toArray(intersection);
    }

    static int[] intersectByBinarySearch(int[] firstArray, int[] secondArray) {
        var isFirstArraySmaller = firstArray.length < secondArray.length;
        var smallerArray = isFirstArraySmaller ? firstArray : secondArray;
        var biggerArray = isFirstArraySmaller ? secondArray : firstArray;

        var intersection = new ArrayList<Integer>();

        for (int n : smallerArray) {
            if ((intersection.isEmpty() || intersection.get(intersection.size() - 1) != n)
                    && Arrays.binarySearch(biggerArray, n) >= 0) {
                intersection.add(n);
            }
        }

        return toArray(intersection);
    }

    private static int[] toArray(List<Integer> intersection) {
        return intersection.stream()
                           .mapToInt(i -> i)
                           .toArray();
    }

}
