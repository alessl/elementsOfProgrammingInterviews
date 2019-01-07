package com.leonenko.epi._18_graph;

import java.util.*;

public class _185_CloneGraph {

    static GraphVertex cloneGraph(GraphVertex startVertex) {
        var startVertexClone = new GraphVertex(startVertex.getName());
        var vertexCloneMap = new HashMap<>(Map.of(startVertex.getName(), startVertexClone));
        var originalVertexQueue = new LinkedList<>(List.of(startVertex));

        while (!originalVertexQueue.isEmpty()) {
            var originalVertex = originalVertexQueue.poll();
            var vertexClone = vertexCloneMap.get(originalVertex.getName());

            for (var originalNeighbor : originalVertex.getEdges()) {
                var originalNeighborName = originalNeighbor.getName();
                var neighborClone = vertexCloneMap.get(originalNeighborName);

                if (neighborClone == null) {
                    neighborClone = new GraphVertex(originalNeighborName);

                    vertexCloneMap.put(originalNeighborName, neighborClone);

                    originalVertexQueue.add(originalNeighbor);
                }

                vertexClone.addEdge(neighborClone);
            }
        }

        return vertexCloneMap.get(startVertex.getName());
    }

}
