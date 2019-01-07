package com.leonenko.epi._6_str;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._6_str._64_ReplaceAndRemove.replaceAndRemove;
import static org.assertj.core.api.Assertions.assertThat;

class _64_ReplaceAndRemoveTest {

    @Test
    void testReplaceAndRemove() {
        String transformedStr = replaceAndRemove("acdbbcaaacba");
        assertThat(transformedStr).isEqualTo("ddcdcddddddcdd");
    }
}