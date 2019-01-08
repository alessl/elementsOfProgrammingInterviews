package com.leonenko.epi._15_rec;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Alex on 5/4/2017.
 */
public class _155_GenerateAllSubSetsOfSizeK {

    static List<List<Character>> enumerateAllCombinationsOfSize(String str, int size) {
        List<Character> chars = str.chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.toList());

        var allCombinations = new ArrayList<List<Character>>();

        enumerateAllCombinationsOfSize(chars, size, new ArrayList<>(), allCombinations);

        return allCombinations;
    }

    private static void enumerateAllCombinationsOfSize(List<Character> chars, int size,
            List<Character> currCombination, List<List<Character>> allCombinations) {

        if (currCombination.size() == size) {
            allCombinations.add(List.copyOf(currCombination));
            return;
        }

        if (size - currCombination.size() > chars.size()) {
            return;
        }

        // include first char
        currCombination.add(chars.get(0));

        // with first char
        enumerateAllCombinationsOfSize(chars.subList(1, chars.size()),
                size, currCombination, allCombinations);

        // remove first char
        currCombination.remove(currCombination.size() - 1);

        // without first char
        enumerateAllCombinationsOfSize(chars.subList(1, chars.size()),
                size, currCombination, allCombinations);
    }

    static List<List<Integer>> enumerateAllCombinationsOfSize(int max, int size) {
        var allCombinations = new ArrayList<List<Integer>>();

        enumerateAllCombinationsOfSize(1, max, size, new ArrayList<>(), allCombinations);

        return allCombinations;
    }

    private static void enumerateAllCombinationsOfSize(int curr,
            int max, int size, List<Integer> currCombination, List<List<Integer>> allCombinations) {

        if (currCombination.size() == size) {
            allCombinations.add(List.copyOf(currCombination));
            return;
        }

        if (size - currCombination.size() > max - curr + 1) {
            return;
        }

        // include curr
        currCombination.add(curr);

        // with curr
        enumerateAllCombinationsOfSize(curr + 1,
                max, size, currCombination, allCombinations);

        // remove curr
        currCombination.remove(currCombination.size() - 1);

        // without curr
        enumerateAllCombinationsOfSize(curr + 1,
                max, size, currCombination, allCombinations);
    }
}
