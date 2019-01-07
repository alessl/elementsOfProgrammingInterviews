package com.leonenko.epi._5_array;

import java.util.ArrayList;
import java.util.List;

public class _518_SpiralOrderOf2DArray {

    private static final int[][] SHIFT = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    static List<Integer> getSpiralOrder1(List<List<Integer>> squareMatrix) {
        var spiralOrder = new ArrayList<Integer>();

        for (int offset = 0; offset < Math.ceil(squareMatrix.size() / 2.0); offset++) {

            if (offset == squareMatrix.size() - offset - 1) {
                spiralOrder.add(squareMatrix.get(offset).get(offset));
            } else {
                for (int i = offset; i < squareMatrix.size() - offset - 1; i++) {
                    spiralOrder.add(squareMatrix.get(offset).get(i));
                }
                for (int i = offset; i < squareMatrix.size() - offset - 1; i++) {
                    spiralOrder.add(squareMatrix.get(i).get(squareMatrix.size() - offset - 1));
                }
                for (int i = squareMatrix.size() - offset - 1; i > offset; i--) {
                    spiralOrder.add(squareMatrix.get(squareMatrix.size() - offset - 1).get(i));
                }
                for (int i = squareMatrix.size() - offset - 1; i > offset; i--) {
                    spiralOrder.add(squareMatrix.get(i).get(offset));
                }
            }
        }

        return spiralOrder;
    }

    static List<Integer> getSpiralOrder2(List<List<Integer>> squareMatrix) {
        var spiralOrder = new ArrayList<Integer>();

        int dir = 0;
        int row = 0;
        int col = 0;

        for (int i = 0; i < squareMatrix.size() * squareMatrix.size(); i++) {
            spiralOrder.add(squareMatrix.get(row).get(col));

            squareMatrix.get(row).set(col, null);

            int nextRow = row + SHIFT[dir][0];
            int nextCol = col + SHIFT[dir][1];

            boolean isNextIllegal = nextRow < 0
                    || nextRow >= squareMatrix.size()
                    || nextCol < 0
                    || nextCol >= squareMatrix.size()
                    || squareMatrix.get(nextRow).get(nextCol) == null;
            if (isNextIllegal) {
                dir = (dir + 1) % 4;
                nextRow = row + SHIFT[dir][0];
                nextCol = col + SHIFT[dir][1];
            }

            row = nextRow;
            col = nextCol;
        }

        return spiralOrder;
    }
}
