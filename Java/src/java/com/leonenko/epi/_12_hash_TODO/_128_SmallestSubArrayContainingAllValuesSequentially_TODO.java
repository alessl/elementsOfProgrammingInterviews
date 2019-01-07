package com.leonenko.epi._12_hash_TODO;

import java.util.*;

/**
 * Created by Alex on 5/3/2017.
 */
public class _128_SmallestSubArrayContainingAllValuesSequentially_TODO {

    public static void main(String[] args) {
        String[] allWords = {
                "apple",
                "banana",
                "apple",
                "dog",
                "cat",
                "apple",
                "banana",
                "dog",
                "cat",
                "banana",
                "orange",
                "kiwi",
                "banana",
        };
        String[] searchWords = {"banana", "cat"};
        System.out.println(Arrays.toString(getSubArray(allWords, searchWords)));
    }

    private static String[] getSubArray(String[] allWords, String[] searchWords) {
        var lastOccur = new HashMap<String, Integer>();
        var subArrayMinLen = new HashMap<String, Integer>();
        var prevWord = new HashMap<String, String>();

        for (int i = 0; i < searchWords.length; i++) {
            var searchWord = searchWords[i];
            lastOccur.put(searchWord, -1);
            subArrayMinLen.put(searchWord, Integer.MAX_VALUE);
            prevWord.put(searchWord, i > 0 ? searchWords[i - 1] : null);
        }

        int minStart = 0;
        int minLen = allWords.length;
        int wordIndex = 0;

        for (String word : allWords) {
            if (lastOccur.containsKey(word)) {
                if (word.equals(searchWords[0])) {
                    subArrayMinLen.put(word, 1);
                } else {
                    int prevWordMinLen = subArrayMinLen.get(prevWord.get(word));

                    if (prevWordMinLen != Integer.MAX_VALUE) {
                        int prevWordIndex = lastOccur.get(prevWord.get(word));
                        int wordMinLen = prevWordMinLen + wordIndex - prevWordIndex;
                        subArrayMinLen.put(word, wordMinLen);
                    }
                }
                if (word.equals(searchWords[searchWords.length - 1])
                        && subArrayMinLen.get(word) < minLen) {
                    minLen = subArrayMinLen.get(word);
                    minStart = lastOccur.get(searchWords[0]);
                }
                lastOccur.put(word, wordIndex);
            }
            wordIndex++;
        }
        return Arrays.copyOfRange(allWords, minStart, minStart + minLen);
    }
}
