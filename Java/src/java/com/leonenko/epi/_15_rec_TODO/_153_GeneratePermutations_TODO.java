package com.leonenko.epi._15_rec_TODO;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.joining;

/**
 * Created by Alex on 5/4/2017.
 */
public class _153_GeneratePermutations_TODO {

    public static void main(String[] args) {
        printAllPermutations(Arrays.asList('a', 'b', 'c'), 0);
    }

    private static void printAllPermutations(List<Character> chars, int start) {
        if (start == chars.size()) {
            System.out.println(chars.stream().map(Object::toString).collect(joining()));
        }

        for (var i = start; i < chars.size(); i++) {
            Collections.swap(chars, start, i);
            printAllPermutations(chars, start + 1);
            Collections.swap(chars, start, i);
        }
    }
}
