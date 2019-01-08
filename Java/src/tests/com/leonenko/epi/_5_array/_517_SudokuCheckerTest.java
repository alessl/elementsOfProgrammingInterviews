package com.leonenko.epi._5_array;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._15_rec.SudokuBoardGenerator.*;
import static com.leonenko.epi._15_rec._159_SudokuSolver.solve;
import static com.leonenko.epi._5_array._517_SudokuChecker.isValid;
import static org.assertj.core.api.Assertions.assertThat;

class _517_SudokuCheckerTest {

    private static final int REGION_SIZE = 3;

    @Test
    void testSolvedBoardIsValid() {
        int[][] sudokuBoard = generateZeroedSudokuBoard(REGION_SIZE);

        assertThat(solve(sudokuBoard)).isTrue();

        assertThat(isValid(sudokuBoard)).isTrue();
    }

    @Test
    void testIncompleteBoardIsValid() {
        int[][] sudokuBoard = generateZeroedSudokuBoard(REGION_SIZE);

        assertThat(isValid(sudokuBoard)).isTrue();
    }

    @Test
    void testColumnDuplicatesIsInvalid() {
        var sudokuBoard = generateZeroedSudokuBoard(REGION_SIZE);

        assertThat(solve(sudokuBoard)).isTrue();

        int duplicateCol = sudokuBoard[0].length - 1;
        sudokuBoard[sudokuBoard.length - 1][duplicateCol] = sudokuBoard[0][duplicateCol];

        printSudokuBoard(sudokuBoard);

        assertThat(isValid(sudokuBoard)).isFalse();
    }

    @Test
    void testRowDuplicatesIsInvalid() {
        var sudokuBoard = generateZeroedSudokuBoard(REGION_SIZE);

        assertThat(solve(sudokuBoard)).isTrue();

        int duplicateRow = 0;
        sudokuBoard[duplicateRow][0] = sudokuBoard[duplicateRow][sudokuBoard[0].length - 1];

        printSudokuBoard(sudokuBoard);

        assertThat(isValid(sudokuBoard)).isFalse();
    }

    @Test
    void testRegionDuplicatesIsInvalid() {
        var sudokuBoard = generateZeroedSudokuBoard(REGION_SIZE);

        assertThat(solve(sudokuBoard)).isTrue();

        int duplicateRow = 0;
        sudokuBoard[duplicateRow][0] = sudokuBoard[duplicateRow][1];

        printSudokuBoard(sudokuBoard);

        assertThat(isValid(sudokuBoard)).isFalse();
    }

}