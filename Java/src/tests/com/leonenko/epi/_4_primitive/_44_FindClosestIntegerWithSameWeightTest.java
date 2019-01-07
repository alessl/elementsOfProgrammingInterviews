package com.leonenko.epi._4_primitive;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._4_primitive._44_FindClosestIntegerWithSameWeight.getNearest;

class _44_FindClosestIntegerWithSameWeightTest {

    @Test
    void testGetNearest() {

    }

    public static void main(String[] args) {
        print(37);
        print(92);
        print(105);
    }

    private static void print(int num) {
        int nearest = getNearest(num);
//        System.out.printf("%s(%s) => %s(%s)%n", num, bin(num), nearest, bin(nearest));
    }
}