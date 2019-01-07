package com.leonenko.epi._17_greedy_TODO;

/**
 * Created by Alex on 5/8/2017.
 */
public class _176_GasUp2 {

    private static final int MPG = 20;

    public static void main(String[] args) {
        int[] milesToNext = {900, 600, 200, 400, 600, 200, 100};
        int[] gasVol = {50, 20, 5, 30, 25, 10, 10};
        char[] cities = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        findStart(milesToNext, gasVol, cities);
    }

    private static void findStart(int[] distanceToNext, int[] availableGas, char[] cities) {
        int minRemainingGas = 0;
        int minRemainingGasCity = 0;
        int remainingGas = 0;
        for (int currCity = 1; currCity < cities.length; currCity++) {
            int prevCity = currCity - 1;
            remainingGas += availableGas[prevCity] - distanceToNext[prevCity] / MPG;
            if (remainingGas < minRemainingGas) {
                minRemainingGasCity = currCity;
                minRemainingGas = remainingGas;
            }
        }
        System.out.printf("Start at city '%s'", cities[minRemainingGasCity]);
    }
}
