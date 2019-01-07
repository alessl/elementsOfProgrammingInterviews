package com.leonenko.epi._11_search;

import java.util.List;

public class _112_FindEntrySameAsIndexInSortedArray {

    public static int findEntryEqualToIndex(List<Integer> sortedNumbers) {
        var lowIndex = 0;
        var highIndex = sortedNumbers.size() - 1;

        while (lowIndex <= highIndex) {
            var middleIndex = lowIndex + (highIndex - lowIndex) / 2 ;
            var middleNumber = sortedNumbers.get(middleIndex);

            var diff = middleNumber - middleIndex;

            if (diff == 0) {
                return middleIndex;
            } else if (diff > 0) {
                lowIndex = middleIndex + diff;
            } else {
                highIndex = middleIndex - diff;
            }
        }

        return -1;
    }

}
