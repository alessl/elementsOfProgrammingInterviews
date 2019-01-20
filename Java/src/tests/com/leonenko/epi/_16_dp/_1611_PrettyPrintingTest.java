package com.leonenko.epi._16_dp;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._16_dp._1611_PrettyPrinting.getMinMessiness;
import static java.util.stream.Collectors.joining;
import static org.assertj.core.api.Assertions.assertThat;

class _1611_PrettyPrintingTest {

    @Test
    void testGetMinMessiness() {
        List<String> words = List.of(
                ("I have inserted a large number of"
                        + "new examples from the papers for the"
                        + "Mathematical Tripos during the last"
                        + "twenty years, which should be useful"
                        + "to Cambridge students").split("\\s+"));
        assertThat(getMinMessiness(words, 36)).isEqualTo(121);
    }
}