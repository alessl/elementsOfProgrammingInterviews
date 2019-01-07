package com.leonenko.epi._5_array;

import java.util.Collections;
import java.util.List;

public class _51_DutchNationalFlag {

    enum Color {
        RED, WHITE, BLUE
    }

    static void partition1(int pivotIndex, List<Color> colors) {
        var pivot = colors.get(pivotIndex);

        for (int i = 0; i < colors.size() - 1; i++) {
            for (int j = i + 1; j < colors.size(); j++) {
                if (colors.get(j).compareTo(pivot) < 0) {
                    Collections.swap(colors, i, j);
                    break;
                }
            }
        }

        for (int i = colors.size() - 1; i >= 0 && colors.get(i).compareTo(pivot) >= 0; i--) {
            for (int j = i - 1; j >= 0 && colors.get(j).compareTo(pivot) >= 0; j--) {
                if (colors.get(j).compareTo(pivot) > 0) {
                    Collections.swap(colors, i, j);
                    break;
                }
            }
        }
    }

    static void partition2(int pivotIndex, List<Color> colors) {
        var pivot = colors.get(pivotIndex);

        var smallerIndex = 0;

        for (var i = 0; i < colors.size(); i++) {
            if (colors.get(i).compareTo(pivot) < 0) {
                Collections.swap(colors, smallerIndex++, i);
            }
        }

        var largerIndex = colors.size() - 1;

        for (var i = colors.size() - 1; i >= 0 && colors.get(i).compareTo(pivot) >= 0; i--) {
            if (colors.get(i).compareTo(pivot) > 0) {
                Collections.swap(colors, largerIndex--, i);
            }
        }
    }
}
