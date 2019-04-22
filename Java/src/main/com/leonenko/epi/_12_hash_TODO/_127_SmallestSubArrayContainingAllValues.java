package com.leonenko.epi._12_hash_TODO;

import java.util.*;

/**
 * Created by Alex on 4/27/2017.
 */
public class _127_SmallestSubArrayContainingAllValues {

    static List<String> getSubArray1(List<String> text, Set<String> words) {
        var currentSubArrayStart = 0;
        var minSubArrayStart = 0;
        var minSubArrayLength = text.size();
        var foundWords = new HashMap<String, Integer>();

        for (int current = 0; current < text.size(); current++) {
            var word = text.get(current);

            if (words.contains(word)) {
                foundWords.compute(word, (k, v) -> v == null ? 1 : v + 1);

                if (foundWords.size() == words.size()) {
                    var startWord = text.get(currentSubArrayStart);

                    while (!words.contains(startWord) || foundWords.get(startWord) > 1) {
                        foundWords.computeIfPresent(startWord, (w, c) -> c - 1);
                        startWord = text.get(++currentSubArrayStart);
                    }

                    if (current - currentSubArrayStart + 1 < minSubArrayLength) {
                        minSubArrayStart = currentSubArrayStart;
                        minSubArrayLength = current - currentSubArrayStart + 1;
                    }
                }
            }
        }

        int minEndIndex = minSubArrayStart + minSubArrayLength;

        return text.subList(minSubArrayStart, minEndIndex);
    }

    static List<String> getSubArray2(List<String> text, Set<String> searchWords) {
        var lastOccurrence = new LinkedHashMap<String, Integer>();

        searchWords.forEach(w -> lastOccurrence.put(w, -1));

        var minStartIndex = 0;
        var minLength = text.size();
        var numFound = 0;
        var index = 0;

        for (String word : text) {
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

        return text.subList(minStartIndex, minStartIndex + minLength);
    }

    static List<String> getSmallestSubArray(List<String> text) {
        return getSubArray1(text, Set.copyOf(text));
    }
}
