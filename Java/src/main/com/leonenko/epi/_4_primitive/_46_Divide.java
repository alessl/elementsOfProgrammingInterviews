package com.leonenko.epi._4_primitive;

/**
 * Created by Alex on 5/5/2017.
 */
public class _46_Divide {

    static int divide(int dividend, int divisor) {
        var result = 0;
        var power = (int) Math.sqrt((Math.log10(Integer.highestOneBit(dividend)) / Math.log10(2)));
        var divisorPower = divisor << power;

        while (dividend >= divisor) {
            while (divisorPower > dividend) {
                divisorPower >>>= 1;
                power--;
            }

            result += 1 << power;
            dividend -= divisorPower;
        }

        return result;
    }
}
