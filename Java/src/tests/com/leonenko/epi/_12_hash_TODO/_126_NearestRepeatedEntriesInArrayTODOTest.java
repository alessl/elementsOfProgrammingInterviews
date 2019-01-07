package com.leonenko.epi._12_hash_TODO;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._12_hash_TODO._126_NearestRepeatedEntriesInArray_TODO.findNearestRepeatedEntries;
import static org.assertj.core.api.Assertions.assertThat;

class _126_NearestRepeatedEntriesInArrayTODOTest {

    @Test
    void test1() {
        var entries = List.of('a', 'b', 'c', 'a', 'c');
        var repeatedEntries = findNearestRepeatedEntries(entries);
        assertThat(repeatedEntries).containsExactly(2, 4);
    }

    @Test
    void test2() {
        var entries = List.of('a', 'b', 'c', 'a', 'a');
        var repeatedEntries = findNearestRepeatedEntries(entries);
        assertThat(repeatedEntries).containsExactly(3, 4);
    }

    @Test
    void test3() {
        var entries = List.of('a', 'a', 'a');
        var repeatedEntries = findNearestRepeatedEntries(entries);
        assertThat(repeatedEntries).containsExactly(0, 1);
    }
}