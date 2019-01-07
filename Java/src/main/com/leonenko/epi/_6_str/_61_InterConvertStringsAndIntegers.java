package com.leonenko.epi._6_str;

public class _61_InterConvertStringsAndIntegers {

    static String intToStr(int number) {
        var isNegative = number < 0;

        var strBuilder = new StringBuilder();

        do {
            var valueToAppend = (char) ('0' + Math.abs(number % 10));
            strBuilder.append(valueToAppend);
            number /= 10;
        } while (number != 0);

        if (isNegative) {
            strBuilder.append('-');
        }

        return strBuilder.reverse().toString();
    }

    static int strToInt(String numberAsStr) {
        var number = 0;
        var isNegative = numberAsStr.charAt(0) == '-';
        var startIdx = isNegative ? 1 : 0;

        for (int i = startIdx; i < numberAsStr.length(); i++) {
            var digit = numberAsStr.charAt(i) - '0';
            number = number * 10 + digit;
        }

        return isNegative ? -number : number;
    }
}
