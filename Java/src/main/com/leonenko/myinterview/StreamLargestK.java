package com.leonenko.myinterview;

import java.util.PrimitiveIterator;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringJoiner;

/**
 * Created by Alex on 4/19/2017.
 */
public class StreamLargestK {

    private static final String SPACE_DELIMITER = " ";

    public static void main(String[] args) {
        printLargestK(generateStream(), 5);
        printLargestK(generateStream(), 2);
    }

    private static void printLargestK(PrimitiveIterator.OfInt iterator, int largestK) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int numRepeated = 0;
        while (iterator.hasNext() && numRepeated++ < 10) {
            StringJoiner log = new StringJoiner(SPACE_DELIMITER);
            processValue(minHeap, iterator.nextInt(), log, largestK);
            System.out.println(log);
        }
    }

    private static void processValue(
            PriorityQueue<Integer> minHeap, int value, StringJoiner log, int largestK) {
        log.add(String.format("Value=%s", value));
        if (minHeap.size() < largestK) {
            minHeap.add(value);
            log.add(String.format("MinHeap=%s", minHeap));
        } else if (minHeap.peek() < value) {
            minHeap.remove();
            minHeap.add(value);
            log.add(String.format("MinHeap=%s, Largest(%s)=%s", minHeap, largestK, minHeap.peek()));
        }
    }

    private static PrimitiveIterator.OfInt generateStream() {
        int from = 0;
        int to = 1000;
        return new Random().ints(from, to).iterator();
    }
}
