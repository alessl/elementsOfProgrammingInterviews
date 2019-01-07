package com.leonenko.epi._24_honor_TODO;

import java.util.Arrays;
import java.util.function.Function;

public class _2433_MaximumRectangleSubMatrix_TODO {

    public static void main(String[] args) {
        Integer[][] matrix = {
                {1, 0, 1, 1},
                {1, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 0, 1},
        };
        printMaxRectangleSubMatrix(matrix, _2433_MaximumRectangleSubMatrix_TODO::getMaxRectangleSubMatrixSize1);
        printMaxRectangleSubMatrix(matrix, _2433_MaximumRectangleSubMatrix_TODO::getMaxRectangleSubMatrixSize2);
        printMaxSquareSubMatrix(matrix, _2433_MaximumRectangleSubMatrix_TODO::getMaxSquareSubMatrixSize);
    }

    static int getMaxRectangleSubMatrixSize1(Integer[][] matrix) {
        var table = getRectangleHeightWidthTable(matrix);

        print("Table", table);

        var maxRectangleArea = 0;

        for (var i = 0; i < matrix.length; i++) {
            for (var j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1 && table[i][j].area() > maxRectangleArea) {
                    var minWidth = Integer.MAX_VALUE;

                    for (var k = 0; k < table[i][j].height; k++) {
                        minWidth = Math.min(minWidth, table[i + k][j].width);
                        maxRectangleArea = Math.max(maxRectangleArea, minWidth * (k + 1));
                    }
                }
            }
        }

        return maxRectangleArea;
    }

    static int getMaxRectangleSubMatrixSize2(Integer[][] matrix) {
        int[] table = new int[matrix.length];
        int maxRectangleArea = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                table[col] = matrix[row][col] == 1 ? table[col] + 1 : 0;
            }
            maxRectangleArea = Math.max(maxRectangleArea, calculateMaxRectangle(table));
        }

        return maxRectangleArea;
    }

    private static int calculateMaxRectangle(int[] table) {
        return 0;
    }

    static int getMaxSquareSubMatrixSize(Integer[][] matrix) {
        var rectangleHWTable = getRectangleHeightWidthTable(matrix);

        var squareSideLenTable = new int[matrix.length][matrix[0].length];

        var maxSquareArea = 0;

        for (int row = matrix.length - 1; row >= 0; row--) {
            for (int col = matrix.length - 1; col >= 0; col--) {
                var side = Math.min(rectangleHWTable[row][col].height,
                        rectangleHWTable[row][col].width);

                if (matrix[row][col] == 1) {
                    if (row + 1 < matrix.length && col + 1 < matrix[row + 1].length) {
                        side = Math.min(side, squareSideLenTable[row + 1][col + 1] + 1);
                    }
                    squareSideLenTable[row][col] = side;
                    maxSquareArea = Math.max(maxSquareArea, side * side);
                }
            }
        }

        return maxSquareArea;
    }

    private static HeightAndWidth[][] getRectangleHeightWidthTable(Integer[][] matrix) {
        var table = new HeightAndWidth[matrix.length][matrix[0].length];

        for (int row = table.length - 1; row >= 0; row--) {
            for (int col = table.length - 1; col >= 0; col--) {
                table[row][col] = getRectangleHeightAndWidth(matrix, table, row, col);
            }
        }

        return table;
    }

    private static HeightAndWidth getRectangleHeightAndWidth(Integer[][] matrix,
                                                             HeightAndWidth[][] table,
                                                             int row,
                                                             int col) {
        var height = 0;
        var width = 0;
        if (matrix[row][col] == 1) {
            height = row + 1 < matrix.length ? table[row + 1][col].height + 1 : 1;
            width = col + 1 < matrix[row].length ? table[row][col + 1].width + 1 : 1;
        }
        return new HeightAndWidth(height, width);
    }

    private static void printMaxRectangleSubMatrix(Integer[][] matrix,
                                                   Function<Integer[][], Integer> c) {
        print("Matrix", matrix);
        System.out.println("Maximum rectangular sub-array=" + c.apply(matrix));
    }

    private static void printMaxSquareSubMatrix(Integer[][] matrix,
                                                Function<Integer[][], Integer> c) {
        print("Matrix", matrix);
        System.out.println("Maximum square sub-array=" + c.apply(matrix));
    }

    private static void print(String tableName, Object[][] table) {
        System.out.println(tableName);
        Arrays.stream(table).forEach(row -> System.out.println(Arrays.toString(row)));
    }

    private static final class HeightAndWidth {
        private int height;
        private int width;

        public HeightAndWidth(int height, int width) {
            this.height = height;
            this.width = width;
        }

        int area() {
            return width * height;
        }

        @Override
        public String toString() {
            return String.format("(%s,%s)", height, width);
        }
    }
}
