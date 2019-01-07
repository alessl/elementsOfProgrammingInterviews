package com.leonenko.epi._17_greedy_TODO;

import com.leonenko.epi._17_greedy_TODO._171_OptimumAssignmentOfTasks.TaskPair;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._17_greedy_TODO._171_OptimumAssignmentOfTasks.getOptimalAssignment;
import static org.assertj.core.api.Assertions.assertThat;

class _171_OptimumAssignmentOfTasks_Test {

    @Test
    void testGetOptimalAssignment() {
        assertThat(getOptimalAssignment(List.of(2, 1, 4, 6, 5, 4)))
                .containsExactly(TaskPair.of(1, 6),
                        TaskPair.of(2, 5),
                        TaskPair.of(4, 4));
    }

}