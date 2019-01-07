package com.leonenko.epi._18_graph;

import com.leonenko.epi._18_graph.Point.PointType;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _181_SearchMaze {

    static List<Point> findAnyPath(PointType[][] maze, Point startPoint, Point goalPoint) {
        var pathPoints = new LinkedList<Point>();
        var visitedPoints = new HashSet<Point>();

        if (findAnyPath(maze, startPoint, goalPoint, pathPoints, visitedPoints)) {
            return new ArrayList<>(pathPoints);
        } else {
            return List.of();
        }
    }

    private static boolean findAnyPath(PointType[][] maze, Point currPoint, Point goalPoint,
            Deque<Point> pathPoints, Set<Point> visitedPoints) {

        pathPoints.addLast(currPoint);

        if (goalPoint.equals(currPoint)) {
            return true;
        }

        var isPathFound = false;

        if (visitedPoints.add(currPoint)) {
            isPathFound = getNeighborPoints(currPoint, maze, visitedPoints)
                    .stream()
                    .filter(p -> !visitedPoints.contains(p))
                    .dropWhile(p -> !findAnyPath(maze, p, goalPoint, pathPoints, visitedPoints))
                    .findFirst()
                    .isPresent();
        }

        if (isPathFound) {
            return true;
        } else {
            pathPoints.removeLast();
            return false;
        }
    }

    private static List<Point> getNeighborPoints(Point currPoint,
            PointType[][] matrix, Set<Point> visitedPoints) {

        var row = currPoint.row();
        var col = currPoint.col();

        var neighborPoints = Stream.of(new Point(row, col + 1),
                new Point(row, col - 1),
                new Point(row - 1, col),
                new Point(row + 1, col));

        return neighborPoints
                .filter(point -> isLegalPoint(point, matrix, visitedPoints))
                .collect(Collectors.toList());
    }

    private static boolean isLegalPoint(Point point, PointType[][] matrix,
            Set<Point> visitedPoints) {

        if (visitedPoints.contains(point)) {
            return false;
        }

        if (point.row() < 0 || point.row() >= matrix.length
                || point.col() < 0 || point.col() >= matrix[point.row()].length) {
            return false;
        }

        return matrix[point.row()][point.col()] != PointType.WALL;
    }
}
