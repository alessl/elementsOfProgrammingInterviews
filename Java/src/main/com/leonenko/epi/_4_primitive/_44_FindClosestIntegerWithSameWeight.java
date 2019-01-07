package com.leonenko.epi._4_primitive;

/**
 * Created by Alex on 6/21/2017.
 */
public class _44_FindClosestIntegerWithSameWeight {

    static int getNearest(int num) {
        // if num starts with 1, then mask is first 0 bit
        // if num starts with 0, then mask is first 1 bit
        var mask = (num & 1) != 0 ? (~num & num + 1) : (num & -num);
        mask = mask | mask >> 1;
        num ^= mask;
        return num;
    }
}
