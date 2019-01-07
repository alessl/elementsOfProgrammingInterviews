package com.leonenko.epi._17_greedy_TODO;

import java.util.LinkedList;

/**
 * Created by Alex on 5/8/2017.
 */
public class _176_GasUp_TODO {

    private static final int MPG = 20;

    public static void main(String[] args) {
        int[] milesToNext = {900, 600, 200, 400, 600, 200, 100};
        int[] gasVol = {50, 20, 5, 30, 25, 10, 10};
        char[] cities = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        findStart(milesToNext, gasVol, cities);
    }

    private static void findStart(int[] distanceToNext, int[] availableGas, char[] cities) {
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
    }
}
