package com.leonenko.epi._5_array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.leonenko.epi._5_array._518_SpiralOrderOf2DArray.getSpiralOrder1;
import static com.leonenko.epi._5_array._518_SpiralOrderOf2DArrayTest.sortedElementsOf;
import static com.leonenko.epi._5_array._519_Rotate2DArray.rotateMatrix;
import static org.assertj.core.api.Assertions.assertThat;

class _519_Rotate2DArrayTest {

    private List<List<Integer>> oddMatrix;
    private List<List<Integer>> evenMatrix;

    @BeforeEach
    void setUp() {
        oddMatrix = mutableOf(List.of(
                List.of(3, 4, 5),
                List.of(2, 9, 6),
                List.of(1, 8, 7)
        ));
        evenMatrix = mutableOf(List.of(
                List.of(4,  5,  6, 7),
                List.of(3, 14, 15, 8),
                List.of(2, 13, 16, 9),
                List.of(1, 12, 11, 10)
        ));
    }

    @Test
    void testRotate() {
//        assertRotated(oddMatrix);
        assertRotated(evenMatrix);
    }

    private void assertRotated(List<List<Integer>> matrix) {
        var rotatedMatrix = rotateMatrix(matrix);
        var rotatedSpiralOrder = getSpiralOrder1(rotatedMatrix);
        var rotatedSortedElements = sortedElementsOf(rotatedMatrix);

        assertThat(rotatedSpiralOrder).containsExactlyElementsOf(rotatedSortedElements);
    }

    private List<List<Integer>> mutableOf(List<List<Integer>> oddMatrix) {
        return oddMatrix.stream()
                        .map(ArrayList::new)
                        .collect(Collectors.toList());
    }
}