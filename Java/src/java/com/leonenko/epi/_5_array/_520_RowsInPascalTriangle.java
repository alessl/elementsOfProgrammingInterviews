package com.leonenko.epi._5_array;

import java.util.ArrayList;
import java.util.List;

public class _520_RowsInPascalTriangle {

    static List<List<Integer>> generatePascalTriangle(int numRows) {
        var pascalTriangle = new ArrayList<List<Integer>>();

        for (int i = 0; i < numRows; i++) {
            var currRow = new ArrayList<Integer>();

            for (int j = 0; j <= i; j++) {
                var currVal = 1;

                if (j > 0 && j < i) {
                    currVal = pascalTriangle.get(i - 1).get(j - 1)
                            + pascalTriangle.get(i - 1).get(j);
                }

                currRow.add(currVal);
            }

            pascalTriangle.add(currRow);
        }

        return pascalTriangle;
    }
}
