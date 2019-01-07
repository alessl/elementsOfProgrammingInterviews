package com.leonenko.epi._4_primitive;

/**
 * Created by Alex on 5/5/2017.
 */
public class _49_IsDecimalIntegerPalindrome {

    static void printPalindromeOrNot(int num) {
        boolean isPalindrome = isPalindrome(num);

        System.out.printf("%s is %s%n", num, isPalindrome ? "palindrome" : "not palindrome");
    }

    private static boolean isPalindrome(int num) {
        var isPalindrome = true;
        var msdPow10 = (int) Math.log10(num);
        var numDigits = msdPow10 + 1;
        var msdMask = (int) Math.pow(10, msdPow10);
        var tmp = num;

        for (int i = 0; i < numDigits / 2 && isPalindrome; i++) {
            var msd = tmp / msdMask;
            var lsd = tmp % 10;

            if (msd != lsd) {
                isPalindrome = false;
            }

            tmp %= 10;
            tmp /= msdMask;
            msdMask /= 100;
        }
        return isPalindrome;
    }
}
