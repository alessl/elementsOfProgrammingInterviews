package com.leonenko.epi._4_primitive;

/**
 * Created by Alex on 5/5/2017.
 */
public class _45_MultiplyWithoutArithmeticOperations {

    static long multiply(long num1, long num2) {
        var sum = 0L;

        while(num1 != 0) {
            if ((num1 & 1) != 0) {
                sum = add(sum, num2);
            }
            num1 >>>= 1;
            num2 <<= 1;
        }

        return sum;
    }

    static long add(long a, long b) {
        var sum = 0L;
        var carry = 0L;
        var tmpA = a;
        var tmpB = b;
        var k = 1L;

        while (tmpA != 0 || tmpB != 0) {
            var ak = a & k;
            var bk = b & k;

            sum |= ak ^ bk ^ carry;

            carry = (ak & bk) | (ak & carry) | (bk & carry);
            carry <<= 1;

            k <<= 1;
            tmpA >>>= 1;
            tmpB >>>= 1;
        }

        return sum;
    }
}
