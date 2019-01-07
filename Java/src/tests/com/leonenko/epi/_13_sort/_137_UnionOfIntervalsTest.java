package com.leonenko.epi._13_sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static com.leonenko.epi._13_sort.Interval.*;
import static com.leonenko.epi._13_sort._137_UnionOfIntervals.union;
import static org.assertj.core.api.Assertions.assertThat;

class _137_UnionOfIntervalsTest {

    @Test
    void test() {
        Interval[] intervals = {
                open(0, 3),
                closed(1, 1),
                startClosed(2, 4),
                startClosed(3, 4),
                startClosed(5, 7),
                startClosed(7, 8),
                startClosed(8, 11),
                endClosed(9, 11),
                closed(12, 14),
                endClosed(12, 16),
                open(13, 15),
                open(16, 17),
        };

        sort(intervals);

        Interval[] union = union(intervals);

        assertThat(union)
                .usingElementComparator(
                        Comparator.comparing(Interval::getStart)
                                  .thenComparing(Interval::isStartClosed)
                                  .thenComparing(Interval::getEnd)
                                  .thenComparing(Interval::isEndClosed))
                .containsExactly(
                        endClosed(0, 4), closed(5, 11), startClosed(12, 17));
    }

    private void sort(Interval[] intervals) {
        Arrays.sort(intervals, (i, j) -> {
            var comp = Integer.compare(i.getStart().getValue(), j.getStart().getValue());

            if (comp != 0) {
                return comp;
            }

            if (i.isStartClosed() && !j.isStartClosed()) {
                return -1;
            }

            if (!i.isStartClosed() && j.isStartClosed()) {
                return 1;
            }

            return 0;
        });
    }
}