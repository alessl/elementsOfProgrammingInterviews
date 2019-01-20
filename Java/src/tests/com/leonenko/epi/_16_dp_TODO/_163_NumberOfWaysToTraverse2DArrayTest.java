package com.leonenko.epi._16_dp_TODO;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.leonenko.epi._16_dp_TODO._163_NumberOfWaysToTraverse2DArray.*;
import static org.assertj.core.api.Assertions.assertThat;

class _163_NumberOfWaysToTraverse2DArrayTest {

    @Test
    void testCountWaysToTraverseMatrix() {
        assertThat(countWaysToTraverseMatrix(5, 5)).isEqualTo(70);
        assertThat(countWaysToTraverseMatrixOptimized(5, 5)).isEqualTo(70);
    }

    @Test
    void testCountWaysToTraverseMatrixWithObstacles() {
        int[][] matrix1 = {
                {0, 1},
                {0, 0},
                {0, 0}};
        assertThat(countWaysToTraverseMatrixWithObstacles(matrix1)).isEqualTo(2);

        int[][] matrix2 = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 0, 0}};
        assertThat(countWaysToTraverseMatrixWithObstacles(matrix2)).isEqualTo(1);

        int[][] matrix3 = {
                {0, 0, 1},
                {0, 1, 0},
                {1, 0, 0}};
        assertThat(countWaysToTraverseMatrixWithObstacles(matrix3)).isEqualTo(0);
    }

    @Test
    void testEnumerateMonotones() {
        var monotoneSize = 5;
        var monotones = enumerateMonotones(monotoneSize, 1, 0, new ArrayList<>());

        assertThat(monotones).hasSize(126);
        assertThat(countMonotones(monotoneSize, 1, 0)).isEqualTo(126);
        assertThat(countStrictMonotonesDP(monotoneSize)).isEqualTo(monotones.size());
        assertThat(countMonotonesDP(monotoneSize)).isEqualTo(1287);
    }

    static List<Integer> enumerateMonotones(int maxNumSize, int startDigit, int monotone, List<Integer> allMonotones) {
        var numSize = (int) Math.log10(monotone) + 1;

        if (maxNumSize == numSize) {
            allMonotones.add(monotone);
            return allMonotones;
        }

        monotone *= 10;

        for (int digit = startDigit; digit <= 9; digit++) {
            monotone += digit;
            enumerateMonotones(maxNumSize, digit + 1, monotone, allMonotones);
            monotone -= digit;
        }

        return allMonotones;
    }

    static int countMonotones(int maxNumSize, int startDigit, int monotone) {
        var numSize = (int) Math.log10(monotone) + 1;

        if (maxNumSize == numSize) {
//            System.out.println(monotone);
            return 1;
        }

        monotone *= 10;

        int monotonesCount = 0;
        for (int digit = startDigit; digit <= 9; digit++) {
            monotone += digit;
            monotonesCount += countMonotones(maxNumSize, digit + 1, monotone);
            monotone -= digit;
        }

        return monotonesCount;
    }
}