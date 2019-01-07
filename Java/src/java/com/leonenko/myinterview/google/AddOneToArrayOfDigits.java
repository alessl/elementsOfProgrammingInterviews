package com.leonenko.myinterview.google;

import java.util.Arrays;

/**
 * Created by leo on 5/31/2016.
 */
public class AddOneToArrayOfDigits {

    public static void main(String[] args) {
        printAddOne(new int[] {1, 2, 3});
        printAddOne(new int[] {9, 9, 9, 9});
        printAddOne(new int[] {5, 8, 9});
        printAddOne(new int[] {9});
        printAddOne(new int[] {0});
    }

    private static void printAddOne(int[] digits) {
        System.out.println("AddToNumber" + Arrays.toString(addOneToNumber(digits)));
        System.out.println("AddToArray" + Arrays.toString(addOneToArray(digits)));
    }

    private static int[] addOneToArray(int[] input) {
        int carry = 1;
        int current = input.length - 1;
        while (carry > 0 && current >= 0) {
            input[current] += carry;
            carry = input[current] / 10;
            input[current] %= 10;
            current--;
        }
        if (carry > 0) {
            int[] result = new int[input.length + 1];
            result[0] = carry;
            System.arraycopy(input, 0, result, 1, input.length);
            return result;
        }
        return input;
    }

    private static int[] addOneToNumber(int[] digits) {
        return toArray(toNumber(digits) + 1);
    }

    private static int toNumber(int[] input) {
        int power10 = input.length - 1;
        int number = 0;
        for (int digit : input) {
            number += digit * Math.pow(10, power10--);
        }
        return number;
    }

    private static int[] toArray(int number) {
        int numDigits = countDigits(number);
        int power10 = numDigits - 1;
        int[] digits = new int[numDigits];
        for (int i = 0; i < numDigits; i++) {
            digits[i] = number / (int) Math.pow(10, power10);
            number = number % (int) Math.pow(10, power10);
            power10--;
        }
        return digits;
    }

    private static int countDigits(int number) {
        int numDigits = 0;
        while (number != 0) {
            numDigits++;
            number /= 10;
        }
        return numDigits;
    }
}
