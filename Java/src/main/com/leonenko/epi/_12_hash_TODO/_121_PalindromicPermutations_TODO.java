package com.leonenko.epi._12_hash_TODO;

import java.util.HashMap;

public class _121_PalindromicPermutations_TODO {

    static boolean isPalindromePossible(String s) {
        var counts = new HashMap<Character, Integer>();

        for (var c : s.toCharArray()) {
            counts.compute(c, (k, v) -> v == null ? 1 : null);
        }

        return counts.isEmpty() || counts.size() == 1;
    }
}
