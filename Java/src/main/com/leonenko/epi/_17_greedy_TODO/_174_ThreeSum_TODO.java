package com.leonenko.epi._17_greedy_TODO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.binarySearch;

public class _174_ThreeSum_TODO {

    static List<List<Integer>> findTripletsBinarySearch(List<Integer> numbers, int targetSum) {
        numbers.sort(Integer::compareTo);

        var triples = new ArrayList<List<Integer>>();
        var numbersSize = numbers.size();

        for (var firstIndex = 0; firstIndex < numbersSize - 2; firstIndex++) {
            var firstNum = numbers.get(firstIndex);

            for (var secondIndex = firstIndex + 1; secondIndex < numbersSize - 1; secondIndex++) {

                var secondNum = numbers.get(secondIndex);
                var thirdNum = targetSum - (firstNum + secondNum);

                int thirdIndex =
                        binarySearch(numbers.subList(secondIndex + 1, numbersSize), thirdNum);

                if (thirdIndex >= 0) {
                    triples.add(List.of(firstNum, secondNum, thirdNum));
                }
            }
        }

        return triples;
    }

    static List<List<Integer>> findTripletsTwoIterators(List<Integer> numbers, int targetThreeSum) {
        numbers.sort(Integer::compareTo);

        var triples = new ArrayList<List<Integer>>();
        var numbersSize = numbers.size();

        for (var index = 0; index < numbersSize - 2; index++) {
            var firstNum = numbers.get(index);
            var targetTwoSum = targetThreeSum - firstNum;

            findTwoSum(numbers, index + 1, targetTwoSum);

            triples.addAll(findTwoSum(numbers, index + 1, targetTwoSum)
                    .stream()
                    .peek(tuple -> tuple.add(firstNum))
                    .collect(Collectors.toList()));
        }

        return triples;
    }

    static List<List<Integer>> findKTuplesTwoIterators(List<Integer> numbers,
            int targetKSum, int k) {

        numbers.sort(Integer::compareTo);

        return findKTuplesTwoIterators(numbers, targetKSum, 0, k);
    }

    static List<List<Integer>> findKTuplesTwoIterators(List<Integer> numbers,
            int targetKSum, int start, int k) {

        if (k == 2) {
            return findTwoSum(numbers, start, targetKSum);
        }

        var tuples = new ArrayList<List<Integer>>();

        for (var index = start; index < numbers.size() - k; index++) {
            var currNum = numbers.get(index);

            tuples.addAll(findKTuplesTwoIterators(numbers, targetKSum - currNum, index + 1, k - 1)
                    .stream()
                    .peek(tuple -> tuple.add(currNum))
                    .collect(Collectors.toList()));
        }

        return tuples;
    }

    private static List<List<Integer>> findTwoSum(List<Integer> numbers,
            int leftIndex, int targetTwoSum) {

        var pairs = new ArrayList<List<Integer>>();

        var rightIndex = numbers.size() - 1;

        while (leftIndex <= rightIndex) {
            var possibleFirstNum = numbers.get(leftIndex);
            var possibleSecondNum = numbers.get(rightIndex);
            var currTwoSum = possibleFirstNum + possibleSecondNum;

            if (currTwoSum == targetTwoSum) {
                pairs.add(new ArrayList<>(List.of(possibleFirstNum, possibleSecondNum)));

                rightIndex--;
                leftIndex++;
            } else if (currTwoSum > targetTwoSum) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }

        return pairs;
    }

}
