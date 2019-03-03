package com.leonenko.epi._12_hash_TODO;

import java.util.List;
import java.util.Set;

public class _127_SmallestSubArrayContainingAllValues1 {
    public static List<String> getSmallestSubArray(List<String> text) {
        return _127_SmallestSubArrayContainingAllValues.getSubArray1(text, Set.copyOf(text));
    }
}
