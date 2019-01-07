package com.leonenko.epi._5_array;

import java.util.Random;
import java.util.StringJoiner;

/**
 * Created by Alex on 4/29/2017.
 */
public class MineSweeper {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        boolean[][] board = getBoard(10, 10, 0.3);
        printBoard(board);
        int[][] bombCount = countBombs(board);
        printBoard(bombCount, board);
    }

    private static void printBoard(boolean[][] board) {
        System.out.println("Board");

        for (boolean[] row : board) {
            StringJoiner rowStr = new StringJoiner(" ");

            for (boolean val : row) {
                if (val) {
                    rowStr.add("*");
                } else {
                    rowStr.add(".");
                }
            }

            System.out.println(rowStr);
        }
    }

    private static void printBoard(int[][] bombCount, boolean[][] board) {
        System.out.println("BombCount");

        for (int row = 0; row < board.length; row++) {
            StringJoiner rowStr = new StringJoiner(" ");

            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col]) {
                    rowStr.add("*");
                } else {
                    rowStr.add(Integer.toString(bombCount[row][col]));
                }
            }

            System.out.println(rowStr);
        }
    }

    private static int[][] countBombs(boolean[][] board) {
        int[][] bombCount = new int[board.length][board[0].length];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col]) {
                    continue;
                }

                countAdjacentBombs(board, bombCount, row, col);
            }
        }
        return bombCount;
    }

    private static void countAdjacentBombs(
            boolean[][] board, int[][] bombCount, int row, int col) {
        for (int adjRow = row - 1; adjRow <= row + 1; adjRow++) {
            for (int adjCol = col - 1; adjCol <= col + 1; adjCol++) {
                if (isOnBoard(board, adjRow, adjCol) && board[adjRow][adjCol]) {
                    bombCount[row][col]++;
                }
            }
        }
    }

    private static boolean isOnBoard(boolean[][] board, int adjRow, int adjCol) {
        return adjRow >= 0 && adjRow < board.length
                && adjCol >= 0 && adjCol < board[adjRow].length;
    }

    private static boolean[][] getBoard(int numRows, int numCols, double bombProb) {
        boolean[][] board = new boolean[numRows][numCols];
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                board[row][col] = RANDOM.nextDouble() < bombProb;
            }
        }
        return board;
    }
}
