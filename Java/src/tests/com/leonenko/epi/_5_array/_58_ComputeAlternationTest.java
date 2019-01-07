package com.leonenko.epi._5_array;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.leonenko.epi._5_array._58_ComputeAlternation.alternateList;
import static org.assertj.core.api.Assertions.assertThat;

class _58_ComputeAlternationTest {

    @Test
    void testAlternateArray() {
        var array = IntStream.range(0, 11)
                             .toArray();
        var expectedArray = new int[] {1, 0, 3, 2, 5, 4, 7, 6, 9, 8, 10};

        assertAlternatedArray(array, expectedArray);
    }

    @Test
    void testAlternateArrayOddSize() {
        var array = IntStream.range(0, 11)
                             .toArray();
        var expectedArray = new int[] {1, 0, 3, 2, 5, 4, 7, 6, 9, 8, 10};

        assertAlternatedArray(array, expectedArray);
    }

    private void assertAlternatedArray(int[] array, int[] expectedArray) {
        _58_ComputeAlternation.alternateArray(array);

        assertThat(array).containsExactly(expectedArray);
    }

    @Test
    void testAlternateList() {
        var list = IntStream.range(0, 11)
                            .boxed()
                            .collect(Collectors.toList());
        var expectedList = List.of(1, 0, 3, 2, 5, 4, 7, 6, 9, 8, 10);

        assertAlternateList(list, expectedList);
    }

    @Test
    void testAlternateListOddSize() {
        var list = IntStream.range(0, 10)
                            .boxed()
                            .collect(Collectors.toList());
        var expectedList = List.of(1, 0, 3, 2, 5, 4, 7, 6, 9, 8);

        assertAlternateList(list, expectedList);
    }

    private void assertAlternateList(List<Integer> list, List<Integer> expectedList) {
        alternateList(list);

        assertThat(list).containsExactlyElementsOf(expectedList);
    }
}