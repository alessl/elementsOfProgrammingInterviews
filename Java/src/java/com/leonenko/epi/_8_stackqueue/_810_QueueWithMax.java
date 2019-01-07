package com.leonenko.epi._8_stackqueue;

import java.util.*;

public class _810_QueueWithMax {

    private final Queue<Integer> dataQueue = new LinkedList<>();
    private final Deque<Integer> maxDequeue = new LinkedList<>();
    private final Deque<Integer> minDequeue = new LinkedList<>();

    void enqueue(int value) {
        dataQueue.add(value);

        while (!maxDequeue.isEmpty() && maxDequeue.getLast() < value) {
            maxDequeue.removeLast();
        }
        maxDequeue.addLast(value);

        while (!minDequeue.isEmpty() && minDequeue.getLast() > value) {
            minDequeue.removeLast();
        }
        minDequeue.addLast(value);
    }

    OptionalInt dequeue() {
        if (dataQueue.isEmpty()) {
            return OptionalInt.empty();
        }

        int value = dataQueue.remove();

        if (value == maxDequeue.getFirst()) {
            maxDequeue.removeFirst();
        }

        if (value == minDequeue.getFirst()) {
            minDequeue.removeFirst();
        }

        return OptionalInt.of(value);
    }

    OptionalInt max() {
        return maxDequeue.isEmpty() ? OptionalInt.empty() : OptionalInt.of(maxDequeue.getFirst());
    }

    OptionalInt min() {
        return minDequeue.isEmpty() ? OptionalInt.empty() : OptionalInt.of(minDequeue.getFirst());
    }

    OptionalInt peek() {
        return dataQueue.isEmpty() ? OptionalInt.empty() : OptionalInt.of(dataQueue.peek());
    }

    @Override
    public String toString() {
        return String.format("%s,max=%s,min=%s", dataQueue, max(), min());
    }
}
