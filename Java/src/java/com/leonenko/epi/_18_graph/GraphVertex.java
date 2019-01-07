package com.leonenko.epi._18_graph;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
class GraphVertex {
    @Getter
    private final int name;
    @Getter
    private List<GraphVertex> edges = new ArrayList<>();

    GraphVertex addEdge(GraphVertex otherVertex) {
        edges.add(otherVertex);
        return this;
    }
}
