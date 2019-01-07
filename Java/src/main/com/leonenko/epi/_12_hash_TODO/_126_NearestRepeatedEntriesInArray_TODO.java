package com.leonenko.epi._12_hash_TODO;

import java.util.HashMap;
import java.util.List;

public class _126_NearestRepeatedEntriesInArray_TODO {
    static List<Integer> findNearestRepeatedEntries(List<Character> entries) {
        var nearestEntries = List.<Integer>of();
        var shortestDist = Integer.MAX_VALUE;
        var lastIndex = new HashMap<Character, Integer>();
        var index = 0;

        for (var c : entries) {
            if (lastIndex.containsKey(c)) {
                var prevIndex = lastIndex.get(c);
                int dist = index - prevIndex;

                if (shortestDist > dist) {
                    nearestEntries = List.of(prevIndex, index);
                    shortestDist = dist;
                }

            }
            lastIndex.put(c, index++);
        }

        return nearestEntries;
    }
}
