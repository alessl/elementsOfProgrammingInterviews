package com.leonenko.epi._12_hash_TODO;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._12_hash_TODO._126_NearestRepeatedEntriesInArray.findNearestRepeatedEntries;
import static org.assertj.core.api.Assertions.assertThat;

class _126_NearestRepeatedEntriesInArrayTest {

    @Test
    void testFindNearestRepeatedEntries() {
        assertThat(findNearestRepeatedEntries(List.of('a', 'b', 'c', 'a', 'c', 'b'))).contains(2, 4);
        assertThat(findNearestRepeatedEntries(List.of('a', 'b', 'c', 'a', 'a'))).contains(3, 4);
        assertThat(findNearestRepeatedEntries(List.of('a', 'b', 'c', 'd', 'a'))).contains(0, 4);
        assertThat(findNearestRepeatedEntries(List.of('a', 'a', 'c', 'd', 'a'))).contains(0, 1);
        assertThat(findNearestRepeatedEntries(List.of('a', 'b', 'c', 'd'))).isEmpty();
    }
}