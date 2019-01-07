package com.leonenko.epi._6_str;

public class _611_WriteStringSinusoidally {

    static String getStringSinusoidally(String inputStr) {
        var strBuilder = new StringBuilder();

        for (int i = 0, j = 1; i < inputStr.length(); i++) {
            if (i == j) {
                strBuilder.append(charAt(inputStr, i));
                j += 4;
            } else {
                strBuilder.append(" ");
            }
        }

        strBuilder.append("\n");

        for (int i = 0, j = 0; i < inputStr.length(); i++) {
            if (i == j) {
                strBuilder.append(charAt(inputStr, i));
                j += 2;
            } else {
                strBuilder.append(" ");
            }
        }

        strBuilder.append("\n");

        for (int i = 0, j = 3; i < inputStr.length(); i++) {
            if (i == j) {
                strBuilder.append(charAt(inputStr, i));
                j += 4;
            } else {
                strBuilder.append(" ");
            }
        }

        strBuilder.append("\n");

        return strBuilder.toString();
    }

    private static char charAt(String inputStr, int i) {
        return !Character.isWhitespace(inputStr.charAt(i)) ? inputStr.charAt(i) : '_';
    }
}
