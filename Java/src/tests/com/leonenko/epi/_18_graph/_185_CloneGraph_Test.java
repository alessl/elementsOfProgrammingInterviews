package com.leonenko.epi._18_graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static com.leonenko.epi._18_graph._185_CloneGraph.cloneGraph;
import static org.assertj.core.api.Assertions.assertThat;

class _185_CloneGraph_Test {

    private final GraphVertex vertex1 = new GraphVertex(1);
    private final GraphVertex vertex2 = new GraphVertex(2);
    private final GraphVertex vertex3 = new GraphVertex(3);
    private final GraphVertex vertex4 = new GraphVertex(4);
    private final GraphVertex vertex5 = new GraphVertex(5);

    @BeforeEach
    void setUp() {
        vertex1.addEdge(vertex2);
        vertex1.addEdge(vertex3);
        vertex2.addEdge(vertex4);
        vertex3.addEdge(vertex5);
        vertex5.addEdge(vertex1);
    }

    @Test
    void testGraphClone() {
        assertThat(cloneGraph(vertex1))
                .satisfies(clone -> assertClone(vertex1, clone, new HashSet<>()));
    }

    private void assertClone(GraphVertex vertex, GraphVertex vertexClone, Set<Integer> visited) {
        if (!visited.add(vertex.getName())) {
            return;
        }

        assertThat(vertexClone).isNotSameAs(vertex);
        assertThat(vertexClone.getName()).isEqualTo(vertex.getName());
        assertThat(vertexClone.getEdges()).hasSameSizeAs(vertex.getEdges());

        for (int i = 0; i < vertexClone.getEdges().size(); i++) {
            assertClone(vertex.getEdges().get(i), vertexClone.getEdges().get(i), visited);
        }
    }
}