package com.leonenko.epi._15_rec_TODO;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.leonenko.epi._15_rec_TODO.SudokuBoardGenerator.generateZeroedSudokuBoard;
import static com.leonenko.epi._15_rec_TODO.SudokuBoardGenerator.printSudokuBoard;
import static com.leonenko.epi._15_rec_TODO._159_SudokuSolver.solve;
import static com.leonenko.epi._5_array._517_SudokuChecker.isValid;
import static org.assertj.core.api.Assertions.assertThat;

class _159_SudokuSolverTest {

    private static final Random RAND = new Random();

    @Test
    void testSolveRandomBoard() {
        int[][] sudokuBoard = generateZeroedSudokuBoard(3);

        assertThat(solve(sudokuBoard)).isTrue();
        assertThat(isValid(sudokuBoard)).isTrue();

        System.out.println("Solved #1:");
        printSudokuBoard(sudokuBoard);

        zeroRandomEntries(sudokuBoard);

        System.out.println("Unsolved:");
        printSudokuBoard(sudokuBoard);

        assertThat(solve(sudokuBoard)).isTrue();
        assertThat(isValid(sudokuBoard)).isTrue();

        System.out.println("Solved #2:");
        printSudokuBoard(sudokuBoard);
    }

    private void zeroRandomEntries(int[][] sudokuBoard) {
        for (int i = 0; i < (sudokuBoard.length * sudokuBoard.length) / 1.5; i++) {
            var row = RAND.nextInt(sudokuBoard.length);
            var col = RAND.nextInt(sudokuBoard.length);
            sudokuBoard[row][col] = 0;
        }
    }

    @Test
    void testCanNotSolveUnsolvableBoard() {
        int[][] sudokuBoard = generateZeroedSudokuBoard(3);

        assertThat(solve(sudokuBoard)).isTrue();
        assertThat(isValid(sudokuBoard)).isTrue();

        System.out.println("Solved #1:");
        printSudokuBoard(sudokuBoard);

        zeroRandomEntries(sudokuBoard);
        duplicateRandomEntries(sudokuBoard);

        System.out.println("Unsolved:");
        printSudokuBoard(sudokuBoard);

        assertThat(solve(sudokuBoard)).isFalse();
        assertThat(isValid(sudokuBoard)).isFalse();

        System.out.println("Unsolved #2:");
        printSudokuBoard(sudokuBoard);
    }

    private void duplicateRandomEntries(int[][] sudokuBoard) {
        for (int i = 0; i < 3; i++) {
            var fromRow = RAND.nextInt(sudokuBoard.length);
            var fromCol = RAND.nextInt(sudokuBoard.length);

            var toRow = RAND.nextInt(sudokuBoard.length);
            var toCol = RAND.nextInt(sudokuBoard.length);

            sudokuBoard[toRow][toCol] = sudokuBoard[fromRow][fromCol];
        }
    }
}