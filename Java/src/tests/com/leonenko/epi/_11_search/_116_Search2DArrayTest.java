package com.leonenko.epi._11_search;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._11_search._116_Search2DArray.findEntry;
import static org.assertj.core.api.Assertions.assertThat;

class _116_Search2DArrayTest {

    @Test
    void testFindEntry() {
        var matrix = List.of(
                List.of(-1, 2,  3,  4,  6),
                List.of(0,  5,  5,  7,  21),
                List.of(1,  6,  8,  9,  22),
                List.of(3,  10, 11, 12, 25),
                List.of(28, 29, 30, 31, 45));

        assertFindEntry(matrix, 12, 3, 3);
        assertFindEntry(matrix, 0, 1, 0);
    }

    private void assertFindEntry(List<List<Integer>> matrix, int targetKey, int expectedRow,
            int expectedCol) {

        var entry = findEntry(matrix, targetKey);

        assertThat(entry).isNotNull();
        assertThat(entry.getRow()).isEqualTo(expectedRow);
        assertThat(entry.getCol()).isEqualTo(expectedCol);
    }

}