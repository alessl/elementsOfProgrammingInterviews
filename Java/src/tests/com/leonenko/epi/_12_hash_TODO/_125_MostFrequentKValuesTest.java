package com.leonenko.epi._12_hash_TODO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static com.leonenko.epi._12_hash_TODO._125_MostFrequentKValues.getMostFrequentEntriesMinHeap;
import static org.assertj.core.api.Assertions.assertThat;

class _125_MostFrequentKValuesTest {

    private List<String> listOfStrings;

    @BeforeEach
    void setUp() {
        listOfStrings = List.of("17", "16", "6", "1", "3", "7", "7", "7", "14", "17");
    }

    @Test
    void testGetMostFrequentEntries() {
        var actual = getMostFrequentEntriesMinHeap(listOfStrings, 3);

        assertThat(actual).containsExactly("14", "17", "7");
    }
}