package com.leonenko.epi._16_dp_TODO;

import java.util.Arrays;
import java.util.stream.IntStream;

public class _164_BinomialCoefficients {

    static int computeBinomialCoefficient(int n, int k) {
        int[][] table = new int[n + 1][k + 1];

        IntStream.range(0, table.length)
                .forEach(i -> table[i][0] = 1);
        IntStream.range(0, Math.min(table.length, table[0].length))
                .forEach(i -> table[i][i] = 1);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                table[i][j] = table[i - 1][j] + table[i - 1][j - 1];
            }
        }

        System.out.println("Table:");
        Arrays.stream(table)
              .map(Arrays::toString)
              .forEach(System.out::println);

        return table[n][k];
    }
}
