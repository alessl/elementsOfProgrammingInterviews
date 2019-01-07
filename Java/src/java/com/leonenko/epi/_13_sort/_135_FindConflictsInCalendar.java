package com.leonenko.epi._13_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.singleton;
import static java.util.stream.Collectors.toList;

/**
 * Created by Alex on 5/8/2017.
 */
public class _135_FindConflictsInCalendar {

    public static void main(String[] args) {
        Interval[] intervals = {
                new Interval(1, 5),
                new Interval(2, 7),
                new Interval(4, 5),
                new Interval(6, 10),
                new Interval(8, 9),
                new Interval(12, 16),
                new Interval(17, 17),
                new Interval(18, 20),
                new Interval(19, 25),
        };
        Arrays.sort(intervals);
        System.out.println(Arrays.toString(intervals));
        List<List<Interval>> conflicts = getConflicts(intervals);
        System.out.println(conflicts);
    }

    private static List<List<Interval>> getConflicts(Interval[] intervals) {
        List<List<Interval>> conflicts = new ArrayList<>();

        Interval curr = intervals[0];
        List<Interval> currConflicts = new ArrayList<>(singleton(curr));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].getStart().compareTo(curr.getEnd()) <= 0) {
                currConflicts.add(intervals[i]);
            } else {
                conflicts.add(new ArrayList<>(currConflicts));
                curr = intervals[i];
                currConflicts.clear();
                currConflicts.add(curr);
            }
        }
        conflicts.add(new ArrayList<>(currConflicts));
        return conflicts.stream()
                .filter(c -> c.size() > 1)
                .collect(toList());
    }
}
