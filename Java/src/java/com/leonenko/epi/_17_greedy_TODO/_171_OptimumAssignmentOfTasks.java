package com.leonenko.epi._17_greedy_TODO;

import lombok.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class _171_OptimumAssignmentOfTasks {

    static List<TaskPair> getOptimalAssignment(List<Integer> tasks) {
        tasks= tasks.stream()
                .sorted()
                .collect(Collectors.toList());

        var taskAssignment = new ArrayList<TaskPair>();

        for (var shortIndex = 0; shortIndex < tasks.size() / 2; shortIndex++) {
            var longIndex = tasks.size() - shortIndex - 1;

            taskAssignment.add(new TaskPair(tasks.get(shortIndex), tasks.get(longIndex)));
        }

        return taskAssignment;
    }

    @Value(staticConstructor = "of")
    static class TaskPair {
        private int shortTask;
        private int longTask;
    }
}
