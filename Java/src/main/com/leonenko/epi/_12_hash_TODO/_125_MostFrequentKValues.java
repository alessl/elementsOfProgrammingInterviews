package com.leonenko.epi._12_hash_TODO;

import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * Created by Alex on 4/27/2017.
 */
public class _125_MostFrequentKValues {

    static List<String> getMostFrequentEntriesMinHeap(List<String> strings, int maxNum) {
        var stringCounts = strings.stream()
                                  .collect(Collectors.groupingBy(s -> s, Collectors.counting())); // θ(size)

        var minHeap = new PriorityQueue<Entry<String, Long>>(Comparator.comparingLong(Entry::getValue));

        for (var e : stringCounts.entrySet()) { // θ(size * log(max))
            if (minHeap.size() == maxNum && minHeap.peek().getValue() < e.getValue()) {
                minHeap.remove();
            }
            if (minHeap.size() < maxNum) {
                minHeap.add(e);
            }
        }

        return minHeap.stream() // θ(max)
                      .map(Entry::getKey)
                      .collect(Collectors.toList());
    }

    static List<String> getMostFrequentEntriesOrderStat(List<String> list, int maxNum) {
        return List.of();
    }
}
