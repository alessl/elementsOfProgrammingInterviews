package com.leonenko.epi._5_array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.leonenko.epi._5_array._518_SpiralOrderOf2DArray.getSpiralOrder1;
import static com.leonenko.epi._5_array._518_SpiralOrderOf2DArray.getSpiralOrder2;
import static org.assertj.core.api.Assertions.assertThat;

class _518_SpiralOrderOf2DArrayTest {

    private List<List<Integer>> oddMatrix;
    private List<List<Integer>> evenMatrix;
    private List<Integer> expectedSpiralOrderOfOddMatrix;
    private List<Integer> expectedSpiralOrderOfEvenMatrix;

    @BeforeEach
    void setUp() {
        oddMatrix = mutableOf(List.of(
                List.of(1, 2, 3),
                List.of(8, 9, 4),
                List.of(7, 6, 5)));
        evenMatrix = mutableOf(List.of(
                List.of(1,  2,  3, 4),
                List.of(12, 13, 14, 5),
                List.of(11, 16, 15, 6),
                List.of(10, 9,  8, 7)));

        expectedSpiralOrderOfOddMatrix = sortedElementsOf(oddMatrix);
        expectedSpiralOrderOfEvenMatrix = sortedElementsOf(evenMatrix);
    }

    private List<List<Integer>> mutableOf(List<List<Integer>> oddMatrix) {
        return oddMatrix.stream()
                .map(ArrayList::new)
                .collect(Collectors.toList());
    }

    static List<Integer> sortedElementsOf(List<List<Integer>> oddMatrix) {
        return oddMatrix.stream()
                        .flatMap(List::stream)
                        .sorted()
                        .collect(Collectors.toList());
    }

    @Test
    void testSpiralOrder1() {
        assertThat(getSpiralOrder1(oddMatrix))
                .containsExactlyElementsOf(expectedSpiralOrderOfOddMatrix);
        assertThat(getSpiralOrder1(evenMatrix))
                .containsExactlyElementsOf(expectedSpiralOrderOfEvenMatrix);
    }

    @Test
    void testSpiralOrder2() {
        assertThat(getSpiralOrder2(oddMatrix))
                .containsExactlyElementsOf(expectedSpiralOrderOfOddMatrix);
        assertThat(getSpiralOrder2(evenMatrix))
                .containsExactlyElementsOf(expectedSpiralOrderOfEvenMatrix);
    }
}