package com.leonenko.epi._11_search;

import java.util.List;

public class _113_FindMinInSortedArrayThatWasRotated {

    static int getMinIndex(List<Integer> rotatedSortedNumbers) {
        var lowIndex = 0;
        var highIndex = rotatedSortedNumbers.size() - 1;

        while (lowIndex < highIndex) {
            var middleIndex = lowIndex + (highIndex - lowIndex) / 2;
            var middleNumber = rotatedSortedNumbers.get(middleIndex);

            if (middleNumber > rotatedSortedNumbers.get(highIndex)) {
                lowIndex = middleIndex + 1;
            } else {
                highIndex = middleIndex;
            }

        }
        return lowIndex;
    }

}
