package com.leonenko.epi._8_stackqueue;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._8_stackqueue._84_NormalizePathNames.shorten;
import static org.assertj.core.api.Assertions.assertThat;

class _84_NormalizePathNames_Test {

    @Test
    void testShortenSimple() {
        assertThat(shorten("/root/../dir1")).isEqualTo("/root/dir1/");
    }

}