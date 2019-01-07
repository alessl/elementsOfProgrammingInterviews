package com.leonenko.epi._4_primitive;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.leonenko.epi._4_primitive._410_UniformRandomNumbers.generate;
import static org.assertj.core.api.Assertions.assertThat;

class _410_UniformRandomNumbersTest {

    @Test
    void testGenerate() {
        var random = new Random();
        var lowerBound = random.nextInt(101);
        var upperBound = lowerBound + random.nextInt(101);

        var generated = generate(lowerBound, upperBound);

        assertThat(generated).isBetween(lowerBound, upperBound);
    }
}