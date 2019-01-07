package com.leonenko.myinterview;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Created by Alex on 5/11/2017.
 */
public class SeparateRepeatedCharsByDistance {

    private static final char GAP = '_';

    public static void main(String[] args) {
        separateRepeatedChars("AAAAACCCCCCBBBD", 3);
        separateRepeatedChars("AAABBBCCC", 2);
        separateRepeatedChars("AAAAAABC", 1);
        separateRepeatedChars("AAABC", 2);
        separateRepeatedChars("AAABC", 1);
    }

    static String separateRepeatedChars(String str, int distance) {
        var charCounts = str.chars()
                            .mapToObj(c -> (char) c)
                            .collect(groupingBy(c -> c, counting()));

        var sortedCharsByCount = new PriorityQueue<Character>(
                comparing(charCounts::get, reverseOrder()));

        sortedCharsByCount.addAll(charCounts.keySet());

        var resultBuilder = new StringBuilder();

        while (!sortedCharsByCount.isEmpty()) {
            int start = 0;

            while (start < resultBuilder.length()
                    && resultBuilder.charAt(start) != GAP) {
                start++;
            }

            var ch = sortedCharsByCount.poll();
            var cnt = charCounts.remove(ch);

            for (int i = 0; i < cnt; i++) {
                int set = start + i * (distance + 1);

                while (set >= resultBuilder.length()) {
                    resultBuilder.append(GAP);
                }

                resultBuilder.setCharAt(set, ch);
            }
        }
        System.out.println(resultBuilder);

        return resultBuilder.toString();
    }
}
