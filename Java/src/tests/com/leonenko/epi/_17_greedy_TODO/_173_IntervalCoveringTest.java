package com.leonenko.epi._17_greedy_TODO;

import com.leonenko.epi._17_greedy_TODO._173_IntervalCovering.Interval;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._17_greedy_TODO._173_IntervalCovering.getMinimumVisits;
import static org.assertj.core.api.Assertions.assertThat;

class _173_IntervalCoveringTest {

    @Test
    void testGetMinimumNumVisits() {
        var minimumNumVisits = getMinimumVisits(List.of(Interval.of(0, 3),
                Interval.of(3, 4), Interval.of(2, 6), Interval.of(6, 9)));
        assertThat(minimumNumVisits).containsExactly(3, 6);
    }

}