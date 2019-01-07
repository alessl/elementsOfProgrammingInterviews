package com.leonenko.epi._4_primitive;

/**
 * Created by Alex on 5/5/2017.
 */
public class _48_ReverseDigits {

    static int reverse(int n) {
        var rev = 0;

        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }

        return rev;
    }
}
