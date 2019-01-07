package com.leonenko.epi._6_str;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 5/12/2017.
 *
 * http://www.geeksforgeeks.org/find-possible-words-phone-digits/
 */
public class _67_ComputeAllMnemonicsForPhoneNumber {

    private static final String[] LETTERS =
            {"+", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" };

    static List<String> enumerateAllMnemonics(String number) {
        var mnemonics = new ArrayList<String>();

        enumerateAllMnemonics(number, 0, new char[number.length()], mnemonics);

        return mnemonics;
    }

    private static void enumerateAllMnemonics(String number,
            int digitIndex, char[] mnemonic, List<String> mnemonics) {

        if (digitIndex == number.length()) {
            mnemonics.add(String.copyValueOf(mnemonic));
            return;
        }

        var digit = number.charAt(digitIndex) - '0';

        for (char letter : LETTERS[digit].toCharArray()) {
            mnemonic[digitIndex] = letter;
            enumerateAllMnemonics(number, digitIndex + 1, mnemonic, mnemonics);
        }
    }
}
