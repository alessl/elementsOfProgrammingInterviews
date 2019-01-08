package com.leonenko.epi._17_greedy_TODO;

import java.util.List;

public class _177_MaxWaterTrappedByPairOfVerticalLines {

    public static int getMaxTrappedWater(List<Integer> lineHeights) {
        var leftIndex = 0;
        var rightIndex = lineHeights.size() - 1;
        var maxWater = 0;

        while (leftIndex < rightIndex) {
            var leftToRightDistance = rightIndex - leftIndex;
            var leftHeight = lineHeights.get(leftIndex);
            var rightHeight = lineHeights.get(rightIndex);

            maxWater = Math.max(maxWater, leftToRightDistance * Math.min(leftHeight, rightHeight));

            if (leftHeight > rightHeight) {
                rightIndex--;
            } else if (leftHeight < rightHeight) {
                leftIndex++;
            } else {
                leftIndex++;
                rightIndex--;
            }
        }

        return maxWater;
    }

}
