package com.leonenko.epi._4_primitive;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.leonenko.epi._4_primitive._45_MultiplyWithoutArithmeticOperations.multiply;

class _45_MultiplyWithoutArithmeticOperationsTest {

    @Test
    void testMultiply() {
    }


    public static void main(String[] args) {
        Random random = new Random();
        int n1 = random.nextInt(50 + 1);
        int n2 = random.nextInt(50 + 1);
        long p = multiply(n1, n2);
        System.out.printf("%s*%s=%s=%s", n1, n2, p, n1 * n2);
    }
}