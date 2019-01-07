package com.leonenko.epi._10_heap;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Comparator.reverseOrder;

public class _107_StackUsingHeap {

    private final PriorityQueue<HeapEntry> maxHeap = new PriorityQueue<>(reverseOrder());

    private final AtomicInteger nextRank = new AtomicInteger();

    void push(int value) {
        maxHeap.add(new HeapEntry(value, nextRank.incrementAndGet()));
    }

    int pop() {
        return !maxHeap.isEmpty() ? maxHeap.poll().value : -1;
    }

    @EqualsAndHashCode
    @RequiredArgsConstructor
    private static class HeapEntry implements Comparable<HeapEntry> {

        @Getter
        @EqualsAndHashCode.Exclude
        private final int value;

        private final int rank;

        @Override
        public int compareTo(HeapEntry otherEntry) {
            return Integer.compare(rank, otherEntry.rank);
        }
    }
}
