package com.leonenko.epi._24_honor_TODO;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _2430_MeasureWithDefectiveJugs_TODO {

    static class VolumeRange {
        private int low;
        private int high;

        public VolumeRange(int low, int high) {
            this.low = low;
            this.high = high;
        }

        static boolean checkPossible(List<Jug> jugs,
                                     int low, int high) {
            return checkPossible(jugs, low, high, new HashSet<>());
        }

        private static boolean checkPossible(List<Jug> jugs,
                                             int low, int high, Set<VolumeRange> cache) {
            VolumeRange volumeRange = new VolumeRange(low, high);

            if (low > high || cache.contains(volumeRange) || (low < 0 && high < 0)) {
                return false;
            }

            for (Jug jug : jugs) {
                if ((low <= jug.low && jug.high <= high)
                        || checkPossible(jugs, low - jug.low, high - jug.high, cache)) {
                    return true;
                }
            }

            cache.add(volumeRange);

            return false;
        }

        @Override
        public int hashCode() {
            return HashCodeBuilder.reflectionHashCode(this);
        }

        @Override
        public boolean equals(Object o) {
            return EqualsBuilder.reflectionEquals(this, o);
        }
    }

    static class Jug {
        private int low;
        private int high;

        public Jug(int low, int high) {
            this.low = low;
            this.high = high;
        }
    }
}
