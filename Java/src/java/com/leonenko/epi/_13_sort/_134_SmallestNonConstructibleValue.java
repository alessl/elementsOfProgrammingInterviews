package com.leonenko.epi._13_sort;

import java.util.List;

import static java.util.Comparator.naturalOrder;

public class _134_SmallestNonConstructibleValue {

    static int getSmallestNonConstructibleNumber(List<Integer> numbers) {
        numbers.sort(naturalOrder());

        int maxConstructibleNumber = 0;

        for (var number : numbers) {
            if (number > maxConstructibleNumber + 1) {
                break;
            }

            maxConstructibleNumber += number;
        }

        return maxConstructibleNumber + 1;
    }
}
