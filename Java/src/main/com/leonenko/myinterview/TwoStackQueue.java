package com.leonenko.myinterview;

import java.util.Deque;
import java.util.LinkedList;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * Created by Alex on 4/19/2017.
 */
public class TwoStackQueue {

    public static void main(String[] args) {
        Queue queue = new Queue();
        int maxSize = 10;
        IntStream
                .iterate(0, Math::incrementExact)
                .limit(maxSize)
                .forEach(queue::add);
        IntStream
                .iterate(0, Math::incrementExact)
                .limit(maxSize)
                .mapToObj(i -> queue.remove())
                .filter(OptionalInt::isPresent)
                .mapToInt(OptionalInt::getAsInt)
                .forEach(System.out::println);
    }

    private static final class Queue {
        private Deque<Integer> stack = new LinkedList<>();

        void add(int value) {
            stack.push(value);
        }

        OptionalInt remove() {
           if (stack.isEmpty()) {
               return OptionalInt.empty();
           }
           int top = stack.pop();
           OptionalInt result = remove();
           if (!result.isPresent()) {
               return OptionalInt.of(top);
           }
           stack.push(top);
           return result;
        }
    }
}
