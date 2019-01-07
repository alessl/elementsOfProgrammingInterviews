package com.leonenko.epi._10_heap;

import com.leonenko.epi._10_heap._104_ClosestKStarsToEarth.Star;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static com.leonenko.epi._10_heap._104_ClosestKStarsToEarth.findClosestKStars;
import static org.assertj.core.api.Assertions.assertThat;

class _104_ClosestKStarsToEarthTest {

    @Test
    void testFindKClosestStars() {
        var k = 3;
        var stars = List.of(new Star(5),
                new Star(2),
                new Star(7),
                new Star(4),
                new Star(9));

        var closestKStars = findClosestKStars(stars, k);

        var expectedClosestKStars = stars.stream()
                                         .sorted()
                                         .limit(k)
                                         .collect(Collectors.toList());
        assertThat(closestKStars).containsExactlyElementsOf(expectedClosestKStars);
    }
}