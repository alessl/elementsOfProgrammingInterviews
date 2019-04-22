package com.leonenko.epi._6_str;

/**
 * Created by Alex on 5/12/2017.
 */
public class _613_FindFirstOccurrenceOfSubStr {

    private static final int BASE = 26;

    static int findFirstOccurrence(String txt, String pat) {
        if (txt.length() < pat.length()) {
            return -1;
        }

        int txtHash = 0;
        int patHash = 0;
        int pow = 1;

        for (int i = 0; i < pat.length(); i++) {
            pow = i > 0 ? pow * BASE : 1;
            txtHash = txtHash * BASE + txt.charAt(i);
            patHash = patHash * BASE + pat.charAt(i);
        }

        for (int i = pat.length(); i < txt.length(); i++) {
            if (txtHash == patHash && txt.substring(i - pat.length(), i).equals(pat)) {
                return i - pat.length();
            }
            txtHash -= txt.charAt(i - pat.length()) * pow;
            txtHash = txtHash * BASE + txt.charAt(i);
        }

        if (txtHash == patHash
                && txt.substring(txt.length() - pat.length()).equals(pat)) {
            return txt.length() - pat.length();
        }

        return -1;
    }
}
