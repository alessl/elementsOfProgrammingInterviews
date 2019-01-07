package com.leonenko.myinterview;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

/**
 * Created by Alex on 4/18/2017.
 */
public class SortedMatrixTopK {

    public static void main(String[] args) {
        int[][] matrix = createMatrix();

        System.out.println("Matrix");
        printMatrix(matrix);

        System.out.println("Top");
        System.out.println(getTopN(matrix, matrix.length));
        System.out.println(getTopN(matrix, 10));
        System.out.println(getTopN(matrix, 2));
        System.out.println(getTopN(matrix, matrix.length * matrix.length));
    }

    private static List<Integer> getTopN(int[][] matrix, int topSize) {
        List<Integer> top = new ArrayList<>(topSize);
        PriorityQueue<RowAndColumn> heap = createHeap(matrix);
        while (top.size() < topSize && !heap.isEmpty()) {
            RowAndColumn rowAndCol = heap.poll();
            top.add(matrix[rowAndCol.row][rowAndCol.column]);
            if (rowAndCol.row > 0) {
                heap.add(new RowAndColumn(rowAndCol.row - 1, rowAndCol.column));
            }
        }
        return top;
    }

    private static PriorityQueue<RowAndColumn> createHeap(int[][] matrix) {
        PriorityQueue<RowAndColumn> heap =
                new PriorityQueue<>(createMaxComparator(matrix));
        IntStream.range(0, matrix.length)
                .mapToObj(col -> new RowAndColumn(matrix.length - 1, col))
                .forEach(heap::add);
        return heap;
    }

    private static Comparator<RowAndColumn> createMaxComparator(int[][] matrix) {
        return Comparator.comparing(
                rowAndCol -> matrix[rowAndCol.row][rowAndCol.column],
                Comparator.reverseOrder());
    }

    private static void printMatrix(int[][] matrix) {
        var matrixStr = Arrays.stream(matrix)
                .map(Arrays::toString)
                .collect(joining("\n"));
        System.out.println(matrixStr);
        System.out.println();
    }

    private static final class RowAndColumn {
        private final int row;
        private final int column;

        RowAndColumn(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    private static int[][] createMatrix() {
        return new int[][] {
            {1, 1, 2, 5, 5},
            {2, 2, 2, 6, 7},
            {2, 2, 3, 7, 8},
            {4, 5, 5, 7, 10},
            {7, 7, 8, 8, 12},
        };
    }
}
