package com.leonenko.epi._11_search;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class _118_KthLargestElement {

    private static Random rand = new Random();

    static String findKLargestElement(List<String> list, int k) {
        var leftIndex = 0;
        var rightIndex = list.size() - 1;

        while (leftIndex <= rightIndex) {
            var pivotIndex = partition(list, leftIndex, rightIndex);

            if (pivotIndex == k - 1) {
                return list.get(pivotIndex);
            } else if (pivotIndex < k - 1) {
                leftIndex = pivotIndex + 1;
            } else {
                rightIndex = pivotIndex - 1;
            }
        }

        return null;
    }

    private static int partition(List<String> list, int leftIndex, int rightIndex) {
        Collections.swap(list, randomIndex(leftIndex, rightIndex), rightIndex);

        var pivotValue = list.get(rightIndex);
        var newPivotIndex = leftIndex;

        for (int i = leftIndex; i < rightIndex; i++) {
            if (list.get(i).compareTo(pivotValue) >= 0) {
                Collections.swap(list, i, newPivotIndex);
                newPivotIndex++;
            }
        }

        Collections.swap(list, newPivotIndex, rightIndex);

        return newPivotIndex;
    }

    static String findKLargestElementWithDuplicates(List<String> list, int k) {
        var leftIndex = 0;
        var rightIndex = list.size() - 1;

        while (leftIndex <= rightIndex) {
            var pivotIndices = partitionWithEqualElements(list, leftIndex, rightIndex);

            if (pivotIndices[0] == k - 1) {
                return list.get(pivotIndices[0]);
            } else if (pivotIndices[1] < k - 1) {
                leftIndex = pivotIndices[1] + 1;
            } else {
                rightIndex = pivotIndices[0] - 1;
            }
        }

        throw new NoSuchElementException();
    }

    /*

    PARTITION'(A, p, r)
    x = A[p]
    i = h = p
    for j = p + 1 to r
        // Invariant: A[p..i - 1] < x, A[i..h] = x, A[h + 1..j - 1] > x, A[j..r] unknown.
        if A[j] < x
            y = A[j]
            A[j] = A[h + 1]
            A[h + 1] = A[i]
            A[i] = y
            i = i + 1
            h = h + 1
        else if A[j] == x
            exchange A[h + 1] with A[j]
            h = h + 1
    return (i, h)

     */

    private static int[] partitionWithEqualElements(List<String> list, int leftIndex, int rightIndex) {
        Collections.swap(list, randomIndex(leftIndex, rightIndex), leftIndex);

        var pivotValue = list.get(leftIndex);
        var equalStartIndex = leftIndex;
        var equalEndIndex = leftIndex;

        for (int currIndex = leftIndex + 1; currIndex <= rightIndex; currIndex++) {
            var value = list.get(currIndex);

            if (value.compareTo(pivotValue) < 0) {
                var currValue = list.get(currIndex);

                list.set(currIndex, list.get(equalEndIndex + 1));
                list.set(equalEndIndex + 1, list.get(equalStartIndex));
                list.set(equalStartIndex, currValue);

                equalStartIndex++;
                equalEndIndex++;

            } else if (value.compareTo(pivotValue) == 0) {
                Collections.swap(list, equalEndIndex + 1, currIndex);

                equalEndIndex++;
            }
        }

        return new int[] {equalStartIndex, equalEndIndex};
    }

    private static int randomIndex(int leftIndex, int rightIndex) {
        return leftIndex + rand.nextInt(rightIndex - leftIndex + 1);
    }
}
