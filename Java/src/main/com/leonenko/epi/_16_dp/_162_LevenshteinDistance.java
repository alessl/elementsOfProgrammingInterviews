package com.leonenko.epi._16_dp;

import java.util.stream.IntStream;

public class _162_LevenshteinDistance {

    static int getMinimumDistance(String firstStr, String secondStr) {
        return getMinimumDistance(firstStr, secondStr, firstStr.length() - 1, secondStr.length() - 1);
    }

    private static int getMinimumDistance(String firstStr, String secondStr, int firstIndex, int secondIndex) {
        if (firstIndex < 0) {
            return secondIndex + 1;
        }
        if (secondIndex < 0) {
            return firstIndex + 1;
        }

        if (firstStr.charAt(firstIndex) == secondStr.charAt(secondIndex)) {
            return getMinimumDistance(firstStr, secondStr, firstIndex - 1, secondIndex - 1);
        } else {
            int subDist = getMinimumDistance(firstStr, secondStr, firstIndex - 1, secondIndex - 1);
            int insDist = getMinimumDistance(firstStr, secondStr, firstIndex, secondIndex - 1);
            int delDist = getMinimumDistance(firstStr, secondStr, firstIndex - 1, secondIndex);

            return Math.min(subDist, Math.min(insDist, delDist)) + 1;
        }
    }

    static int getMinimumDistanceDP(String firstStr, String secondStr) {
        int[][] table = new int[firstStr.length() + 1][secondStr.length() + 1];

        IntStream.range(0, secondStr.length() + 1).forEach(i -> table[0][i] = i);
        IntStream.range(0, firstStr.length() + 1).forEach(i -> table[i][0] = i);

        for (int i = 1; i <= firstStr.length(); i++) {
            for (int j = 1; j <= secondStr.length(); j++) {
                if (firstStr.charAt(i - 1) == secondStr.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1];
                } else {
                    table[i][j] = Math.min(Math.min(table[i - 1][j], table[i][j - 1]), table[i - 1][j - 1]) + 1;
                }
            }
        }

        return table[firstStr.length()][secondStr.length()];
    }

    static int getMinimumDistanceDPOptimized(String firstStr, String secondStr) {
        int[][] table = new int[firstStr.length() + 1][secondStr.length() + 1];

        IntStream.range(0, secondStr.length() + 1).forEach(i -> table[0][i] = i);
        IntStream.range(0, firstStr.length() + 1).forEach(i -> table[i][0] = i);

        for (int i = 1; i <= firstStr.length(); i++) {
            for (int j = 1; j <= secondStr.length(); j++) {
                if (firstStr.charAt(i - 1) == secondStr.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1];
                } else {
                    table[i][j] = Math.min(Math.min(table[i - 1][j], table[i][j - 1]), table[i - 1][j - 1]) + 1;
                }
            }
        }

        return table[firstStr.length()][secondStr.length()];
    }

    // https://www.geeksforgeeks.org/minimum-number-deletions-make-string-palindrome/
    // https://www.geeksforgeeks.org/minimum-number-deletions-make-string-palindrome-set-2/
    static int getMinDeletionsToMakePalindrome(String str) {
        return getMinDeletionsToMakePalindrome(str, 0, str.length() - 1);
    }

    private static int getMinDeletionsToMakePalindrome(String str, int startIndex, int endIndex) {
        if (startIndex >= endIndex || isPalindrome(str, startIndex, endIndex)) {
            return 0;
        }
        if (str.charAt(startIndex) == str.charAt(endIndex)) {
            return getMinDeletionsToMakePalindrome(str, startIndex + 1, endIndex - 1);
        } else {
            var minIfBothEndsRemoved = getMinDeletionsToMakePalindrome(str,
                    startIndex + 1, endIndex - 1) + 2;
            var minIfStartRemoved = getMinDeletionsToMakePalindrome(str, startIndex + 1, endIndex) + 1;
            var minIfEndRemoved = getMinDeletionsToMakePalindrome(str, startIndex, endIndex - 1) + 1;

            return Math.min(minIfBothEndsRemoved, Math.min(minIfStartRemoved, minIfEndRemoved));
        }
    }

    private static boolean isPalindrome(String str, int startIndex, int endIndex) {
        while (startIndex < endIndex && str.charAt(startIndex) == str.charAt(endIndex)) {
            startIndex++;
            endIndex--;
        }
        return startIndex == endIndex;
    }
}
