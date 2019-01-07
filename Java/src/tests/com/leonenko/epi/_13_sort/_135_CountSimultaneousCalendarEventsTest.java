package com.leonenko.epi._13_sort;

import org.junit.jupiter.api.Test;

class _135_CountSimultaneousCalendarEventsTest {

    @Test
    void countMaxSimultaneousEvents() {
    }

    public static void main(String[] args) {
        Interval[] calendar = {
                new Interval(1, 5),
                new Interval(2, 7),
                new Interval(4, 5),
                new Interval(6, 10),
                new Interval(8, 9),
                new Interval(9, 17),
                new Interval(11, 13),
                new Interval(14, 17),
                new Interval(12, 16),
        };

        var maxNumberOfSimultaneousEvents =
                _135_CountSimultaneousCalendarEvents.countMaxSimultaneousEvents(calendar);

        System.out.println(maxNumberOfSimultaneousEvents);
    }
}