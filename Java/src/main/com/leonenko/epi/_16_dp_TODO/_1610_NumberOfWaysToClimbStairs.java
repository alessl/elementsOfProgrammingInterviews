package com.leonenko.epi._16_dp_TODO;

/**
 * Created by Alex on 5/7/2017.
 */
public class _1610_NumberOfWaysToClimbStairs {

    static int getNumWaysToClimbStairs(int numStairs, int maxStep) {
        return getNumWaysToClimbStairs(numStairs, maxStep, new int[numStairs + 1]);
    }

    private static int getNumWaysToClimbStairs(int numStairs, int maxStep, int[] numWays) {
        if (numStairs <= 1) {
            return 1;
        }

        if (numWays[numStairs] == 0) {
            for (var step = 1; step <= maxStep && numStairs - maxStep >= 0; step++) {
                numWays[numStairs] += getNumWaysToClimbStairs(
                        numStairs - step, maxStep, numWays);
            }
        }

        return numWays[numStairs];
    }
}
