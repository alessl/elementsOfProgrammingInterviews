package com.leonenko.epi._13_sort;

import java.util.Arrays;

import static java.util.Comparator.comparingInt;

/**
 * Created by Alex on 5/8/2017.
 */
public class _135_CountSimultaneousCalendarEvents {

    static int countMaxSimultaneousEvents(Interval[] events) {
        Endpoint[] endpoints = Arrays.stream(events)
                                     .map(i -> new Endpoint[]{ i.getStart(), i.getEnd()})
                                     .flatMap(Arrays::stream)
                                     .sorted(comparingInt(Endpoint::getValue))
                                     .toArray(Endpoint[]::new);

        var maxNumSimultaneousEvents = 0;
        var numSimultaneousEvents = 0;

        for (Endpoint endpoint : endpoints) {
            if (endpoint.isStart()) {
                numSimultaneousEvents++;
                maxNumSimultaneousEvents = Math.max(maxNumSimultaneousEvents, numSimultaneousEvents);
            } else {
                numSimultaneousEvents--;
            }
        }

        return maxNumSimultaneousEvents;
    }

    static int bruteForceCount(Interval[] events) {
        return -1;
    }

}
