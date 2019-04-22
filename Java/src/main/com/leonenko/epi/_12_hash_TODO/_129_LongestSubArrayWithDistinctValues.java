package com.leonenko.epi._12_hash_TODO;

import java.util.*;

/**
 * Created by Alex on 5/3/2017.
 */
public class _129_LongestSubArrayWithDistinctValues {

    static String[] getSubArray(String[] words) {
        var wordToLastIndexMap = new HashMap<String, Integer>();
        var maxStartIndex = 0;
        var maxLength = 0;
        var startIndex = 0;
        var currIndex = 0;

        for (var word : words) {
            if (wordToLastIndexMap.containsKey(word)) {
                int latestOccurrence = wordToLastIndexMap.get(word);
                if (latestOccurrence >= startIndex) {
                    startIndex = latestOccurrence + 1;
                }
            }

            if (maxLength < currIndex - startIndex + 1) {
                maxStartIndex = startIndex;
                maxLength = currIndex - startIndex + 1;
            }

            wordToLastIndexMap.put(word, currIndex);
            currIndex++;
        }

        return Arrays.copyOfRange(words, maxStartIndex, maxStartIndex + maxLength);
    }
}
