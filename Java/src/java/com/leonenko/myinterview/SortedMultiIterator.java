package com.leonenko.myinterview;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;

/**
 * Created by Alex on 4/18/2017.
 */
public class SortedMultiIterator implements Iterable<Integer> {

    private final PriorityQueue<PeekingIterator> heap;

    private SortedMultiIterator(List<PrimitiveIterator.OfInt> iterators) {
        this.heap = createHeap(iterators);
    }

    private PriorityQueue<PeekingIterator> createHeap(List<PrimitiveIterator.OfInt> iterators) {
        return iterators
                .stream()
                .filter(PrimitiveIterator.OfInt::hasNext)
                .map(PeekingIterator::new)
                .collect(toCollection(PriorityQueue::new));
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private PeekingIterator iterator;

            @Override
            public boolean hasNext() {
                return !heap.isEmpty() || iterator != null && iterator.hasNext();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (iterator != null && iterator.hasNext()) {
                    heap.add(iterator);
                }
                do {
                    iterator = heap.poll();
                } while (!iterator.hasNext() && !heap.isEmpty());
                return iterator.next().orElseThrow(NoSuchElementException::new);
            }
        };
    }

    private static final class PeekingIterator
            implements Comparable<PeekingIterator>, Iterator<OptionalInt> {
        private PrimitiveIterator.OfInt iterator;
        private OptionalInt value = OptionalInt.empty();

        private PeekingIterator(PrimitiveIterator.OfInt iterator) {
            this.iterator = iterator;
            next();
        }

        @Override
        public int compareTo(PeekingIterator o) {
            if (value.isPresent() && o.value.isPresent()) {
                return Integer.compare(value.getAsInt(), o.value.getAsInt());
            }
            if (value.isPresent()) {
                return 1;
            }
            if (o.value.isPresent()) {
                return -1;
            }
            return 0;
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext() || value.isPresent();
        }

        @Override
        public OptionalInt next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            OptionalInt oldValue = value;
            value = iterator.hasNext() ? OptionalInt.of(iterator.nextInt()) : OptionalInt.empty();
            return oldValue;
        }
    }

    public static void main(String[] args) {
        List<PrimitiveIterator.OfInt> iterators = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List<Integer> list = createList();
            System.out.println(list);

            PrimitiveIterator.OfInt iterator = list
                    .stream()
                    .mapToInt(Integer::intValue)
                    .iterator();
            iterators.add(iterator);
        }
        SortedMultiIterator iterator = new SortedMultiIterator(iterators);
        StringJoiner joiner = new StringJoiner(" ", "Merged stream: ", "");
        for (int value : iterator) {
            joiner.add(String.valueOf(value));
        }
        System.out.println(joiner.toString());
    }

    private static List<Integer> createList() {
        Random random = new Random();
        int seed = random.nextInt(100);
        int size = random.nextInt(10);
        return IntStream.iterate(seed, current -> current + random.nextInt(10))
                .limit(size)
                .sorted()
                .boxed()
                .collect(toList());
    }


}
