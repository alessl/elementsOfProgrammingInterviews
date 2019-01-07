package com.leonenko.epi._12_hash_TODO;

import java.util.*;

/**
 * Created by Alex on 4/27/2017.
 */
public class _127_SmallestSubArrayContainingAllValues_TODO {

    public static void main(String[] args) {
        var allWords = new String[] {
                "apple", "banana", "apple", "dog", "cat", "apple", "banana", "dog", "cat", "banana"
        };
        var searchWords = Set.of("banana", "cat");

        System.out.println(Arrays.toString(getSubArray(allWords, searchWords)));
        System.out.println(Arrays.toString(getSubArray2(allWords, searchWords)));
    }

    private static String[] getSubArray(String[] allWords, Set<String> searchWords) {
        var start = 0;
        var minStart = 0;
        var minSubArrayLength = allWords.length;
        var foundSearchWordsWithCount = new HashMap<String, Integer>();

        for (int current = 0; current < allWords.length; current++) {
            var word = allWords[current];

            if (searchWords.contains(word)) {
                foundSearchWordsWithCount.compute(word, (k, v) -> v == null ? 1 : v + 1);

                if (foundSearchWordsWithCount.size() == searchWords.size()) {
                    var startWord = allWords[start];

                    while (!searchWords.contains(startWord)
                            || foundSearchWordsWithCount.get(startWord) > 1) {
                        foundSearchWordsWithCount.computeIfPresent(startWord, (w, c) -> c - 1);
                        startWord = allWords[++start];
                    }
                    if (current - start + 1 < minSubArrayLength) {
                        minStart = start;
                        minSubArrayLength = current - start + 1;
                    }
                }
            }
        }
        int minEndIndex = minStart + minSubArrayLength;
        return Arrays.copyOfRange(allWords, minStart, minEndIndex);
    }

    private static String[] getSubArray2(String[] allWords, Set<String> searchWords) {
        var lastOccurrence = new LinkedHashMap<String, Integer>();
        searchWords.forEach(w -> lastOccurrence.put(w, -1));

        var minStartIndex = 0;
        var minLength = allWords.length;
        var numFound = 0;
        var index = 0;

        for (String word : allWords) {
            if (lastOccurrence.containsKey(word)) {
                if (lastOccurrence.get(word) < 0) {
                    numFound++;
                }
                lastOccurrence.remove(word);
                lastOccurrence.put(word, index);
            }
            if (numFound == searchWords.size()) {
                int firstFoundWordIndex = lastOccurrence.values().iterator().next();

                if (index - firstFoundWordIndex + 1 < minLength) {
                    minStartIndex = firstFoundWordIndex;
                    minLength = index - firstFoundWordIndex + 1;
                }
            }
            index++;
        }
        return Arrays.copyOfRange(allWords, minStartIndex, minStartIndex + minLength);
    }
}
