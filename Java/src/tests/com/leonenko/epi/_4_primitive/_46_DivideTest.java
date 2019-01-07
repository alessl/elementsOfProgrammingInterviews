package com.leonenko.epi._4_primitive;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.leonenko.epi._4_primitive._46_Divide.divide;

class _46_DivideTest {

    @Test
    void testDivide() {
    }

    public static void main(String[] args) {
        Random random = new Random();
        int dividend = random.nextInt(500 + 1);
        int divisor = random.nextInt(dividend + 1);
        System.out.printf(
                "%s/%s=%s=%s", dividend, divisor, dividend / divisor, divide(dividend, divisor));
    }
}