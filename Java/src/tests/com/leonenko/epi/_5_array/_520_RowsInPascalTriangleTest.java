package com.leonenko.epi._5_array;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class _520_RowsInPascalTriangleTest {

    @Test
    void testGeneratePascalTriangle() {
        var pascalTriangle = _520_RowsInPascalTriangle.generatePascalTriangle(5);

        pascalTriangle.stream()
                      .map(List::toString)
                      .forEach(System.out::println);

        assertThat(pascalTriangle).containsExactly(
                    List.of(1),
                   List.of(1, 1),
                  List.of(1, 2, 1),
                 List.of(1, 3, 3, 1),
                List.of(1, 4, 6, 4, 1));
    }
}