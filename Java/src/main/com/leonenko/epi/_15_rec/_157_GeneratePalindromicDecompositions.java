package com.leonenko.epi._15_rec;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alex on 5/3/2017.
 *
 * http://www.geeksforgeeks.org/given-a-string-print-all-possible-palindromic-partition/
 * http://www.geeksforgeeks.org/print-palindromic-partitions-string/
 */
public class _157_GeneratePalindromicDecompositions {

    static List<List<String>> enumeratePalindromicDecompositions(String str) {
        var allDecompositions = new ArrayList<List<String>>();

        enumeratePalindromicDecompositions(str, new LinkedList<>(), allDecompositions);

        return allDecompositions;
    }

    private static void enumeratePalindromicDecompositions(String str,
            Deque<String> currDecomposition, List<List<String>> allDecompositions) {

        if (str.isEmpty()) {
            allDecompositions.add(List.copyOf(currDecomposition));
            return;
        }

        for (int end = 1; end < str.length(); end++) {
            var subString = str.substring(0, end);

            if (isPalindrome(subString)) {
                currDecomposition.push(subString);

                enumeratePalindromicDecompositions(str.substring(end),
                        currDecomposition, allDecompositions);

                currDecomposition.pop();
            }
        }
    }

    static List<List<String>> enumeratePalindromicSubStringsOfSameSize(String str) {
        var decompositionsBySize = new ArrayList<List<String>>();

        for (int size = 1; size <= str.length(); size++) {
            enumeratePalindromicDecompositions(str, size, new LinkedList<>(), decompositionsBySize);
        }

        return decompositionsBySize;
    }

    private static void enumeratePalindromicDecompositions(String str,
            int size, Deque<String> currDecomposition, List<List<String>> allDecompositions) {

        if (str.length() < size) {
            allDecompositions.add(List.copyOf(currDecomposition));
            return;
        }

        var substring = str.substring(0, size);

        if (isPalindrome(substring)) {
            currDecomposition.push(substring);

            enumeratePalindromicDecompositions(str.substring(size),
                    size, currDecomposition, allDecompositions);

            currDecomposition.pop();
        }

    }

    private static boolean isPalindrome(String s) {
        var left = 0;
        var right = s.length() - 1;

        while (left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }

        return left >= right;
    }
}
