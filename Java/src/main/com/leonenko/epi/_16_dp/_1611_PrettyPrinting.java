package com.leonenko.epi._16_dp;

import java.util.Arrays;
import java.util.List;

public class _1611_PrettyPrinting {
    static int getMinMessiness(List<String> words, int lineLen) {
        int[] minMess = new int[words.size()];
        Arrays.fill(minMess, Integer.MAX_VALUE);

        int numRemainingBlanks = lineLen - words.get(0).length();

        minMess[0] = numRemainingBlanks * numRemainingBlanks;

        for (int i = 1; i < words.size(); i++) {
            numRemainingBlanks = lineLen - words.get(i).length();
            minMess[i] = minMess[i - 1] + numRemainingBlanks * numRemainingBlanks;

            for (int j = i - 1; j >= 0; j--) {
                numRemainingBlanks -= words.get(j).length() + 1;

                if (numRemainingBlanks >= 0) {
                    var firstMess = j - 1 < 0 ? 0 : minMess[j - 1];
                    var currLineMess = numRemainingBlanks * numRemainingBlanks;

                    minMess[i] = Math.min(minMess[i], firstMess + currLineMess);
                }
            }
        }

        return minMess[words.size() - 1];
    }
}
