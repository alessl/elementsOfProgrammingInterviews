package com.leonenko.epi._5_array;

import java.util.List;

/**
 * Created by Alex on 5/12/2017.
 */
public class _54_AdvancingThroughArray {

    static boolean isEndReachable(List<Integer> steps) {
        var endIdx = steps.size() - 1;
        var reachedIdx = 0;

        for (var stepIdx = 0; stepIdx <= reachedIdx && reachedIdx < endIdx; stepIdx++) {
            reachedIdx = Math.max(reachedIdx, stepIdx + steps.get(stepIdx));
        }

        return reachedIdx >= endIdx;
    }
}
