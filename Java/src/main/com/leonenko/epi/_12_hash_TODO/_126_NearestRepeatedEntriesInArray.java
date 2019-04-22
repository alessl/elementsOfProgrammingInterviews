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

        for (var entry : entries) {
            if (charToIndexMap.containsKey(entry)) {
                var prevIndex = charToIndexMap.get(entry);
                var dist = index - prevIndex;

                if (minDistBetweenEntries > dist) {
                    nearestRepeatedEntries = List.of(prevIndex, index);
                    minDistBetweenEntries = dist;
                }

            }
            charToIndexMap.put(entry, index++);
        }

        return nearestRepeatedEntries;
    }
}
