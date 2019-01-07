package com.leonenko.epi._11_search;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.leonenko.epi._11_search._119_SearchMissingIpAddress_TODO.findMissingElement;
import static org.assertj.core.api.Assertions.assertThat;

class _119_SearchMissingIpAddress_TODOTest {

    @Test
    void testFindMissingElement() {
        var rand = new Random();
        var start = rand.nextInt(Integer.MAX_VALUE / 2);

        var sequence = IntStream
                .iterate(start, i -> i + 1)
                .limit(5)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(sequence);

        var missingIndex = rand.nextInt(sequence.size());
        var removedElement = sequence.remove(missingIndex);

        System.out.println(sequence + ", removed: " + removedElement);

        assertThat(findMissingElement(sequence)).isEqualTo(removedElement);
    }

}