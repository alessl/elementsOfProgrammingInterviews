package com.leonenko.epi._10_heap;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import static java.util.Comparator.reverseOrder;

public class _106_LargestKElementsOfMaxHeap {

    public static List<Integer> getLargestKNodes(List<Integer> list, int k) {
        if (k >= list.size()) {
            return list;
        }
        if (k <= 0) {
            return List.of();
        }

        var maxHeap = new PriorityQueue<HeapEntry>(reverseOrder());
        maxHeap.add(new HeapEntry(0, list.get(0)));

        var kLargestNodes = new ArrayList<Integer>();

        for (int i = 0; i < k; i++) {
            var entry = maxHeap.remove();

            kLargestNodes.add(entry.value);

            var leftChildIdx = 2 * entry.index + 1;

            if (leftChildIdx < list.size()) {
                maxHeap.add(new HeapEntry(leftChildIdx, list.get(leftChildIdx)));
            }

            var rightChildIdx = 2 * entry.index + 2;

            if (rightChildIdx < list.size()) {
                maxHeap.add(new HeapEntry(rightChildIdx, list.get(rightChildIdx)));
            }
        }

        return kLargestNodes;
    }

    @RequiredArgsConstructor
    private static class HeapEntry implements Comparable<HeapEntry> {

        private final int index;
        private final int value;

        @Override
        public int compareTo(HeapEntry o) {
            return Integer.compare(value, o.value);
        }

    }
}
