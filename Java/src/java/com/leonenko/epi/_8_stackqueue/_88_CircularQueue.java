package com.leonenko.epi._8_stackqueue;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Alex on 4/30/2017.
 */
public class _88_CircularQueue {

    private Integer[] data;

    private int headIndex = 0;
    private int tailIndex = 0;
    private int size = 0;

    _88_CircularQueue(int size) {
        this.data = new Integer[size];
    }

    void enqueue(int value) {
        if (size == data.length) {
            enlarge();
        }

        data[tailIndex] = value;
        tailIndex = (tailIndex + 1) % data.length;
        size++;
    }

    private void enlarge() {
        resize(data.length * 2);
    }

    int dequeue() {
        if (size == 0) {
            throw new IllegalStateException();
        }

        var value = data[headIndex];
        data[headIndex] = null;
        headIndex = (headIndex + 1) % data.length;
        size--;

        if (size <= data.length / 4) {
            shrink();
        }

        return value;
    }

    private void shrink() {
        resize(data.length / 2);
    }

    private void resize(int newSize) {
        Collections.rotate(Arrays.asList(data), -headIndex);
        data = Arrays.copyOf(data, newSize);
        tailIndex = size;
        headIndex = 0;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
