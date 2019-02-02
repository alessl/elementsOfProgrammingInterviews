package com.leonenko.epi._12_hash_TODO;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Created by Alex on 5/13/2017.
 */
public class _122_IsAnonymousLetterPossible {

    static boolean isAnonymousLetterPossible(String letter, String text) {
        var letterChars = letter.chars()
                .mapToObj(c -> (char) c)
                .collect(groupingBy(identity(), counting()));

        for (char c : text.toCharArray()) {
            letterChars.computeIfPresent(c, (k, v) -> v - 1 == 0 ? null : v - 1);

            if (letterChars.isEmpty()) {
                return true;
            }
        }

        return false;
    }
}
