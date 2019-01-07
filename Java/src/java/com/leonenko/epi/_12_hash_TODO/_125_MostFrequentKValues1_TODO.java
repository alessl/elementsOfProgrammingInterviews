package com.leonenko.epi._12_hash_TODO;

import java.util.*;
import java.util.Map.Entry;

import static java.util.Comparator.*;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

/**
 * Created by Alex on 4/27/2017.
 */
public class _125_MostFrequentKValues1_TODO {

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
        return getTopWords(topSize, countWords(allWords));
    }

    private static List<String> getTopWords(int topSize, Map<String, Long> wordCounts) {
        PriorityQueue<String> topWords =
                new PriorityQueue<>(nullsLast(comparing(wordCounts::get)));

        for (String word : wordCounts.keySet()) {
            if (topWords.size() < topSize) {
                topWords.add(word);
            } else if (wordCounts.get(word) > wordCounts.get(topWords.peek())) {
                topWords.poll();
                topWords.add(word);
            }
        }

        return new ArrayList<>(topWords);
    }

    private static Map<String, Long> countWords(List<String> allWords) {
        return allWords.stream()
                .collect(groupingBy(w -> w, counting()));
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
