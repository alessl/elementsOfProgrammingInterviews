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
public class _125_MostFrequentKValues_TODO {

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
        Map<String, Integer> wordCounts = new HashMap<>();

        PriorityQueue<String> topWordsAsc = new PriorityQueue<>(comparingInt(
                word -> wordCounts.getOrDefault(word, 0)));

        Set<String> topWords = new HashSet<>();

        for (String word : allWords) {
            wordCounts.compute(word, (w, c) -> c == null ? 1 : c + 1);

            if (topWords.size() < topSize) {
                addOrUpdateWord(topWordsAsc, word);
                topWords.add(word);
            } else {
                if (topWords.contains(word)) {
                    addOrUpdateWord(topWordsAsc, word);
                } else if (wordCounts.get(word) > wordCounts.get(topWordsAsc.peek())) {
                    topWords.remove(topWordsAsc.poll());
                    topWords.add(word);
                    topWordsAsc.add(word);
                }
            }
        }
        if (wordCounts.size() > topSize) {
            wordCounts.keySet().retainAll(topWords);
        }
        return wordCounts
                .entrySet()
                .stream()
                .sorted(comparingInt(Entry::getValue))
                .map(Object::toString)
                .collect(toList());
    }

    private static void addOrUpdateWord(PriorityQueue<String> wordsMinHeap, String word) {
        // wordsMinHeap.remove(word);
        wordsMinHeap.add(word);
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
}
