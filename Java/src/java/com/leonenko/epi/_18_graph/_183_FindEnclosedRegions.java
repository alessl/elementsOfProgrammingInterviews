package com.leonenko.epi._18_graph;

import static java.util.Arrays.setAll;

/**
 * Created by Alex on 5/12/2017.
 */
public class _183_FindEnclosedRegions {

    static final int O = 0;
    static final int X = 1;

    static void fillEnclosedRegions(int[][] m) {
        var visited = new boolean[m.length][];

        setAll(visited, i -> new boolean[m[i].length]);

        // visit 0 all cells reachable from the first and the last columns
        for (var row = 0; row < m.length; row++) {
            visit(m, row, 0, visited);
            visit(m, row, m[row].length - 1, visited);
        }

        // visit 0 all cells reachable from the first and the last rows
        for (var col = 0; col < m.length; col++) {
            visit(m, 0, col, visited);
            visit(m, m.length - 1, col, visited);
        }

        // set all unvisited 0 cells to 1
        for (int row = 1; row < m.length - 1; row++) {
            for (var col = 1; col < m[row].length - 1; col++) {
                if (!visited[row][col] && m[row][col] == O) {
                    m[row][col] = X;
                }
            }
        }
    }

    private static void visit(int[][] m, int row, int col, boolean[][] visited) {
        if (visited[row][col] || !isOpen(m, row, col)) {
            return;
        }

        visited[row][col] = true;

        for (int[] direction : Util.DIRECTIONS) {
            var nextRow = row + direction[0];
            var nextCol = col + direction[1];

            if (isLegalTransition(m, nextRow, nextCol, visited)) {
                visit(m, nextRow, nextCol, visited);
            }
        }
    }

    private static boolean isLegalTransition(int[][] m, int row, int col, boolean[][] visited) {
        var isWithinBounds = row >= 0 && row < m.length && col >= 0 && col < m[row].length;

        return isWithinBounds && isOpen(m, row, col) && !visited[row][col];
    }

    private static boolean isOpen(int[][] m, int row, int col) {
        return m[row][col] == O;
    }
}
