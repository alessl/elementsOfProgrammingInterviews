package com.leonenko.epi._5_array;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._5_array._515_ComputeRandomSubSet.generateRandomSubSet;

class _515_ComputeRandomSubSetTest {

    @Test
    void testGenerateRandomSubSet() {
        for (int i = 0; i < 20_000; i++) {
            List<Integer> randomSubSet = generateRandomSubSet(100, 10);

        }

//        System.out.println(randomSubSet);
//
//        assertThat(randomSubSet).hasSize(10);
//
//        var maxOpt = randomSubSet.stream()
//                                 .max(naturalOrder());
//
//        assertThat(maxOpt).isNotEmpty();
//        assertThat(maxOpt).hasValueSatisfying(
//                value -> {
//                    assertThat(value).isLessThanOrEqualTo(100);
//                    assertThat(value).isGreaterThan(10);
//                });
//
//        var minOpt = randomSubSet.stream()
//                                 .min(naturalOrder());
//
//        assertThat(minOpt).isNotEmpty();
//        assertThat(minOpt).hasValueSatisfying(
//                value -> assertThat(value).isGreaterThanOrEqualTo(0));
    }
}