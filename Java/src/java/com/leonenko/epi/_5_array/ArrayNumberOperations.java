package com.leonenko.epi._5_array;

import java.util.Arrays;

/**
 * Created by Alex on 4/28/2017.
 */
public class ArrayNumberOperations {

    public static void main(String[] args) {
        multiplyAndPrint(new int[] {5, 2, 3, 0, 9}, new int[] {1, 8, 2, 5});
        multiplyAndPrint(new int[] {5, 2, 3, 0, 9}, new int[] {2, 1, 8, 2, 5});
        multiplyAndPrint(new int[] {5}, new int[] {5});
        addAndPrint(new int[] {5, 2, 3, 0, 9}, new int[] {1, 8, 2, 5});
        addAndPrint(new int[] {9, 5, 2}, new int[] {8, 9});
        addAndPrint(new int[] {9, 5, 2}, new int[] {1, 7, 9});
        addAndPrint(new int[] {2}, new int[] {2});
        addAndPrint(new int[] {9}, new int[] {5});
        addAndPrint(new int[] {5, 1, 1, 0}, new int[] {1});
    }

    private static void addAndPrint(int[] numArray1, int[] numArray2) {
        int num1 = toNumber(numArray1);
        int num2 = toNumber(numArray2);
        int[] product = add(numArray1, numArray2);
        System.out.printf("%s + %s = %s = %s%n", num1, num2, num1 + num2, toNumber(product));
    }

    static int[] add(int[] num1, int[] num2) {
        if (num1.length < num2.length) {
            var tmp = num1;
            num1 = num2;
            num2 = tmp;
        }

        var index1 = num1.length - 2;
        var index2 = num2.length - 1;

        while (index1 >= 0 && index2 >= 0) {
            num1[index1 + 1] += num2[index2];
            num1[index1] += num1[index1 + 1] / 10;
            num1[index1 + 1] %= 10;
            index1--;
            index2--;
        }

        if (index2 == 0) {
            num1[0] += num2[0];
        }

        if (num1[0] > 9) {
            var tmp = new int[num1.length + 1];
            System.arraycopy(num1, 0, tmp, 1, num1.length);
            tmp[0] = 1;
            tmp[1] %= 10;
            num1 = tmp;
        }

        return num1;
    }

    private static void multiplyAndPrint(int[] numArray1, int[] numArray2) {
        int num1 = toNumber(numArray1);
        int num2 = toNumber(numArray2);
        int[] product = multiply(numArray1, numArray2);
        System.out.printf("%s * %s = %s = %s%n", num1, num2, num1 * num2, toNumber(product));
    }

    private static int[] multiply(int[] num1, int[] num2) {
        int[] prod = new int[num1.length + num2.length];
        for (int index1 = num1.length - 1; index1 >= 0; index1--) {
            for (int index2 = num2.length - 1; index2 >= 0; index2--) {
                int prodIndex = index1 + index2;
                int prodPrevIndex = prodIndex + 1;
                prod[prodPrevIndex] += num1[index1] * num2[index2];
                prod[prodIndex] += prod[prodPrevIndex] / 10;
                prod[prodPrevIndex] = prod[prodPrevIndex] % 10;
            }
        }
        int start = 0;
        while (start < prod.length && prod[start] == 0) {
            start++;
        }
        return Arrays.copyOfRange(prod, start, prod.length);
    }

    private static int toNumber(int[] a) {
        int n = 0;
        for (int i : a) {
            n = n * 10 + i;
        }
        return n;
    }
}
