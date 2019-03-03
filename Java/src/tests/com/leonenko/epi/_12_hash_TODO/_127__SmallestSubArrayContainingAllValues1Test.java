package com.leonenko.epi._12_hash_TODO;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._12_hash_TODO._127_SmallestSubArrayContainingAllValues1.getSmallestSubArray;
import static org.assertj.core.api.Assertions.assertThat;

public class _127__SmallestSubArrayContainingAllValues1Test {

    @Test
    void test() {
        List<String> smallestSubArray = getSmallestSubArray(List.of("a", "b", "a", "c", "b", "b", "a", "c", "c"));
        assertThat(smallestSubArray).containsExactly("b", "a", "c");
    }
}
