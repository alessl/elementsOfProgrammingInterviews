package com.leonenko.epi._5_array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class _52_53_ListArithmeticOperations {

    public static List<Integer> increment(List<Integer> number) {
        var numberCopy = new ArrayList<>(number);
        var lastDigitIndex = numberCopy.size() - 1;

        numberCopy.set(lastDigitIndex, numberCopy.get(lastDigitIndex) + 1);

        for (int i = lastDigitIndex; i > 0 && numberCopy.get(i) == 10; i--) {
            numberCopy.set(i, 0);
            numberCopy.set(i - 1, numberCopy.get(i - 1) + 1);
        }

        if (numberCopy.get(0) == 10) {
            numberCopy.set(0, 0);
            numberCopy.add(0, 1);
        }

        return numberCopy;
    }

    static List<Integer> multiply(List<Integer> firstNum, List<Integer> secondNum) {
        var firstNumCopy = new ArrayList<>(firstNum);
        var secondNumCopy = new ArrayList<>(secondNum);

        var sign = firstNumCopy.get(0) < 0 ^ secondNumCopy.get(0) < 0 ? -1 : 1;

        firstNumCopy.set(0, Math.abs(firstNumCopy.get(0)));
        secondNumCopy.set(0, Math.abs(secondNumCopy.get(0)));

        var prod = Stream.generate(() -> 0)
                         .limit(firstNumCopy.size() + secondNumCopy.size())
                         .collect(toList());
        var startIdx = 0;

        for (var firstIdx = firstNumCopy.size() - 1; firstIdx >= 0; firstIdx--) {
            for (var secondIdx = secondNumCopy.size() - 1; secondIdx >= 0; secondIdx--) {

                var currIdx = firstIdx + secondIdx + 1;
                var nextIdx = firstIdx + secondIdx;

                var currPartialProduct = prod.get(currIdx)
                        + firstNumCopy.get(firstIdx) * secondNumCopy.get(secondIdx);

                prod.set(currIdx, currPartialProduct % 10);
                prod.set(nextIdx, prod.get(nextIdx) + currPartialProduct / 10);

                startIdx = currPartialProduct / 10 > 0 ? nextIdx : currIdx;
            }
        }

        if (prod.get(startIdx) == 0) {
            return List.of(0);
        }

        prod.set(startIdx, prod.get(startIdx) * sign);

        return prod.subList(startIdx, prod.size());
    }
}
