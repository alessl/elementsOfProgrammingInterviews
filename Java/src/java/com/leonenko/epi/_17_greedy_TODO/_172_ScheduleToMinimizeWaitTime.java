package com.leonenko.epi._17_greedy_TODO;

import java.util.List;
import java.util.stream.Collectors;

public class _172_ScheduleToMinimizeWaitTime {

    static int getMinimumWaitingTime(List<Integer> queryDurations) {
        queryDurations = queryDurations.stream()
                .sorted()
                .collect(Collectors.toList());

        int totalWaitingTime = 0;

        for (int i = 0; i < queryDurations.size(); i++) {
            int numRemainingQueries = queryDurations.size() - i - 1;
            totalWaitingTime += queryDurations.get(i) * numRemainingQueries;
        }

        return totalWaitingTime;
    }
}
