package com.leonenko.epi._11_search;

import lombok.Value;

import java.util.List;

public class _117_SearchMinMaxSimultaneously {

    static MinMax findMinMax(List<Integer> list) {
        if (list.isEmpty()) {
            return null;
        }

        if (list.size() == 1) {
            return new MinMax(list.get(0), list.get(0));
        }

        MinMax minMax = null;

        for (int i = 0; i + 1< list.size(); i += 2) {
            var min = Math.min(list.get(i), list.get(i + 1));
            var max = Math.max(list.get(i), list.get(i + 1));

            if (minMax != null) {
                min = Math.min(minMax.min, min);
                max = Math.max(minMax.max, max);
            }

            minMax = new MinMax(min, max);
        }

        return minMax;
    }

    @Value
    static final class MinMax {
        private int min;
        private int max;
    }
}
