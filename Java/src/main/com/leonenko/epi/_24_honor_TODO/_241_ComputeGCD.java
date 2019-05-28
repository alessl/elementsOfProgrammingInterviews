package com.leonenko.epi._24_honor_TODO;

/**
 * Created by Alex on 5/11/2017.
 *
 * p. 425
 */
public class _241_ComputeGCD {

    static int getGCD(int num1, int num2) {
        if (num1 == num2 || num1 == 0) {
            return num1;
        }
        if (num2 == 0) {
            return num2;
        }
        // both numbers are even
        if (isEven(num1) && isEven(num2)) {
            return getGCD(num1 >>> 1, num2 >>> 1) << 1;
        }
        // num1 is even
        if (isEven(num1) && isOdd(num2)) {
            return getGCD(num1 >>> 1, num2);
        }
        // num2 is even
        if (isOdd(num1) && isEven(num2)) {
            return getGCD(num1, num2 >>> 1);
        }
        // both numbers are odd
        if (num1 > num2) {
            return getGCD(num1 - num2, num2);
        }
        return getGCD(num1, num2 - num1);
    }

    private static boolean isOdd(int number) {
        return (number & 1) != 0;
    }

    private static boolean isEven(int number) {
        return (number & 1) == 0;
    }
}
