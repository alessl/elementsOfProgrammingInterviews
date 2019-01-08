package com.leonenko.epi._15_rec;

/**
 * Created by Alex on 5/4/2017.
 */
public class _159_SudokuSolver {

    public static boolean solve(int[][] board) {
        return solve(board, 0, 0);
    }

    private static boolean solve(int[][] board, int rowIndex, int colIndex) {
        if (rowIndex == board.length) {
            if (++colIndex < board[0].length) {
                rowIndex = 0;
            } else {
                return true;
            }
        }

        if (board[rowIndex][colIndex] > 0) {
            return solve(board, rowIndex + 1, colIndex);
        }

        for (int value = 1; value <= board.length; value++) {
            if (isLegalMove(board, rowIndex, colIndex, value)) {
                board[rowIndex][colIndex] = value;

                if (solve(board, rowIndex + 1, colIndex)) {
                    return true;
                } else {
                    board[rowIndex][colIndex] = 0;
                }
            }
        }

        return false;
    }

    private static boolean isLegalMove(int[][] board, int rowIndex, int colIndex, int value) {
        for (var row : board) {
            if (value == row[colIndex]) {
                return false;
            }
        }

        for (var colValue : board[rowIndex]) {
            if (colValue == value) {
                return false;
            }
        }

        var regionSize = (int) Math.sqrt(board.length);

        var startCol = colIndex / regionSize * regionSize;
        var endCol = startCol + regionSize;

        var startRow = rowIndex / regionSize * regionSize;
        var endRow = startRow + regionSize;

        for (var row = startRow; row < endRow; row++) {
            for (var col = startCol; col < endCol; col++) {
                if (value == board[row][col]) {
                    return false;
                }
            }
        }

        return true;
    }
}
