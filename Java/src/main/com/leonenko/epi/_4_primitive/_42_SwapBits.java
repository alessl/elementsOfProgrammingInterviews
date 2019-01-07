package com.leonenko.epi._4_primitive;

/**
 * Created by Alex on 5/5/2017.
 */
public class _42_SwapBits {

    static int swapBits(int number, int b1, int b2) {
        var numberAfterSwap = number;

        if ((number & (1 << b1)) != (number & (1 << b2))) {
           numberAfterSwap ^= (1 << b1) | (1 << b2);
        }

        return numberAfterSwap;
    }
}
