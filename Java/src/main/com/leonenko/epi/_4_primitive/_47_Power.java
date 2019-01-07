package com.leonenko.epi._4_primitive;

/**
 * Created by Alex on 5/5/2017.
 */
public class _47_Power {

    static double pow(double base, int exp) {
        var result = 1.0;
        var power = (long) exp;

        if (exp < 0) {
            power = -power;
            base = 1 / base;
        }

        while (power != 0) {
            if ((power & 1) != 0) {
                result *= base;
            }
            base *= base;
            power >>>= 1;
        }

        return result;
    }
}
