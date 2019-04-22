package com.leonenko.epi._12_hash_TODO;

import java.util.*;

/**
 * Created by Alex on 5/3/2017.
 */
class _128_SmallestSubArrayContainingAllValuesSequentially {

    static String[] getMinLengthSubArrayContainingAllSequentially(
            String[] text,
            String[] searchWords) {

        var wordToLastIndexMap = new HashMap<String, Integer>();
        var wordToMinLenMap = new HashMap<String, Integer>();
        var wordToPrevWordMap = new HashMap<String, String>();

        for (var i = 0; i < searchWords.length; i++) {
            var searchWord = searchWords[i];

            wordToLastIndexMap.put(searchWord, -1);
            wordToMinLenMap.put(searchWord, Integer.MAX_VALUE);
            wordToPrevWordMap.put(searchWord, i > 0 ? searchWords[i - 1] : null);
        }
        var minStart = 0;
        var minLen = text.length;
        var wordIndex = 0;

        for (var word : text) {
            if (wordToLastIndexMap.containsKey(word)) {
                if (word.equals(searchWords[0])) {
                    wordToMinLenMap.put(word, 1);
                } else {
                    var prevWordMinLen = wordToMinLenMap.get(wordToPrevWordMap.get(word));

                    if (prevWordMinLen != Integer.MAX_VALUE) {
                        int prevWordIndex = wordToLastIndexMap.get(wordToPrevWordMap.get(word));
                        int wordMinLen = prevWordMinLen + wordIndex - prevWordIndex;
                        wordToMinLenMap.put(word, wordMinLen);
                    }
                }

                if (word.equals(searchWords[searchWords.length - 1])
                        && wordToMinLenMap.get(word) < minLen) {
                    minLen = wordToMinLenMap.get(word);
                    minStart = wordToLastIndexMap.get(searchWords[0]);
                }

                wordToLastIndexMap.put(word, wordIndex);
            }
            wordIndex++;
        }

        return Arrays.copyOfRange(text, minStart, minStart + minLen);
    }
}
