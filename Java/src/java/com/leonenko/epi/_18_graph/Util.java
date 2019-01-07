package com.leonenko.epi._18_graph;

import java.util.Arrays;

/**
 * Created by Alex on 5/13/2017.
 */
class Util {

    static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static void print(int[][] m) {
        Arrays.stream(m)
              .map(Arrays::toString)
              .forEach(System.out::println);
        System.out.println();
    }

    static boolean isValidPoint(int[][] m, int row, int col) {
        return row >= 0 && col >= 0 && row < m.length && col < m[row].length;
    }
}
