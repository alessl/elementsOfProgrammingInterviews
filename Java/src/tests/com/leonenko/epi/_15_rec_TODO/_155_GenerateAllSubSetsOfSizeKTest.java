package com.leonenko.epi._15_rec_TODO;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._15_rec_TODO._155_GenerateAllSubSetsOfSizeK.enumerateAllCombinationsOfSize;
import static org.assertj.core.api.Assertions.assertThat;

class _155_GenerateAllSubSetsOfSizeKTest {

    @Test
    void testEnumerateAllCombinations() {
        assertThat(enumerateAllCombinationsOfSize("abc", 2))
                .containsExactly(List.of('a', 'b'), List.of('a', 'c'), List.of('b', 'c'));
    }

    @Test
    void testEnumerateAllCombinations2() {
        assertThat(enumerateAllCombinationsOfSize(3, 2))
                .containsExactly(List.of(1, 2), List.of(1, 3), List.of(2, 3));
    }

}