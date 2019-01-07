package com.leonenko.epi._5_array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class _519_Rotate2DArray {

    static List<List<Integer>> rotateMatrix(List<List<Integer>> matrix) {
        matrix = mutableOf(matrix);

        int matrixSize = matrix.size() - 1;

        for (int i = 0; i < (matrixSize + 1) / 2; i++) {
            for (int j = i; j < matrixSize - i; j++) {
                int temp1 = getVal(matrix, matrixSize - j, i);
                int temp2 = getVal(matrix, matrixSize - i, matrixSize - j);
                int temp3 = getVal(matrix, j, matrixSize - i);
                int temp4 = getVal(matrix, i, j);

                setVal(matrix, i, j, temp1);
                setVal(matrix, matrixSize - j, i, temp2);
                setVal(matrix, matrixSize - i, matrixSize - j, temp3);
                setVal(matrix, j, matrixSize - i, temp4);
            }
        }

        return matrix;
    }

    private static Integer setVal(List<List<Integer>> matrix, int i, int j, int val) {
        return matrix.get(i).set(j, val);
    }

    private static Integer getVal(List<List<Integer>> matrix, int i, int j) {
        return matrix.get(i).get(j);
    }

    private static List<List<Integer>> mutableOf(List<List<Integer>> matrix) {
        return matrix.stream()
                        .map(ArrayList::new)
                        .collect(Collectors.toList());
    }
}
