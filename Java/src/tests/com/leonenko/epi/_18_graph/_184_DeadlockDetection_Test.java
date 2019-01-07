package com.leonenko.epi._18_graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._18_graph._184_DeadlockDetection.isDeadlockPossible;
import static org.assertj.core.api.Assertions.assertThat;

class _184_DeadlockDetection_Test {

    private final GraphVertex vertex1 = new GraphVertex(1);
    private final GraphVertex vertex2 = new GraphVertex(2);
    private final GraphVertex vertex3 = new GraphVertex(3);
    private final GraphVertex vertex4 = new GraphVertex(4);
    private final GraphVertex vertex5 = new GraphVertex(5);

    private final List<GraphVertex> graph = List.of(vertex1, vertex2, vertex3, vertex4, vertex5);

    @BeforeEach
    void setUp() {
        vertex1.addEdge(vertex2);
        vertex1.addEdge(vertex3);
        vertex2.addEdge(vertex4);
        vertex3.addEdge(vertex5);
    }

    @Test
    void testDeadlockDetected() {
        vertex5.addEdge(vertex1);

        assertThat(isDeadlockPossible(graph)).isTrue();
    }

    @Test
    void testNoDeadlockDetected() {
        assertThat(isDeadlockPossible(graph)).isFalse();
    }

}