package com.leonenko.epi._24_honor_TODO;

import java.util.LinkedList;

/**
 * Created by Alex on 5/6/2017.
 *
 * http://www.geeksforgeeks.org/length-of-the-longest-valid-substring/
 */
public class _2411_LongestSubStrWithMatchingParens {

    public static String getLongestValidSubStr(String s) {
        var maxValidStart = 0;
        var maxValidLen = 0;
        var stack = new LinkedList<Integer>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (!stack.isEmpty()) {
                stack.pop();

                int validStart = stack.isEmpty() ? 0 : stack.peek() + 1;
                if (i - validStart + 1 > maxValidLen) {
                    maxValidStart = validStart;
                    maxValidLen = i - validStart + 1;
                }
            } else {
                stack.push(i);
            }
        }
        return s.substring(maxValidStart, maxValidStart + maxValidLen);
    }
}
