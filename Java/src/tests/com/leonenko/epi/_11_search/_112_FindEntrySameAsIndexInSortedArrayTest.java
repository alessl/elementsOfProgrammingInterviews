package com.leonenko.epi._11_search;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._11_search._112_FindEntrySameAsIndexInSortedArray.findEntryEqualToIndex;
import static org.assertj.core.api.Assertions.assertThat;

class _112_FindEntrySameAsIndexInSortedArrayTest {

    @Test
    void test() {
        var numbers = List.of(1, 1);
        int foundIndex = findEntryEqualToIndex(numbers);
        assertThat(foundIndex).isEqualTo(1);
    }

    @Test
    void test2() {
        var numbers = List.of(1, 2, 2);
        int foundIndex = findEntryEqualToIndex(numbers);
        assertThat(foundIndex).isEqualTo(2);
    }

    @Test
    void test3() {
        var numbers = List.of(1, 2, 3, 4, 5, 5);
        int foundIndex = findEntryEqualToIndex(numbers);
        assertThat(foundIndex).isEqualTo(5);
    }

    @Test
    void test4() {
        var numbers = List.of(1, 2, 3, 4, 5, 10, 11);
        int foundIndex = findEntryEqualToIndex(numbers);
        assertThat(foundIndex).isEqualTo(-1);
    }
}