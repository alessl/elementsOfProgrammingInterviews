package com.leonenko.epi._8_stackqueue;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.stream;
import static org.assertj.core.api.Assertions.assertThat;

class _810_QueueWithMax_Test {

    private final _810_QueueWithMax queue = new _810_QueueWithMax();

    @Test
    void enqueue() {
        assertEnqueue(10, 10, 10, 10);

        assertEnqueue(20, 10, 10, 20);

        assertEnqueue(30, 10, 10, 30);

        assertEnqueue(5, 10, 5, 30);

        assertEnqueue(2, 10, 2, 30);

        assertThat(queue.dequeue()).hasValue(10);

        assertQueueContent(20, 2, 30);

        assertThat(queue.dequeue()).hasValue(20);

        assertQueueContent(30, 2, 30);

        assertThat(queue.dequeue()).hasValue(30);

        assertQueueContent(5, 2, 5);
    }

    private void assertEnqueue(int valToEnqueue, int peekVal, int minVal, int maxVal) {
        addToQueue(valToEnqueue);
        assertQueueContent(peekVal, minVal, maxVal);
    }

    private void assertQueueContent(int peekVal, int minVal, int maxVal) {
        assertThat(queue.peek()).hasValue(peekVal);
        assertThat(queue.min()).hasValue(minVal);
        assertThat(queue.max()).hasValue(maxVal);
    }

    private void addToQueue(int... values) {
        stream(values).forEach(queue::enqueue);
    }

}