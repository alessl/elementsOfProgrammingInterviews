package com.leonenko.epi._24_honor_TODO;

public class _2426_RegularExpressionMatching_TODO {

    static boolean isMatch(String reg, String str) {
        if (reg.charAt(0) == '^') {
            return isMatchHere(reg.substring(1), str);
        }
        for (var i = 0; i < str.length(); i++) {
            if (isMatchHere(reg, str.substring(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean isMatchHere(String reg, String str) {
        if (reg.isEmpty()) {
            return true;
        }
        if ("$".equals(reg)) {
            return str.isEmpty();
        }
        if (reg.length() >= 2 && reg.charAt(1) == '*') {
            for (var i = 0; i < str.length() && isCharMatch(reg, str, i); i++) {
                if (isMatchHere(reg.substring(2), str.substring(i + 1))) {
                    return true;
                }
            }
            return isMatchHere(reg.substring(2), str);
        }

        return !str.isEmpty()
                && isCharMatch(reg, str, 0)
                && isMatchHere(reg.substring(1), str.substring(1));
    }

    private static boolean isCharMatch(String reg, String str, int i) {
        return reg.charAt(0) == '.' || reg.charAt(0) == str.charAt(i);
    }
}
