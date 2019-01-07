package com.leonenko.epi._5_array;

import java.util.Arrays;
import java.util.Random;

import static java.util.stream.Collectors.joining;

/**
 * Created by Alex on 4/29/2017.
 */
public class MatrixOperations {

    private static final Random RANDOM = new Random();
    private static final int MAX_VALUE = 10;

    public static void main(String[] args) {
        multiplyAndPrint(3, 3, 3, 3);
        multiplyAndPrint(5, 2, 2, 4);
        multiplyAndPrint(1, 2, 2, 4);
    }

    private static void multiplyAndPrint(
            int numRows1, int numCols1, int numRows2, int numCols2) {
        int[][] m1 = getMatrix(numRows1, numCols1);
        printMatrix(m1);
        int[][] m2 = getMatrix(numRows2, numCols2);
        printMatrix(m2);
        int[][] p = multiply(m1, m2);
        printMatrix(p);
    }

    private static int[][] multiply(int[][] m1, int[][] m2) {
        int[][] product = new int[m1.length][m2[0].length];
        for (int row = 0; row < m1.length; row++) {
            for (int col = 0; col < m2[0].length; col++) {
                for (int i = 0; i < m1[0].length; i++) {
                    product[row][col] += m1[row][i] * m2[i][col];
                }
            }
        }
        return product;
    }

    private static void printMatrix(int[][] board) {
        Arrays.stream(board)
                .map(MatrixOperations::format)
                .forEach(System.out::println);
        System.out.println();
    }

    private static String format(int[] row) {
        return Arrays.stream(row)
                .mapToObj(i -> String.format("%-5s", i))
                .collect(joining(""));
    }

    private static int[][] getMatrix(int numRows, int numCols) {
        int maxValue = MAX_VALUE + 1;
        int[][] m = new int[numRows][numCols];
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                m[row][col] = RANDOM.nextInt(maxValue);
            }
        }
        return m;
    }
}
