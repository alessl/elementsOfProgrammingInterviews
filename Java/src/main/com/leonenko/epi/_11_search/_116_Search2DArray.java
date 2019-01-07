package com.leonenko.epi._11_search;

import lombok.Value;

import java.util.List;

public class _116_Search2DArray {

    static MatrixEntry findEntry(List<List<Integer>> matrix, int targetKey) {
        var row = 0;
        var col = matrix.get(0).size() - 1;

        while (row < matrix.size() && col >= 0) {
            var currKey = matrix.get(row).get(col);

            if (currKey == targetKey) {
                return new MatrixEntry(row, col);
            } else if (currKey < targetKey) {
                row++;
            } else {
                col--;
            }
        }

        return null;
    }

    @Value
    static class MatrixEntry {
        private int row;
        private int col;
    }
}
