package com.leonenko.epi._4_primitive;

import java.util.Random;

public class _410_UniformRandomNumbers {

    private static final Random RANDOM = new Random();

    static int generate(int lowerBound, int upperBound) {
        var numOutcomes = upperBound - lowerBound + 1;
        var generatedNum = 0;

        do {
            for (int i = 0; (1 << i) < numOutcomes; i++) {
                generatedNum = (generatedNum << 1) | zeroOrOne();
            }
        } while (generatedNum >= numOutcomes);

        return generatedNum + lowerBound;
    }

    private static int zeroOrOne() {
        return RANDOM.nextInt(1 + 1);
    }
}
