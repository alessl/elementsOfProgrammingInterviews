package com.leonenko.epi._24_honor_TODO;

/**
 * Created by Alex on 5/4/2017.
 */
public class _247_IdentifyPositionsAttackedByRooks {

    public static void markAttackedPositions(int[][] board) {
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
