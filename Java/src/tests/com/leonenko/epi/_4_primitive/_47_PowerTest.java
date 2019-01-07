package com.leonenko.epi._4_primitive;

import org.junit.jupiter.api.Test;

import java.util.Random;

class _47_PowerTest {

    @Test
    void pow() {
    }

    public static void main(String[] args) {
        Random random = new Random();
        int base = random.nextInt(100 + 1);
        int exp = -5 + random.nextInt(10 + 1);
//        System.out.printf("%s^%s=%.5f=%.5f", base, exp, Math.pow(base, exp), pow(base, exp));
    }
}