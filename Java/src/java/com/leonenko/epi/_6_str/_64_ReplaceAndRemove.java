package com.leonenko.epi._6_str;

import java.util.Arrays;

/**
 * Created by Alex on 5/12/2017.
 */
public class _64_ReplaceAndRemove {

    static String replaceAndRemove(String inputStr) {
        var a = inputStr.toCharArray();

        var numA = 0;
        var writeIndex = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == 'a') {
                numA++;
            }
            if (a[i] != 'b') {
                a[writeIndex++] = a[i];
            }
        }


        var currIndex = writeIndex - 1;

        writeIndex = writeIndex + numA - 1;

        var len = writeIndex + 1;

        if (len > a.length) {
            a = Arrays.copyOf(a, len);
        }

        while (currIndex >= 0) {
            if (a[currIndex] == 'a') {
                a[writeIndex--] = 'd';
                a[writeIndex--] = 'd';
            } else {
                a[writeIndex--] = a[currIndex];
            }
            currIndex--;
        }

        return String.copyValueOf(a);
    }
}
