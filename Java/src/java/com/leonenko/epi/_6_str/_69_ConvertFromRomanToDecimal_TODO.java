package com.leonenko.epi._6_str;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Alex on 5/12/2017.
 *
 * http://www.geeksforgeeks.org/converting-roman-numerals-decimal-lying-1-3999/
 * http://www.geeksforgeeks.org/converting-decimal-number-lying-between-1-to-3999-to-roman-numerals/
 */
public class _69_ConvertFromRomanToDecimal_TODO {

    private static final Map<Character, Integer> ROMAN_TO_INT =
            new HashMap<Character, Integer>() {{
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }};

    private static final Map<Integer, Character> INT_TO_ROMAN =
            new HashMap<Integer, Character>() {{
                ROMAN_TO_INT.forEach((symbol, value) -> put(value, symbol));
            }};


    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int original = 1 + random.nextInt(20 + 1);
            String roman = toRoman(original);
            int converted = toInt(roman);
            System.out.printf("original=%s, converted=%s, roman=%s%n", original, converted, roman);
        }
    }

    private static String toRoman(int i) {
        return "";
    }

    private static int toInt(String roman) {
        int num = ROMAN_TO_INT.get(roman.charAt(roman.length() - 1));
        for (int i = roman.length() - 2; i >= 0; i--) {
            char precedingSymbol = roman.charAt(i);
            char followingSymbol = roman.charAt(i + 1);
            if (!isValid(followingSymbol, precedingSymbol)) {
                throw new IllegalArgumentException("Invalid roman numeral " + roman);
            }
            num += ROMAN_TO_INT.get(precedingSymbol) < ROMAN_TO_INT.get(followingSymbol)
                    ? ROMAN_TO_INT.get(precedingSymbol) : -ROMAN_TO_INT.get(precedingSymbol);
        }
        return num;
    }

    private static boolean isValid(char followingSymbol, char precedingSymbol) {
        switch (followingSymbol) {
            case 'V':
                return precedingSymbol == 'I';
            case 'X':
                return precedingSymbol == 'I';
            case 'L':
                return precedingSymbol == 'X';
            case 'C':
                return precedingSymbol == 'X';
            case 'D':
                return precedingSymbol == 'C';
            case 'M':
                return precedingSymbol == 'C';
        }
        return false;
    }
}
