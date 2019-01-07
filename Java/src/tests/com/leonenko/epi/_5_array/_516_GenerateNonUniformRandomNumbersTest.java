package com.leonenko.epi._5_array;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._5_array._516_GenerateNonUniformRandomNumbers.generateNonUniformRandomNumber;
import static org.assertj.core.api.Assertions.assertThat;

class _516_GenerateNonUniformRandomNumbersTest {

    @Test
    void test() {
        var numbers = List.of(3, 5, 7, 11);
        var probabilities = List.of(9 / 18.0, 6 / 18.0, 2 / 18.0, 1 / 18.0);

        var randomNumber = generateNonUniformRandomNumber(numbers, probabilities);

        System.out.println(numbers + ", generated: " + randomNumber);

        assertThat(randomNumber).isIn(numbers);
    }
}