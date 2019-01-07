package com.leonenko.epi._6_str;

import java.util.LinkedList;

/**
 * Created by Alex on 4/30/2017.
 */
public class _62_BaseConversion {

    static String convert(String numAsStr, int fromBase, int toBase) {
        var num = parseInt(numAsStr, fromBase);
        var result = new LinkedList<String>();

        while (num > 0) {
            var digit = num % toBase;

            if (digit > 9) {
                result.push(String.valueOf((char) ('a' + (digit - 10))));
            } else {
                result.push(String.valueOf(digit));
            }

            num /= toBase;
        }

        return String.join("", result).toUpperCase();
    }

    private static int parseInt(String numStr, int base) {
        var num = 0;

        for (char c : numStr.toCharArray()) {
            num = num * base + Character.digit(c, base);
        }

        return num;
    }
}
