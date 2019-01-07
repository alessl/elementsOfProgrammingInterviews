package com.leonenko.epi._18_graph;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._18_graph.Point.PointType.*;
import static com.leonenko.epi._18_graph.Point.PointType;
import static com.leonenko.epi._18_graph._181_SearchMaze.findAnyPath;
import static org.assertj.core.api.Assertions.assertThat;

class _181_SearchMaze_Test {

    private static final PointType[][] MAZE = new PointType[][] {
            { START, WALL, OPEN, OPEN,  OPEN },
            { OPEN,  OPEN,  OPEN, WALL, OPEN },
            { OPEN, WALL, OPEN, WALL, OPEN },
            { OPEN,  OPEN,  OPEN, OPEN,  OPEN },
            { OPEN, WALL, OPEN, WALL, GOAL }};

    private static final Point START_POINT = new Point(0, 0);
    private static final Point GOAL_POINT = new Point(MAZE.length - 1,
            MAZE[MAZE.length - 1].length - 1);

    @Test
    void testFindPath() {
        List<Point> path = findAnyPath(MAZE, START_POINT, GOAL_POINT);

        assertThat(path).hasToString(
                "[(0,0), (1,0), (1,1), (1,2), (0,2), (0,3), (0,4), (1,4), (2,4), (3,4), (4,4)]");
    }

    @Test
    void testGetShortestPathFromStartToFinish() {
    }

    @Test
    void testGetAllPathsFromStartToFinish() {
    }

}