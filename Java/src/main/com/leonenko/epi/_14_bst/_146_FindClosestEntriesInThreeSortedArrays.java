package com.leonenko.epi._14_bst;

import lombok.ToString;
import lombok.ToString.Include;

import java.util.*;
import java.util.stream.Collectors;

public class _146_FindClosestEntriesInThreeSortedArrays {

    static int findMinDistanceBetweenEntries(Collection<List<Integer>> sortedLists) {
        var minDistance = Integer.MAX_VALUE;

        var orderedListHeads = sortedLists.stream()
                                          .map(List::iterator)
                                          .map(TreeEntry::new)
                                          .collect(Collectors.toCollection(TreeSet::new));

        while (orderedListHeads.size() == sortedLists.size()) {
            var minEntry = orderedListHeads.pollFirst();
            var maxEntry = orderedListHeads.last();
            var minToMaxDistance = minEntry.distanceTo(maxEntry);

            minDistance = Math.min(minDistance, minToMaxDistance);

            minEntry.nextEntry().ifPresent(orderedListHeads::add);
        }

        return minDistance;
    }

    @ToString(onlyExplicitlyIncluded = true)
    private static class TreeEntry implements Comparable<TreeEntry> {
        private final Iterator<Integer> iterator;
        @Include
        private int value;

        public TreeEntry(Iterator<Integer> iterator) {
            this.iterator = iterator;
            this.value = this.iterator.next();
        }

        public int distanceTo(TreeEntry other) {
            return Math.abs(value - other.value);
        }

        public Optional<TreeEntry> nextEntry() {
            return iterator.hasNext() ? Optional.of(new TreeEntry(iterator)) : Optional.empty();
        }

        @Override
        public int compareTo(TreeEntry e) {
            var compareResult = Integer.compare(value, e.value);
            return compareResult == 0 ? 1 : compareResult;
        }
    }
}
