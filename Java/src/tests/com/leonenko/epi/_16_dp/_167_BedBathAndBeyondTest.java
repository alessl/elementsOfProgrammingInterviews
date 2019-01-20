package com.leonenko.epi._16_dp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static com.leonenko.epi._16_dp._167_BedBathAndBeyond.getWords;

class _167_BedBathAndBeyondTest {

    @Test
    void testGetWords() {
        var dict = Set.of("google", "amazon", "facebook", "job");
        Assertions.assertThat(getWords("googlefacebookamazonjob", dict))
                  .containsExactlyInAnyOrderElementsOf(dict);
    }
}