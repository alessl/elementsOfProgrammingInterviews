package com.leonenko.epi._16_dp_TODO;

import java.util.stream.IntStream;

public class _165_SearchSequenceIn2DArray {

    static boolean searchPattern(int[][] grid, int[] pattern) {
        return IntStream.range(0, grid.length)
                        .dropWhile(row ->
                                IntStream.range(0, grid[row].length)
                                         .dropWhile(col -> !isPatternMatch(grid, row, col, pattern, 0))
                                         .findFirst()
                                         .isEmpty())
                        .findFirst()
                        .isPresent();
    }

    private static boolean isPatternMatch(int[][] grid,
                                          int rowIndex,
                                          int colIndex,
                                          int[] pat,
                                          int patIndex) {
        if (pat.length == patIndex) {
            return true;
        }

        var isRowOutsideGrid = rowIndex < 0 || rowIndex >= grid.length;
        var isColOutsideGrid = !isRowOutsideGrid && (colIndex < 0 || colIndex >= grid[rowIndex].length);

        if (isRowOutsideGrid || isColOutsideGrid) {
            return false;
        }

        if (grid[rowIndex][colIndex] == pat[patIndex]) {
            var temp = grid[rowIndex][colIndex];

            grid[rowIndex][colIndex] = Integer.MIN_VALUE;

            var isMatchUp = isPatternMatch(grid, rowIndex - 1, colIndex, pat, patIndex + 1);
            if (isMatchUp) {
                return true;
            }

            var isMatchDown = isPatternMatch(grid, rowIndex + 1, colIndex, pat, patIndex + 1);
            if (isMatchDown) {
                return true;
            }

            var isMatchRight = isPatternMatch(grid, rowIndex, colIndex + 1, pat, patIndex + 1);
            if (isMatchRight){
                return true;
            }

            boolean isMatchLeft = isPatternMatch(grid, rowIndex, colIndex - 1, pat, patIndex + 1);
            if (isMatchLeft) {
                return true;
            }

            grid[rowIndex][colIndex] = temp;

            return false;

        }

        return false;
    }

    static boolean searchPatternVisitingEachEntryOnce(int[][] grid, int[] pattern) {
        return IntStream.range(0, grid.length)
                        .dropWhile(row ->
                                IntStream.range(0, grid[row].length)
                                         .dropWhile(col -> !searchPatternVisitingEachEntryOnce(grid,
                                                 row, col, pattern, 0))
                                         .findFirst()
                                         .isEmpty())
                        .findFirst()
                        .isPresent();
    }

    private static boolean searchPatternVisitingEachEntryOnce(int[][] grid,
                                                              int rowIndex,
                                                              int colIndex,
                                                              int[] pat,
                                                              int patIndex) {
        if (pat.length == patIndex) {
            return true;
        }

        var isRowOutsideGrid = rowIndex < 0 || rowIndex >= grid.length;
        var isColOutsideGrid = !isRowOutsideGrid && (colIndex < 0 || colIndex >= grid[rowIndex].length);

        if (isRowOutsideGrid || isColOutsideGrid) {
            return false;
        }

        System.out.println(grid[rowIndex][colIndex]);

        if (grid[rowIndex][colIndex] == pat[patIndex]) {
            var temp = grid[rowIndex][colIndex];

            grid[rowIndex][colIndex] = Integer.MIN_VALUE;

            var isMatch = isPatternMatch(grid, rowIndex + 1, colIndex, pat, patIndex + 1)
                    || isPatternMatch(grid, rowIndex - 1, colIndex, pat, patIndex + 1)
                    || isPatternMatch(grid, rowIndex, colIndex + 1, pat, patIndex + 1)
                    || isPatternMatch(grid, rowIndex, colIndex - 1, pat, patIndex + 1);

            if (!isMatch) {
                grid[rowIndex][colIndex] = temp;
            }

            return isMatch;
        }

        return false;
    }
}
