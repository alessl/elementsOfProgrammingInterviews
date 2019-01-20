package com.leonenko.epi._16_dp;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by Alex on 5/12/2017.
 */
public class _163_NumberOfWaysToTraverse2DArray {

    static int countWaysToTraverseMatrix(int numRows, int numCols) {
        var table = new int[numRows][numCols];

        IntStream.range(0, table.length).forEach(i -> table[i][0] = 1);
        IntStream.range(0, table[0].length).forEach(i -> table[0][i] = 1);

        for (var i = 1; i < numRows; i++) {
            for (var j = 1; j < numCols; j++) {
                table[i][j] = table[i - 1][j] + table[i][j - 1];
            }
        }

        return table[numRows - 1][numCols - 1];
    }

    static int countWaysToTraverseMatrixOptimized(int numRows, int numCols) {
        var tableSize = Math.min(numRows, numCols);
        var table = new int[tableSize];

        table[0] = 1;

        for (var i = 0; i < Math.max(numRows, numCols); i++) {
            for (var j = 1; j < tableSize; j++) {
                table[j] += table[j - 1];
            }
        }

        return table[tableSize - 1];
    }

    static int countWaysToTraverseMatrixWithObstacles(int[][] matrix) {
        int[][] table = new int[matrix.length][matrix[0].length];

        IntStream.range(0, table.length)
                .forEach(i -> table[i][0] = matrix[i][0] != 1 ? 1 : 0);
        IntStream.range(0, table[0].length)
                .forEach(i -> table[0][i] = matrix[0][i] != 1 ? 1 : 0);

        for (int i = 1; i < table.length; i++) {
            for (int j = 1; j < table[i].length; j++) {
                if (matrix[i][j] != 1) {
                    table[i][j] = table[i - 1][j] + table[i][j - 1];
                }
            }
        }

        return table[table.length - 1][table[0].length - 1];
    }

    // https://www.geeksforgeeks.org/number-decimal-numbers-length-k-strict-monotone/
    static int countStrictMonotonesDP(int numSize) {
        int[][] table = new int[numSize][9];

        IntStream.range(0, table[0].length)
                .forEach(i -> table[0][i] = i + 1);

        for (int i = 1; i < numSize; i++) {
            for (int j = 1; j < 9; j++) {
                table[i][j] = table[i - 1][j - 1] + table[i][j - 1];
            }
        }

        Arrays.stream(table)
                .map(Arrays::toString)
                .forEach(System.out::println);

        return table[table.length - 1][table[0].length - 1];
    }

    // https://www.geeksforgeeks.org/counting-numbers-n-digits-monotone/
    static int countMonotonesDP(int numSize) {
        int[][] table = new int[numSize][9];

        IntStream.range(0, table[0].length)
                 .forEach(i -> table[0][i] = i + 1);
        IntStream.range(0, table.length)
                 .forEach(i -> table[i][0] = 1);

        for (int i = 1; i < numSize; i++) {
            for (int j = 1; j < 9; j++) {
                table[i][j] = table[i - 1][j] + table[i][j - 1];
            }
        }

        Arrays.stream(table)
              .map(Arrays::toString)
              .forEach(System.out::println);

        return table[table.length - 1][table[0].length - 1];
    }
}
