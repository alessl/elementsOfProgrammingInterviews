package com.leonenko.epi._5_array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _515_ComputeRandomSubSet {

    static List<Integer> generateRandomSubSet(int bound, int subSetSize) {
        var changedElements = new HashMap<Integer, Integer>();
        var random = new Random();

        for (int i = 0; i < subSetSize; i++) {
            var randomIdx = random.nextInt(bound - i);
            var p1 = changedElements.get(randomIdx);
            var p2 = changedElements.get(i);

            if (p1 == null && p2 == null) {
                changedElements.put(randomIdx, i);
                changedElements.put(i, randomIdx);
            } else if (p1 == null && p2 != null) {
                changedElements.put(randomIdx, p2);
                changedElements.put(i, randomIdx);
            } else if (p1 != null && p2 == null) {
                changedElements.put(i, p1);
                changedElements.put(randomIdx, i);
            } else {
                changedElements.put(i, p1);
                changedElements.put(randomIdx, p2);
            }
        }

        return IntStream.range(0, subSetSize)
                        .map(changedElements::get)
                        .boxed()
                        .collect(Collectors.toList());
    }
}
