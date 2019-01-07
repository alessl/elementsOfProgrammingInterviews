package com.leonenko.epi._10_heap;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toCollection;

public class _101_MergeSortedLists {

    public static List<Integer> mergeSortedLists(List<List<Integer>> sortedLists) {
        var iterators = sortedLists.stream()
                .map(List::iterator)
                .collect(Collectors.toList());

        var minHeap = iterators.stream()
                .filter(Iterator::hasNext)
                .map(HeapEntry::new)
                .collect(toCollection(PriorityQueue::new));

        var mergedLists = new ArrayList<Integer>();

        while (!minHeap.isEmpty()) {
            var minEntry = minHeap.poll();

            mergedLists.add(minEntry.getKey());

            var nextEntry = minEntry.next();

            if (nextEntry != null) {
                minHeap.add(nextEntry);
            }
        }

        return mergedLists;
    }

    @EqualsAndHashCode(onlyExplicitlyIncluded = true)
    private static class HeapEntry implements Comparable<HeapEntry> {

        @Getter
        private final Iterator<Integer> iterator;

        @Getter
        @EqualsAndHashCode.Include
        private int key;

        public HeapEntry(Iterator<Integer> iterator) {
            this.iterator = iterator;
            this.key = iterator.next();
        }

        public HeapEntry next() {
            if (iterator.hasNext()) {
                return new HeapEntry(iterator);
            }
            return null;
        }

        @Override
        public int compareTo(HeapEntry o) {
            return Integer.compare(key, o.key);
        }
    }
}
