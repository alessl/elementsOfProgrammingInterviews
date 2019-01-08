package com.leonenko.epi._17_greedy;

import com.leonenko.epi._17_greedy._171_OptimumAssignmentOfTasks.TaskPair;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._17_greedy._171_OptimumAssignmentOfTasks.getOptimalAssignment;
import static org.assertj.core.api.Assertions.assertThat;

class _171_OptimumAssignmentOfTasksTest {

    @Test
    void testGetOptimalAssignment() {
        assertThat(getOptimalAssignment(List.of(2, 1, 4, 6, 5, 4)))
                .containsExactly(TaskPair.of(1, 6),
                        TaskPair.of(2, 5),
                        TaskPair.of(4, 4));
    }

}