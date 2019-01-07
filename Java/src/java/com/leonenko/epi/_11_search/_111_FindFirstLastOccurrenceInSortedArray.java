package com.leonenko.epi._11_search;

import java.util.List;

public class _111_FindFirstLastOccurrenceInSortedArray {

    public static int findFirstIndex(List<Integer> sortedNumbers, int key) {
        return findLastIndex(sortedNumbers, key, true);
    }

    static int findLastIndex(List<Integer> sortedNumbers, int key) {
        return findLastIndex(sortedNumbers, key, false);
    }

    private static int findLastIndex(List<Integer> sortedNumbers, int key, boolean isFirstIndex) {
        var lowIndex = 0;
        var highIndex = sortedNumbers.size() - 1;
        var foundIndex = -1;

        while (lowIndex <= highIndex) {
            var middleIndex = lowIndex + (highIndex - lowIndex) / 2 ;
            var middleNumber = sortedNumbers.get(middleIndex);

            if (middleNumber == key) {
                if (isFirstIndex) {
                    highIndex = middleIndex - 1;
                } else {
                    lowIndex = middleIndex + 1;
                }

                foundIndex = middleIndex;

            } else if(middleNumber < key) {
                lowIndex = middleIndex + 1;
            } else {
                highIndex = middleIndex - 1;
            }
        }

        return foundIndex;
    }

    static int findFirstIndexSmallerThan(List<Integer> sortedNumbers, int key) {
        return findFirstIndexSmallerOrGreaterThan(sortedNumbers, key, true);
    }

    static int findFirstIndexGreterThan(List<Integer> sortedNumbers, int key) {
        return findFirstIndexSmallerOrGreaterThan(sortedNumbers, key, false);
    }

    private static int findFirstIndexSmallerOrGreaterThan(List<Integer> sortedNumbers, int key,
            boolean isSmaller) {

        var lowIndex = 0;
        var highIndex = sortedNumbers.size() - 1;

        while (lowIndex <= highIndex) {
            var middleIndex = lowIndex + (highIndex - lowIndex) / 2 ;
            var middleNumber = sortedNumbers.get(middleIndex);

            if (middleNumber == key) {
                if (isSmaller) {
                    highIndex = middleIndex - 1;
                } else {
                    lowIndex = middleIndex + 1;
                }


            } else if(middleNumber < key) {
                lowIndex = middleIndex + 1;
            } else {
                highIndex = middleIndex - 1;
            }
        }

        return isSmaller ? highIndex : lowIndex;
    }
}
