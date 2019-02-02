package com.leonenko.epi._12_hash_TODO;

import java.util.HashMap;
import java.util.List;

public class _126_NearestRepeatedEntriesInArray {
    static List<Integer> findNearestRepeatedEntries(List<Character> entries) {
        var nearestEntries = List.<Integer>of();
        var shortestDist = Integer.MAX_VALUE;
        var charToIndex = new HashMap<Character, Integer>();
        var index = 0;

        for (var c : entries) {
            if (charToIndex.containsKey(c)) {
                var prevIndex = charToIndex.get(c);
                int dist = index - prevIndex;

                if (shortestDist > dist) {
                    nearestEntries = List.of(prevIndex, index);
                    shortestDist = dist;
                }

            }
            charToIndex.put(c, index++);
        }

        return nearestEntries;
    }
}
