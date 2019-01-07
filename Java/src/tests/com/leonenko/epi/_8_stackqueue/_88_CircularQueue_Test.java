package com.leonenko.epi._8_stackqueue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class _88_CircularQueue_Test {

    private static final List<Integer> DATA = List.of(10, 11, 12, 13, 14);

    private final _88_CircularQueue queue = new _88_CircularQueue(DATA.size());

    @BeforeEach
    void setUp() {
        DATA.forEach(queue::enqueue);
    }

    @Test
    void enqueued() {
        assertThat(queue.size()).isEqualTo(DATA.size());
    }

    @Test
    void dequeAll() {
        DATA.forEach(expected -> assertThat(queue.dequeue()).isEqualTo(expected));
    }

    @Test
    void enqueueMore() {
        queue.enqueue(100);
        queue.enqueue(200);

        assertThat(queue.size()).isEqualTo(DATA.size() + 2);

        DATA.forEach(expected -> assertThat(queue.dequeue()).isEqualTo(expected));

        assertThat(queue.dequeue()).isEqualTo(100);
        assertThat(queue.dequeue()).isEqualTo(200);
    }

    @Test
    void enqueueDequeHalfAndEnqueueMoreThenDequeueAll() {
        var halfSize = DATA.size() / 2;

        var additionalData = new ArrayList<>();

        for (int i = 0; i < halfSize; i++) {
            assertThat(queue.dequeue()).isEqualTo(DATA.get(i));

            var dataElement = i * 100;

            queue.enqueue(dataElement);

            additionalData.add(dataElement);
        }

        for (int i = halfSize; i < DATA.size(); i++) {
            assertThat(queue.dequeue()).isEqualTo(DATA.get(i));
        }

        for (var dataElement : additionalData) {
            assertThat(queue.dequeue()).isEqualTo(dataElement);
        }
    }
}