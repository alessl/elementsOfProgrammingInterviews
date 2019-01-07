package com.leonenko.epi._5_array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class _516_GenerateNonUniformRandomNumbers {

    static int generateNonUniformRandomNumber(List<Integer> values, List<Double> probabilities) {
        var prefixSum = new ArrayList<>(List.of(0.0));

        for (var prob : probabilities) {
            prefixSum.add(prefixSum.get(prefixSum.size() - 1) + prob);
        }

        var uniform = new Random().nextDouble();
        var idx = Collections.binarySearch(prefixSum, uniform);

        return (idx < 0) ? values.get((Math.abs(idx) - 1) - 1) : values.get(idx);
    }
}
