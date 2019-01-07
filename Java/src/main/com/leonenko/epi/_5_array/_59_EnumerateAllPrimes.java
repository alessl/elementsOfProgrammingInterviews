package com.leonenko.epi._5_array;

import java.util.stream.IntStream;

/**
 * Created by Alex on 4/29/2017.
 */
public class _59_EnumerateAllPrimes {

    static int[] generatePrimes(int max) {
        var isPrime = IntStream.range(0, max + 1)
                               .mapToObj(i -> i > 1)
                               .toArray(Boolean[]::new);

        for (var number = 2; number <= max / number; number++) {
            if (isPrime[number]) {
                for (var multiplier = number; multiplier <= max / number; multiplier++) {
                    isPrime[number * multiplier] = false;
                }
            }
        }

        return IntStream.rangeClosed(2, max)
                        .filter(n -> isPrime[n])
                        .toArray();
    }

}
