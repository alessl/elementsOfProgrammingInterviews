package com.leonenko.epi._12_hash_TODO;

import java.util.HashMap;

public class _121_PalindromicPermutations {

    static boolean isPalindromePossible(String s) {
        var charCounts = new HashMap<Character, Integer>();

        for (var c : s.toCharArray()) {
            charCounts.compute(c, (k, v) -> v == null ? 1 : null);
        }

        return charCounts.isEmpty() || charCounts.size() == 1;
    }
}
