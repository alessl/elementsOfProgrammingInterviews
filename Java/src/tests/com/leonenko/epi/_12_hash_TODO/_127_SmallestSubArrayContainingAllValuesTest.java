package com.leonenko.epi._12_hash_TODO;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static com.leonenko.epi._12_hash_TODO._127_SmallestSubArrayContainingAllValues.*;
import static org.assertj.core.api.Assertions.assertThat;

class _127_SmallestSubArrayContainingAllValuesTest {

    private static final Set<String> WORDS = Set.of("banana", "cat");

    @Test
    void testGetSubArray1() {
        assertSubArray(
                List.of("apple", "banana", "banana", "dog", "cat"),
                WORDS,
                new String[]{"banana", "dog", "cat"});
    }

    @Test
    void testGetSubArray2() {
        assertSubArray(
                List.of("banana", "apple", "dog", "cat", "banana"),
                WORDS,
                new String[]{"cat", "banana"});
    }

    @Test
    void testGetSubArray3() {
        assertSubArray(
                List.of("banana", "apple", "dog", "dog", "cat", "banana", "banana"),
                WORDS,
                new String[]{"cat", "banana"});
    }

    @Test
    void testGetSubArray4() {
        assertSubArray(
                List.of("banana", "apple", "dog", "dog", "cat", "cat", "dog", "banana"),
                WORDS,
                new String[]{ "cat", "dog", "banana"});
    }

    private void assertSubArray(List<String> text, Set<String> words, String[] expectedSubText) {
        assertThat(getSubArray1(text, words)).containsExactly(expectedSubText);
        assertThat(getSubArray2(text, words)).containsExactly(expectedSubText);
    }

    @Test
    void testGetSmallestSubArray() {
        var smallestSubArray = getSmallestSubArray(List.of("a", "b", "a", "c", "b", "b", "a", "c", "c"));
        assertThat(smallestSubArray).containsExactly("b", "a", "c");
    }
}
