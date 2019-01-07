package com.leonenko.epi._13_sort;

import java.util.ArrayList;

/**
 * Created by Alex on 5/8/2017.
 */
public class _137_UnionOfIntervals {

    static Interval[] union(Interval[] intervals) {
        var union = new ArrayList<>();
        var unionLast = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            var curr = intervals[i];
            var currStart = curr.getStart();
            var lastEnd = unionLast.getEnd();

            var isIntersect = currStart.compareTo(lastEnd) < 0
                    || (currStart.compareTo(lastEnd) == 0 && currStart.isClosed() || lastEnd.isClosed());

            if (isIntersect) {
                var currentEnd = curr.getEnd();

                if (currentEnd.compareTo(lastEnd) > 0
                        || (currentEnd.compareTo(lastEnd) == 0 && currentEnd.isClosed())) {
                    unionLast = new Interval(unionLast.getStart().getValue(), currentEnd.getValue());
                }
            } else {
                union.add(unionLast);
                unionLast = curr;
            }
        }

        union.add(unionLast);

        return union.toArray(new Interval[union.size()]);
    }
}
