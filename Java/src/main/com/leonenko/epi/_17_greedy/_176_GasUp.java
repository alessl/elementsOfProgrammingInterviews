package com.leonenko.epi._17_greedy;

import java.util.LinkedList;

/**
 * Created by Alex on 5/8/2017.
 */
public class _176_GasUp {

    private static final int MPG = 20;

    static char findStartCity1(int[] distanceToNext, int[] availableGas, char[] cities) {
        var visitedCities = new LinkedList<Integer>();
        var remainingGas = 0;
        var city = 0;

        while (visitedCities.size() < cities.length) {
           while (remainingGas < 0 && !visitedCities.isEmpty()) {
               int visitedCity = visitedCities.poll();
               remainingGas += -availableGas[visitedCity] + distanceToNext[visitedCity] / MPG;
           }

           remainingGas += availableGas[city] - distanceToNext[city] / MPG;
           visitedCities.add(city);
           city = (city + 1) % cities.length;
        }
        System.out.printf("Start at city '%s'", cities[visitedCities.peek()]);

        return cities[visitedCities.peek()];
    }

    static char findStartCity2(int[] distanceToNext, int[] availableGas, char[] cities) {
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

        return cities[minRemainingGasCity];
    }
}
