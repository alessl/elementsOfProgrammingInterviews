package com.leonenko.epi._18_graph;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class _184_DeadlockDetection {

    static boolean isDeadlockPossible(List<GraphVertex> graph) {
        var graphCopy = graph.stream()
                .collect(Collectors.toMap(GraphVertex::getName, VertexWrapper::new));

        for (VertexWrapper currVertex : graphCopy.values()) {
            if (currVertex.state == VertexState.NOT_STARTED && hasCycle(currVertex, graphCopy)) {
                return true;
            }
        }

        return false;
    }

    private static boolean hasCycle(VertexWrapper currVertex, Map<Integer, VertexWrapper> graph) {
        if (currVertex.state == VertexState.STARTED) {
            return true;
        }

        if (currVertex.state == VertexState.VISITED) {
            return false;
        }

        currVertex.state = VertexState.STARTED;

        boolean isCycleFound = currVertex.edges.stream()
                .map(v -> graph.get(v.getName()))
                .dropWhile(nextVertex -> !hasCycle(nextVertex, graph))
                .findAny()
                .isPresent();

        currVertex.state = VertexState.VISITED;

        return isCycleFound;
    }

    enum VertexState { NOT_STARTED, STARTED, VISITED }

    private static class VertexWrapper {
        private final List<GraphVertex> edges;
        private VertexState state = VertexState.NOT_STARTED;

        VertexWrapper(GraphVertex actualVertex) {
            this.edges = actualVertex.getEdges();
        }
    }

}
