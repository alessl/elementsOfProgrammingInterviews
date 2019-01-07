package com.leonenko.epi._5_array;

import java.util.HashSet;

/**
 * Created by Alex on 4/29/2017.
 */
public class _517_SudokuChecker {

    public static boolean isValid(int[][] sudokuBoard) {
        for (int i = 0; i < sudokuBoard.length; i++) {
            if (hasDuplicates(sudokuBoard, i, i + 1, 0, sudokuBoard.length)) {
                return false;
            }
        }

        for (int i = 0; i < sudokuBoard.length; i++) {
            if (hasDuplicates(sudokuBoard, 0, sudokuBoard.length, i, i + 1)) {
                return false;
            }
        }

        var regionSize = (int) Math.sqrt(sudokuBoard.length);

        for (int i = 0; i < regionSize; i++) {
            for (int j = 0; j < regionSize; j++) {
                if (hasDuplicates(sudokuBoard,
                        regionSize * i, regionSize * (i + 1),
                        regionSize * j, regionSize * (j + 1))) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean hasDuplicates(int[][] sudokuBoard,
            int startRowIndex, int endRowIndex, int startColIndex, int endColIndex) {

        var usedDigits = new HashSet<>();

        for (int rowIndex = startRowIndex; rowIndex < endRowIndex; rowIndex++) {
            for (int colIndex = startColIndex; colIndex < endColIndex; colIndex++) {
                if (sudokuBoard[rowIndex][colIndex] != 0
                        && !usedDigits.add(sudokuBoard[rowIndex][colIndex])) {
                    return true;
                }
            }
        }

        return false;
    }

}
