package com.leonenko.epi._16_dp_TODO;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.leonenko.epi._16_dp_TODO._167_BedBathAndBeyond.getWords;
import static org.junit.jupiter.api.Assertions.*;

class _167_BedBathAndBeyondTest {

    @Test
    void testGetWords() {
        var dict = Set.of("google", "amazon", "facebook", "job");
        Assertions.assertThat(getWords("googlefacebookamazonjob", dict))
                  .containsExactlyInAnyOrderElementsOf(dict);
    }
}