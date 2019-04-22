package com.leonenko.epi._6_str;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._6_str._613_FindFirstOccurrenceOfSubStr.findFirstOccurrence;
import static org.assertj.core.api.Assertions.assertThat;

class _613_FindFirstOccurrenceOfSubStrTest {

    @Test
    void testFindOnlyOccurrence() {
        assertThat(findFirstOccurrence("abccabc", "ccab")).isEqualTo(2);
    }

    @Test
    void testFindFirstOccurrence1() {
        assertThat(findFirstOccurrence("ccababccabcbbccabb", "ccab")).isEqualTo(0);
    }

    @Test
    void testFindFirstOccurrence2() {
        assertThat(findFirstOccurrence("aacbbccabb", "ccab")).isEqualTo(5);
    }

    @Test
    void testDoNotFindAnyOccurrence() {
        assertThat(findFirstOccurrence("aacbbccbb", "ccab")).isEqualTo(-1);
    }
}