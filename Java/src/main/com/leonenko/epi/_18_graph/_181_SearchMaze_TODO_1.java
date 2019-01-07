package com.leonenko.epi._18_graph;

import java.util.*;

import static java.util.Arrays.setAll;

/**
 * Created by Alex on 5/12/2017.
 */
public class _181_SearchMaze_TODO_1 {

    static final int START = 0;
    static final int OPEN = 1;
    static final int BLOCK = 2;
    static final int FINISH = 3;

    static void printShortestPath(int[][] m, Point start, Point finish) {
        Queue<Point> unvisited = new LinkedList<>(List.of(start));

        Point[][] paths = new Point[m.length][];
        setAll(paths, i -> new Point[m[i].length]);
        paths[start.row()][start.col()] = start;

        while (!unvisited.isEmpty()) {
            var p = unvisited.poll();

            if (p.equals(finish)) {
                break;
            }

            for (int[] direction : Util.DIRECTIONS) {
                var adjRow = p.row() + direction[0];
                var adjCol = p.col() + direction[1];

                if (Util.isValidPoint(m, adjRow, adjCol)
                        && isUnvisited(paths[adjRow][adjCol])
                        && isOpenOrFinish(m[adjRow][adjCol])) {
                    paths[adjRow][adjCol] = p;

                    unvisited.add(new Point(adjRow, adjCol));
                }
            }
        }

        var path = new LinkedList<Point>();
        var curr = finish;

        while (curr != start) {
            path.push(curr);
            curr = paths[curr.row()][curr.col()];
        }

        path.push(start);
        System.out.println(path);

    }

    private static boolean isUnvisited(Point point) {
        return point == null;
    }

    private static boolean isOpenOrFinish(int i) {
        return i == OPEN || i == FINISH;
    }

    private static void printAllPaths(int[][] m, Point start, Point finish) {
        List<List<Point>> allPaths = new ArrayList<>();
        findPaths(m, start, finish, new LinkedList<>(), allPaths);
        allPaths.forEach(System.out::println);
    }

    private static void printPath(int[][] m, Point start, Point finish) {
        Deque<Point> path = new LinkedList<>();
        findPaths(m, start, finish, path, null);
        System.out.println(path);
    }

    private static boolean findPaths(
            int[][] m, Point point, Point finish, Deque<Point> path, List<List<Point>> allPaths) {
        path.addLast(point);

        if (point.equals(finish)) {
            if (allPaths != null) {
                allPaths.add(List.copyOf(path));
            }
            return true;
        }

        var oldValue = m[point.row()][point.col()];

        m[point.row()][point.col()] = BLOCK;

        for (int[] direction : Util.DIRECTIONS) {
            var adjRow = point.row() + direction[0];
            var adjCol = point.col() + direction[1];

            if (Util.isValidPoint(m, adjRow, adjCol) && isOpenOrFinish(m[adjRow][adjCol])) {
                if (findPaths(m, new Point(adjRow, adjCol), finish, path, allPaths)) {
                    m[point.row()][point.col()] = oldValue;

                    if (allPaths == null) {
                        return true;
                    }
                }
            }
        }

        m[point.row()][point.col()] = oldValue;
        path.pollLast();

        return false;
    }

}
