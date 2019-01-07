package com.leonenko.epi._17_greedy_TODO;

import lombok.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class _173_IntervalCovering {

    static List<Integer> getMinimumVisits(List<Interval> intervals) {
        var visits = new ArrayList<Integer>();

        intervals = intervals.stream()
                .sorted(comparing(Interval::getEnd))
                .collect(Collectors.toList());

        var currentVisit = Integer.MIN_VALUE;

        for (Interval interval : intervals) {
            if (currentVisit < interval.start) {
                currentVisit = interval.end;

                visits.add(currentVisit);
            }
        }

        return visits;
    }

    @Value(staticConstructor = "of")
    static final class Interval {
        private int start;
        private int end;
    }
}
