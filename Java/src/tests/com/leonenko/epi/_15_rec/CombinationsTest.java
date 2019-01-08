package com.leonenko.epi._15_rec;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._15_rec._155_GenerateAllSubSetsOfSizeK.enumerateAllCombinationsOfSize;
import static org.assertj.core.api.Assertions.assertThat;

class CombinationsTest {

    @Test
    void testPrintAllCombinations() {

        assertThat(enumerateAllCombinationsOfSize("abc", 2))
                .containsExactlyInAnyOrder(List.of('a'),
                        List.of('b'),
                        List.of('c'),
                        List.of('a', 'b'),
                        List.of('a', 'c'),
                        List.of('b', 'c'),
                        List.of('a', 'b', 'c'));
    }
}