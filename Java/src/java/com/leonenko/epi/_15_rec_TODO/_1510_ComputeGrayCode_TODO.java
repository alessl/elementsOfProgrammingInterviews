package com.leonenko.epi._15_rec_TODO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Alex on 5/4/2017.
 */
public class _1510_ComputeGrayCode_TODO {

    public static void main(String[] args) {
        printGrayCodes(5);
    }

    private static void printGrayCodes(int numBits) {
        List<Integer> grayCodes = getGrayCodes(numBits);
        String format = String.format("%%%ss", numBits);
        grayCodes
                .stream()
                .map(Integer::toBinaryString)
                .map(n -> String.format(format, n))
                .map(s -> s.replace(" ", "0"))
                .forEach(System.out::println);
    }

    private static List<Integer> getGrayCodes(int numBits) {
        if (numBits == 0) {
            return new ArrayList<>(Collections.singleton(0));
        }
        List<Integer> grayCodes = getGrayCodes(numBits - 1);
        for (int i = grayCodes.size() - 1; i >= 0; i--) {
            grayCodes.add(grayCodes.get(i) | 1 << (numBits - 1));
        }
        return grayCodes;
    }
}
