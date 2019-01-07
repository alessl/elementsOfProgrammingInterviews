package com.leonenko.epi._10_heap;

import lombok.RequiredArgsConstructor;

import java.util.Iterator;
import java.util.OptionalInt;
import java.util.PriorityQueue;

import static java.util.Collections.reverseOrder;

@RequiredArgsConstructor
public class _105_OnlineMedian {

    private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(reverseOrder());

    private final Iterator<Integer> iterator;

    public OptionalInt next() {
        if (!iterator.hasNext()) {
            return OptionalInt.empty();
        }

        var next = iterator.next();

        if (minHeap.isEmpty()) {
            minHeap.add(next);
        } else if (next >= minHeap.peek()) {
            maxHeap.add(next);
        }

        if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.add(minHeap.remove());
        } else if (minHeap.size() < maxHeap.size()) {
            minHeap.add(maxHeap.remove());
        }

        return OptionalInt.of(next);
    }

    OptionalInt median() {
        if (minHeap.isEmpty() && maxHeap.isEmpty()) {
            return OptionalInt.empty();
        } else if (minHeap.size() == maxHeap.size()) {
            return OptionalInt.of((minHeap.peek() + maxHeap.peek()) / 2);
        } else if (!minHeap.isEmpty()) {
            return OptionalInt.of(minHeap.peek());
        } else {
            return OptionalInt.empty();
        }
    }
}
