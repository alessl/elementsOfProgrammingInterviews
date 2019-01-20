package com.leonenko.epi._16_dp;

import java.util.*;

/**
 * Created by Alex on 5/7/2017.
 */
public class _167_BedBathAndBeyond {

    static List<String> getWords(String text, Set<String> dict) {
        int[] lastLength = new int[text.length()];
        Arrays.fill(lastLength, -1);

        for (int i = 0; i < text.length(); i++) {
            if (dict.contains(text.substring(0, i + 1))) {
                lastLength[i] = i + 1;
            }
            if (lastLength[i] == -1) {
                for (int j = 0; j < i; j++) {
                    if (lastLength[j] != -1
                            && dict.contains(text.substring(j + 1, i + 1))) {
                        lastLength[i] = i - j;
                        break;
                    }
                }
            }
        }

        List<String> words = new ArrayList<>();
        if (lastLength[lastLength.length - 1] != -1) {
            int index = text.length() - 1;
            while (index >= 0) {
                words.add(text.substring(index + 1 - lastLength[index], index + 1));
                index -= lastLength[index];
            }
            Collections.reverse(words);
        }
        return words;
    }

    static List<String> getPalindromes(String text, Set<String> dict) {
        return List.of();
    }
}
