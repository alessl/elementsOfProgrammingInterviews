package com.leonenko.epi._6_str;

public class _65_TestPalindromicity {

    static boolean isPalindrome(String str) {
        var startIdx = 0;
        var endIdx = str.length() - 1;

        while (startIdx < endIdx) {
            while (!Character.isLetterOrDigit(str.charAt(startIdx)) && startIdx < endIdx) {
                startIdx++;
            }

            while (!Character.isLetterOrDigit(str.charAt(endIdx)) && startIdx < endIdx) {
                endIdx--;
            }

            if (Character.toLowerCase(str.charAt(startIdx++))
                    != Character.toLowerCase(str.charAt(endIdx--))) {
                return false;
            }
        }

        return true;
    }
}
