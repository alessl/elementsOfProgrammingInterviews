package com.leonenko.epi._24_honor_TODO;

import java.util.Arrays;

public class _2426_RegularExpressionMatching {

    static boolean isMatch(String regex, String str) {
        if (regex.charAt(0) == '^') {
            return isMatchHere(regex.substring(1), str);
        }
        for (var i = 0; i < str.length(); i++) {
            if (isMatchHere(regex, str.substring(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean isMatchHere(String regex, String str) {
        if (regex.isEmpty()) {
            return true;
        }
        if ("$".equals(regex)) {
            return str.isEmpty();
        }

        if (regex.length() >= 2 && regex.charAt(1) == '*') {
            // traverse string while current str char matches regex char before *
            for (var i = 0; i < str.length() && isCharMatch(regex.charAt(0), str.charAt(i)); i++) {
                // is suffix of string matches the remainder of regex
                if (isMatchHere(regex.substring(2), str.substring(i + 1))) {
                    return true;
                }
            }
            // skip star, meaning there is 0 character marked by star matched so we skip it altogether
            return isMatchHere(regex.substring(2), str);
        }

        return !str.isEmpty()
                && isCharMatch(regex.charAt(0), str.charAt(0))
                && isMatchHere(regex.substring(1), str.substring(1));
    }

    private static boolean isCharMatch(char regexChar, char strChar) {
        return regexChar == '.' || regexChar == strChar;
    }

    // https://www.youtube.com/watch?v=l3hda49XcDE&t=6s
    static boolean isMatchDP(String regex, String str) {
        if (regex.charAt(0) == '^') {
            return doMatchDP(regex.substring(1), str);
        }
        for (var i = 0; i < str.length(); i++) {
            if (doMatchDP(regex, str.substring(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean doMatchDP(String regex, String str) {
        boolean[][] table = new boolean[regex.length() + 1][Math.min(regex.length(), str.length()) + 1];

        Arrays.stream(table).forEach(row -> row[0] = true);

        if (regex.charAt(regex.length() - 1) == '$') {
            table[regex.length()][0] = true;
        }

        for (int i = 1; i < table.length; i++) {
            for (int j = 1; j < table[i].length; j++) {
                var regexChar = regex.charAt(i - 1);
                var strChar = str.charAt(j - 1);

                if (regexChar == strChar || regexChar == '.') {
                    table[i][j] = table[i-1][j - 1];
                } else if (regexChar == '*' && i >= 2) {
                    table[i][j] = table[i - 2][j] || table[i][j - 1];
                } else if (i == regex.length() && regexChar == '$') {
                    table[i][j] = table[i - 1][j];
                }
            }
        }

        return table[table.length - 1][table[0].length - 1];
    }
}
