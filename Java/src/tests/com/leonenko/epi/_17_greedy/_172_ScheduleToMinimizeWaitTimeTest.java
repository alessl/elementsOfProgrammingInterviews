package com.leonenko.epi._17_greedy;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._17_greedy._172_ScheduleToMinimizeWaitTime.getMinimumWaitingTime;
import static org.assertj.core.api.Assertions.assertThat;

class _172_ScheduleToMinimizeWaitTimeTest {

    @Test
    void testGetMinimumWaitingTime() {
        assertThat(getMinimumWaitingTime(List.of(2, 5, 1, 3))).isEqualTo(10);
    }

}