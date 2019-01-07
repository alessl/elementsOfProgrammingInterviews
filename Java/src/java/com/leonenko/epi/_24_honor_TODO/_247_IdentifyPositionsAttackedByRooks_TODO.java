package com.leonenko.epi._24_honor_TODO;

import java.util.Arrays;

/**
 * Created by Alex on 5/4/2017.
 */
public class _247_IdentifyPositionsAttackedByRooks_TODO {

    public static void main(String[] args) {
        int[][] board = {
                {1, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
        };
        Arrays.stream(board).map(Arrays::toString).forEach(System.out::println);
        markAttackedPositions(board);
        System.out.println();
        Arrays.stream(board).map(Arrays::toString).forEach(System.out::println);
    }

    private static void markAttackedPositions(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col] == 0) {
                    for (int i = 0; i < board[row].length; i++) {
                        board[row][i] = 2;
                    }
                    for (int i = 0; i < board.length; i++) {
                        board[i][col] = 2;
                    }
                }
            }
        }
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col] == 2) {
                    board[row][col] = 0;
                }
            }
        }
    }
}
