package com.leonenko.epi._12_hash_TODO;

import java.util.*;
import java.util.Map.Entry;

import static java.util.Comparator.comparingInt;
import static java.util.Comparator.comparingLong;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

/**
 * Created by Alex on 4/27/2017.
 */
public class _125_MostFrequentKValuesTree_TODO {

    public static void main(String[] args) {
        List<String> duplicateWords = generateWords();
        List<String> wordCounts =
                duplicateWords
                        .stream()
                        .collect(groupingBy(identity(), counting()))
                        .entrySet()
                        .stream()
                        .sorted(comparingLong(Entry::getValue))
                        .map(Object::toString)
                        .collect(toList());
        System.out.println(wordCounts);
        printTopWords(duplicateWords, 1);
        printTopWords(duplicateWords, 2);
        printTopWords(duplicateWords, 3);
        printTopWords(duplicateWords, 4);
        printTopWords(duplicateWords, 10);
    }

    private static void printTopWords(List<String> duplicateWords, int topSize) {
        System.out.printf("Top(%s) is %s%n", topSize, getTopWords(duplicateWords, topSize));
    }

    private static List<String> getTopWords(List<String> allWords, int topSize) {
        Map<String, Integer> allWordCounts = new HashMap<>();
        TopWords topWords = new TopWords(topSize);

        for (String word : allWords) {
            int wordCount = allWordCounts.compute(word, (w, c) -> c == null ? 1 : c + 1);
            topWords.addWord(word, wordCount);
        }
        if (allWordCounts.size() > topSize) {
            allWordCounts.keySet().retainAll(topWords.words);
        }
        return allWordCounts
                .entrySet()
                .stream()
                .sorted(comparingInt(Entry::getValue))
                .map(Object::toString)
                .collect(toList());
    }

    private static List<String> generateWords() {
        Random random = new Random();
        String[] words = {
                "google", "facebook", "amazon", "blizzard", "apple", "twitter", "netflix"
        };
        List<String> duplicateWords = new ArrayList<>();
        for (String word : words) {
            int maxCopies = 11;
            int numCopies = 1 + random.nextInt(maxCopies);
            for (int i = 0; i < numCopies; i++) {
                duplicateWords.add(word);
            }
        }
        return duplicateWords;
    }

    private static final class TopWords {
        private final int maxSize;
        private final Set<String> words = new HashSet<>();
        private final NavigableMap<Integer, NavigableSet<String>> wordsByCount = new TreeMap<>();

        private TopWords(int maxSize) {
            this.maxSize = maxSize;
        }

        private void addWord(String word, int wordCount) {
            if (words.size() < maxSize && !words.contains(word)) {
                insertWord(word, wordCount);
            } else if (words.contains(word)) {
                updateWordCount(word, wordCount);
            } else if (wordCount > wordsByCount.firstKey()) {
                replaceMinCountWord(word, wordCount);
            }
        }

        private void insertWord(String word, int wordCount) {
            words.add(word);
            createNewSet(wordCount).add(word);
        }

        private void updateWordCount(String word, int wordCount) {
            int prevWordCount = wordCount - 1;
            NavigableSet<String> words = wordsByCount.get(prevWordCount);
            words.remove(word);
            if (words.isEmpty()) {
                wordsByCount.remove(prevWordCount);
            }
            createNewSet(wordCount).add(word);
        }

        private void replaceMinCountWord(String word, int wordCount) {
            NavigableSet<String> minCountWords = wordsByCount.firstEntry().getValue();
            words.remove(minCountWords.pollFirst());
            if (minCountWords.isEmpty()) {
                wordsByCount.pollFirstEntry();
            }
            words.add(word);
            createNewSet(wordCount).add(word);
        }

        private NavigableSet<String> createNewSet(int wordCount) {
            return wordsByCount.computeIfAbsent(wordCount, c -> new TreeSet<>());
        }
    }
}
