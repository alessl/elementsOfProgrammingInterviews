package com.leonenko.epi._18_graph;

import lombok.Value;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Value
final class Point {

    enum PointType {
        START, OPEN, WALL, GOAL
    }

    private int row;
    private int col;

    @Override
    public String toString() {
        return String.format("(%s,%s)", row, col);
    }
}
