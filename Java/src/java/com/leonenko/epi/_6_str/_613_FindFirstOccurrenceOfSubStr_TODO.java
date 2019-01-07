package com.leonenko.epi._6_str;

/**
 * Created by Alex on 5/12/2017.
 */
public class _613_FindFirstOccurrenceOfSubStr_TODO {

    private static final int BASE = 26;

    public static void main(String[] args) {
        printFirstOccurrence("aaaabbbbcccccabcaabcabc!!!", "abc!");
        printFirstOccurrence("aaaabbbbcccccabcaabcabc!!!", "bca");
        printFirstOccurrence("aaaabbbbcccccabcaabcabc!!!", "bca!");
    }

    private static void printFirstOccurrence(String text, String pattern) {
        int foundIndex = findFirstOccurrence(text, pattern);
        if (foundIndex >= 0) {
            System.out.printf("%s found in %s at %s", pattern, text, foundIndex);
        } else {
            System.out.printf("%s not found in %s", pattern, text);
        }
        System.out.println();
    }

    private static int findFirstOccurrence(String text, String pattern) {
        if (text.length() < pattern.length()) {
            return -1;
        }
        int textHash = 0;
        int patternHash = 0;
        int power = 1;
        for (int i = 0; i < pattern.length(); i++) {
            power = i > 0 ? power * BASE : 1;
            textHash = textHash * BASE + text.charAt(i);
            patternHash = patternHash * BASE + pattern.charAt(i);
        }
        for (int i = pattern.length(); i < text.length(); i++) {
            if (textHash == patternHash
                    && text.substring(i - pattern.length(), i).equals(pattern)) {
                return i - pattern.length();
            }
            textHash -= text.charAt(i - pattern.length()) * power;
            textHash = textHash * BASE + text.charAt(i);
        }
        if (textHash == patternHash
                && text.substring(text.length() - pattern.length()).equals(pattern)) {
            return text.length() - pattern.length();
        }
        return -1;
    }
}
