package com.leonenko.epi._8_stackqueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class _89_QueueOnStacks_TODO {

    private final Deque<Integer> enqueueStack = new LinkedList<>();
    private final Deque<Integer> dequeueStack = new LinkedList<>();

    void enqeue(int value) {
        enqueueStack.addFirst(value);
    }

    int dequeue() {
        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }

        if (dequeueStack.isEmpty()) {
            return dequeueStack.pop();
        }

        throw new NoSuchElementException("Can not dequeue from an empty queue");
    }
}
