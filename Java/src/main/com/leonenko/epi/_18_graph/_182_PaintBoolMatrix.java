package com.leonenko.epi._18_graph;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Alex on 5/12/2017.
 */
public class _182_PaintBoolMatrix {

    private static int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static void flipRegionDfs(boolean[][] m, int row, int col) {
        var colorToFlip = m[row][col];

        m[row][col] = !colorToFlip;

        for (int[] direction : DIRECTIONS) {
            var nextRow = row + direction[0];
            var nextCol = col + direction[1];

            if (isLegalPoint(m, nextRow, nextCol, colorToFlip)) {
                flipRegionDfs(m, nextRow, nextCol);
            }
        }
    }

    static void flipRegionBfs(boolean[][] matrix, int startRow, int startCol) {
        var colorToFlip = matrix[startRow][startCol];

        var queue = new LinkedList<>(List.of(new Point(startRow, startCol)));

        while (!queue.isEmpty()) {
            visitPoint(queue, matrix, colorToFlip);
        }
    }

    private static void visitPoint(Queue<Point> queue, boolean[][] matrix, boolean colorToFlip) {
        var currPoint = queue.poll();

        matrix[currPoint.row()][currPoint.col()] = !colorToFlip;

        for (int[] direction : DIRECTIONS) {
            var nextRow = currPoint.row() + direction[0];
            var nextCol = currPoint.col() + direction[1];

            if (isLegalPoint(matrix, nextRow, nextCol, colorToFlip)) {
                queue.add(new Point(nextRow, nextCol));
            }
        }
    }

    private static boolean isLegalPoint(boolean[][] matrix, int row, int col, boolean startColor) {
        boolean isRowWithinBounds = row >= 0 && row < matrix.length;
        boolean isColWithinBounds = col >= 0 && col < matrix[row].length;
        return isRowWithinBounds && isColWithinBounds && matrix[row][col] == startColor;
    }
}
