package com.leonenko.epi._5_array;

import java.util.Arrays;
import java.util.Random;
import java.util.StringJoiner;

/**
 * Created by Alex on 5/5/2017.
 */
public class MatrixRectangles {

    public static void main(String[] args) {
        Random r = new Random();
        int[][] m = new int[5][5];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                m[i][j] = r.nextInt(100 + 1);
            }
        }
        Arrays.stream(m).map(Arrays::toString).forEach(System.out::println);
        printRectangles(m);
    }

    private static void printRectangles(int[][] m) {
        for (int rowEnd = 0; rowEnd < m.length; rowEnd++) {
            for (int colEnd = 0; colEnd < m[rowEnd].length; colEnd++) {
                for (int row = 0; row <= rowEnd; row++) {
                    StringJoiner rowStr = new StringJoiner(" ");
                    for (int col = 0; col <= colEnd; col++) {
                        rowStr.add(String.valueOf(m[row][col]));
                    }
                    System.out.println(rowStr);
                }
                System.out.println();
            }
        }
    }
}
