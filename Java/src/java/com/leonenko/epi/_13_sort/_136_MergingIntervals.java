package com.leonenko.epi._13_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alex on 5/8/2017.
 */
public class _136_MergingIntervals {

    public static void main(String[] args) {
        Interval[] intervals = {
                new Interval(-4, -1),
                new Interval(0, 2),
                new Interval(3, 6),
                new Interval(7, 9),
                new Interval(11, 12),
                new Interval(14, 17),
        };
        Arrays.sort(intervals);
        System.out.println(Arrays.toString(intervals));
        intervals = mergeIntervals(intervals, new Interval(1, 8));
        System.out.println(Arrays.toString(intervals));
    }

    static Interval[] mergeIntervals(Interval[] intervals, Interval newInterval) {
        var start = 0;

        while (start < intervals.length && intervals[start].isBefore(newInterval)) {
            start++;
        }

        var end = start;

        while (end < intervals.length && !intervals[end].isAfter(newInterval)) {
            var newStart = newInterval.getStart()
                                      .min(intervals[end].getStart())
                                      .getValue();
            var newEnd = newInterval.getEnd()
                                    .max(intervals[end].getEnd())
                                    .getValue();
            newInterval = new Interval(newStart, newEnd);
            end++;
        }

        var newLen = start + intervals.length - end + 1;
        var newIntervals = Arrays.copyOf(intervals, newLen);
        newIntervals[start++] = newInterval;

        while (start < newLen) {
            newIntervals[start++] = intervals[end++];
        }

        return newIntervals;
    }

    static List<Interval> mergeIntervals(List<Interval> intervals, Interval newInterval) {
        var idx = 0;
        var mergedIntervals = new ArrayList<Interval>();

        while (idx < intervals.size() && intervals.get(idx).isBefore(newInterval)) {
            mergedIntervals.add(intervals.get(idx));
        }

        while (idx < intervals.size() && !intervals.get(idx).isAfter(newInterval)) {
            var newStart = newInterval.getStart()
                                      .min(intervals.get(idx).getStart())
                                      .getValue();
            var newEnd = newInterval.getEnd()
                                    .max(intervals.get(idx).getEnd())
                                    .getValue();
            newInterval = new Interval(newStart, newEnd);
            idx++;
        }

        mergedIntervals.addAll(intervals.subList(idx, intervals.size()));

        return mergedIntervals;
    }

    static List<Interval> bruteForceMergeIntervals(List<Interval> intervals,
                                                   Interval newInterval) {
        return List.of();
    }
}
