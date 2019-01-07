package com.leonenko.myinterview.google;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by Alex on 6/5/2017.
 */
public class TopNSortedMatrix {

    public static void main(String[] args) {
        List<List<Integer>> matrix = createMatrix();
        printTop(matrix, 10);
        printTop(matrix, 5);
    }

    private static List<List<Integer>> createMatrix() {
        List<List<Integer>> matrix = new ArrayList<>();
        Random random = new Random();
        int matrixSize = 10;
        int min = 0;
        for (int i = 0; i < matrixSize; i++) {
            List<Integer> row =
                    random.ints(matrixSize, min, min + 10)
                            .boxed()
                            .sorted()
                            .collect(Collectors.toList());
            matrix.add(row);
            min = row.get(2);
            for (int j : row) {
                System.out.printf("%3s", j);
            }
            System.out.println();
        }
        return matrix;
    }

    private static void printTop(List<List<Integer>> matrix, int topSize) {
        List<Integer> top = new ArrayList<>();
        PriorityQueue<MatrixElement> maxHeap = new PriorityQueue<>();
        for (int col = 0; col < matrix.get(matrix.size() - 1).size(); col++) {
            maxHeap.add(new MatrixElement(matrix.size() - 1, col, matrix));
        }
        while (!maxHeap.isEmpty() && top.size() < topSize) {
            MatrixElement e = maxHeap.poll();
            top.add(e.getValue());
            MatrixElement next = e.getNext();
            if (next != null) {
                maxHeap.add(next);
            }
        }
        System.out.printf("Top %s: %s%n", topSize, top);
    }

    private static final class MatrixElement implements Comparable<MatrixElement> {
        private final int row;
        private final int col;
        private final List<List<Integer>> matrix;

        private MatrixElement(int row, int col, List<List<Integer>> matrix) {
            this.row = row;
            this.col = col;
            this.matrix = matrix;
        }

        private MatrixElement getNext() {
            if (row == 0) {
                return null;
            }
            return new MatrixElement(row - 1, col, matrix);
        }

        private Integer getValue() {
            return matrix.get(row).get(col);
        }

        @Override
        public int compareTo(MatrixElement o) {
            return Integer.compare(o.getValue(), this.getValue());
        }
    }
}
