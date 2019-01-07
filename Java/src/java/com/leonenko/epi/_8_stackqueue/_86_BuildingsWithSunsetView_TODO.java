package com.leonenko.epi._8_stackqueue;

import lombok.AllArgsConstructor;

import java.util.LinkedList;
import java.util.List;

public class _86_BuildingsWithSunsetView_TODO {

    static List<Building> getSunsetViewBuildings(List<Integer> heights) {
        int index = 0;

        var sunsetViewBuildings = new LinkedList<Building>();

        for (var height : heights) {
            while (!sunsetViewBuildings.isEmpty()
                    && height >= sunsetViewBuildings.peek().height) {
                sunsetViewBuildings.pop();
            }

            sunsetViewBuildings.push(new Building(index++, height));
        }

        return sunsetViewBuildings;
    }

    @AllArgsConstructor
    private static final class Building {
        private int index;
        private int height;
    }
}
