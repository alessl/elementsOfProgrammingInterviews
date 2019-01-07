package com.leonenko.epi._12_hash_TODO;

import java.util.*;

/**
 * Created by Alex on 5/3/2017.
 */
public class _129_LongestSubArrayWithDistinctValues_TODO {

    public static void main(String[] args) {
        String[] words = {
                "apple",
                "banana",
                "apple",
                "apple",
                "dog",
                "orange",
                "cat",
                "apple",
                "banana",
                "dog",
                "cat",
                "orange",
                "lemon",
                "kiwi",
        };
        System.out.println(Arrays.toString(getSubArray(words)));
    }

    private static String[] getSubArray(String[] words) {
        Map<String, Integer> lastOccurrences = new HashMap<>();
        int maxStart = 0;
        int maxLength = 0;
        int start = 0;
        int index = 0;
        for (String word : words) {
            if (lastOccurrences.containsKey(word)) {
                int latestOccurrence = lastOccurrences.get(word);
                if (latestOccurrence >= start) {
                    start = latestOccurrence + 1;
                }
            }
            if (maxLength < index - start + 1) {
                maxStart = start;
                maxLength = index - start + 1;
            }
            lastOccurrences.put(word, index);
            index++;
        }
        return Arrays.copyOfRange(words, maxStart, maxStart + maxLength);
    }
}
