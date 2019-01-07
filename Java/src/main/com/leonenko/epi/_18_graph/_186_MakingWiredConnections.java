package com.leonenko.epi._18_graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class _186_MakingWiredConnections {

    static boolean isPlacementPossible(Map<Integer, List<Integer>> pinsAndWires) {
        Map<Integer, GraphVertex> vertexMap = pinsAndWires.keySet().stream()
                .map(GraphVertex::new)
                .collect(Collectors.toMap(GraphVertex::getName, v -> v));

        List<GraphVertex> graph = pinsAndWires.keySet().stream()
                .map(vertexMap::get)
                .map(vertex -> pinsAndWires.get(vertex.getName()).stream()
                        .map(vertexMap::get)
                        .peek(vertex::addEdge)
                        .findFirst()
                        .orElse(vertex))
                .collect(Collectors.toList());

        return isPlacementPossible(graph);
    }

    private static boolean isPlacementPossible(List<GraphVertex> graph) {
        List<GraphVertexWrapper> graphCopy = graph.stream()
                .map(GraphVertexWrapper::new)
                .collect(Collectors.toList());

        for (var vertex : graphCopy) {
            if (vertex.distance == -1 && !isPlacementPossible(vertex)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isPlacementPossible(GraphVertexWrapper startVertex) {
        startVertex.distance = 0;

        var unvisitedQueue = new LinkedList<>(List.of(startVertex));

        while (!unvisitedQueue.isEmpty()) {
            var currVertex = unvisitedQueue.poll();

            for (var neighborVertex : currVertex.edges) {
                if (neighborVertex.distance == -1) {
                    neighborVertex.distance = currVertex.distance + 1;

                    unvisitedQueue.add(neighborVertex);
                } else if (neighborVertex.distance == currVertex.distance) {
                    return false;
                }
            }
        }

        return true;
    }

    private static class GraphVertexWrapper {
        private final List<GraphVertexWrapper> edges;
        private int distance;

        GraphVertexWrapper(GraphVertex graphVertex) {
            this.edges = graphVertex.getEdges()
                    .stream()
                    .map(GraphVertexWrapper::new)
                    .collect(Collectors.toList());
        }
    }
}
