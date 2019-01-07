package com.leonenko.epi._13_sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static com.leonenko.epi._13_sort._136_MergingIntervals.mergeIntervals;
import static java.util.Comparator.comparing;
import static org.assertj.core.api.Assertions.assertThat;

class _136_MergingIntervalsTest {

    private static final Comparator<Interval> INTERVAL_COMPARATOR = comparing(Interval::getStart)
            .thenComparing(Interval::getEnd);

    private Interval newInterval;
    private List<Interval> intervals;
    private List<Interval> expectedMergedIntervals;

    @BeforeEach
    void setUp() {
        this.newInterval = new Interval(1, 8);
        this.intervals = List.of(
                new Interval(-4, -1),
                new Interval(0, 2),
                new Interval(3, 6),
                new Interval(7, 9),
                new Interval(11, 12),
                new Interval(14, 17));
        this.expectedMergedIntervals = List.of(
                new Interval(-4, -1),
                new Interval(0, 9),
                new Interval(11, 12),
                new Interval(14, 17));
    }

    @Test
    void testMergeArrayOfIntervals() {
        assertThat(mergeIntervals(intervals.toArray(Interval[]::new), newInterval))
                .usingElementComparator(INTERVAL_COMPARATOR)
                .containsExactlyElementsOf(expectedMergedIntervals);
    }

    @Test
    void testMergeListOfIntervals() {
        assertThat(mergeIntervals(intervals, newInterval))
                .usingElementComparator(INTERVAL_COMPARATOR)
                .containsExactlyElementsOf(expectedMergedIntervals);
    }
}