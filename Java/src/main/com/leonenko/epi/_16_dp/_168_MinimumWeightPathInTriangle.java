package com.leonenko.epi._16_dp;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.min;

public class _168_MinimumWeightPathInTriangle {

    static int getMinPathSum(List<List<Integer>> triangle) {
        var prevRow = new ArrayList<>(triangle.get(0));

        for (int i = 1; i < triangle.size(); i++) {
            var currRow = new ArrayList<>(triangle.get(i));

            currRow.set(0, currRow.get(0) + prevRow.get(0));

            for (int j = 1; j < currRow.size() - 1; j++) {
                currRow.set(j, currRow.get(j) + Math.min(prevRow.get(j - 1), prevRow.get(j)));
            }

            currRow.set(currRow.size() - 1, currRow.get(currRow.size() - 1) + prevRow.get(prevRow.size() - 1));
            prevRow = currRow;
        }

        return min(prevRow);
    }
}
