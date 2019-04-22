package com.leonenko.epi._12_hash_TODO;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class _126_NearestRepeatedEntriesInArray {

    static List<Integer> findNearestRepeatedEntries(List<Character> entries) {
        var nearestRepeatedEntries = List.<Integer>of();
        var minDistBetweenEntries = Integer.MAX_VALUE;
        var charToIndexMap = new HashMap<Character, Integer>();
        var index = 0;

        for (var c : entries) {
            if (charToIndexMap.containsKey(c)) {
                var prevIndex = charToIndexMap.get(c);
                int dist = index - prevIndex;

                if (minDistBetweenEntries > dist) {
                    nearestRepeatedEntries = List.of(prevIndex, index);
                    minDistBetweenEntries = dist;
                }

            }
            charToIndexMap.put(c, index++);
        }

        return nearestRepeatedEntries;
    }
}
