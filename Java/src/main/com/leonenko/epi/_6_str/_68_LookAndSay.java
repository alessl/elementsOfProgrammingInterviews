package com.leonenko.epi._6_str;

public class _68_LookAndSay {

    static String lookAndSay(int number) {
        var str = "1";

        for (int i = 1; i < number; i++) {
            str = nextNumber(str);
        }

        return str;
    }

    private static String nextNumber(String str) {
        var strBuilder = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            var cnt = 1;

            while (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                i++;
                cnt++;
            }

            strBuilder.append(cnt);
            strBuilder.append(str.charAt(i));
        }

        return strBuilder.toString();
    }
}
