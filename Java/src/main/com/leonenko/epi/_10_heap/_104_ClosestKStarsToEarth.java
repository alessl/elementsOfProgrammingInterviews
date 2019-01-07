package com.leonenko.epi._10_heap;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class _104_ClosestKStarsToEarth {

    public static List<Star> findClosestKStars(List<Star> stars, int k) {
        var maxHeap = new PriorityQueue<Star>(Comparator.reverseOrder());

        for (Star star : stars) {
            maxHeap.add(star);

            if (maxHeap.size() == k + 1) {
                maxHeap.remove();
            }
        }

        return maxHeap.stream()
                      .sorted()
                      .collect(Collectors.toList());
    }

    @EqualsAndHashCode
    @RequiredArgsConstructor
    static class Star implements Comparable<Star> {

        private final int distanceToEarth;

        @Override
        public int compareTo(Star otherStar) {
            return Double.compare(distanceToEarth, otherStar.distanceToEarth);
        }
    }
}
