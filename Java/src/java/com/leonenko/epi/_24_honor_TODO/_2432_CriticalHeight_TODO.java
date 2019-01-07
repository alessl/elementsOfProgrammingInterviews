package com.leonenko.epi._24_honor_TODO;

import java.util.Arrays;
import java.util.stream.IntStream;

public class _2432_CriticalHeight_TODO {

    public static void main(String[] args) {

    }

    static int determineHeight(int cases, int drops) {
        int[][] table = createTable(cases, drops);
        return getHeight(cases, drops, table);
    }

    private static int[][] createTable(int cases, int drops) {
        var table = new int[cases + 1][drops + 1];
        IntStream.range(0, table.length).forEach(i -> Arrays.fill(table[i], -1));
        return table;
    }

    private static int getHeight(int cases, int drops, int[][] table) {
        if (cases == 0 || drops == 0) {
            return 0;
        }
        if (cases == 1) {
            return drops;
        }
        if (table[cases][drops] == -1) {
            table[cases][drops] = getHeight(cases, drops - 1, table)
                    + getHeight(cases - 1, drops - 1, table) + 1;
        }
        return table[cases][drops];
    }

}
