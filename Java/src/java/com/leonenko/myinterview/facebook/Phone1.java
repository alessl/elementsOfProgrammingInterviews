package com.leonenko.myinterview.facebook;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Alex on 5/9/2017.
 */
public class Phone1 {

    public static void main(String[] args) {
        int[] a = {1, 0, -2, 3, 5, 0, 0, 10, 2};
        System.out.println(Arrays.toString(a));
        System.out.println(removeZeros(a));
        System.out.println(Arrays.toString(a));

        Random random = new Random();
        int n1 = random.nextInt(10000 + 1);
        int n2 = random.nextInt(100 + 1);
        String b1 = Integer.toBinaryString(n1);
        String b2 = Integer.toBinaryString(n2);
        String b3 = Integer.toBinaryString(n1 + n2);
        System.out.printf("%s + %s = %s = %s", b1, b2, b3, add(b1, b2));
    }

    private static int removeZeros(int[] nums) {
        int writeIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[writeIndex++] = nums[i];
            }
        }

        Arrays.fill(nums, writeIndex, nums.length, 0);

        return writeIndex;
    }

    private static String add(String num1, String num2) {
        var sum = new StringBuilder();

        var carry = 0;
        var i1 = num1.length() - 1;
        var i2 = num2.length() - 1;

        while (i1 >= 0 || i2 >= 0 || carry != 0) {
            var d1 = i1 >= 0 ? Character.digit(num1.charAt(i1), 2) : 0;
            var d2 = i2 >= 0 ? Character.digit(num2.charAt(i2), 2) : 0;

            sum.append(d1 ^ d2 ^ carry);

            carry = d1 & d2 | d1 & carry | d2 & carry;

            i1--;
            i2--;
        }

        return sum.reverse().toString();
    }
}
