package com.leonenko.epi._8_stackqueue;

import java.util.LinkedList;

public class _83_IsStringWellFormed {

    static boolean isValid(String s) {
        var openStack = new LinkedList<Character>();

        for (var i = 0; i < s.length(); i++) {
            var chr = s.charAt(i);

            if (chr == '(' || chr == '{' || chr == '[') {
                openStack.push(chr);
            } else if (openStack.isEmpty()) {
                return false;
            } else {
                var openChr = openStack.pop();

                if (chr == ')' && openChr != '('
                        || chr == '}' && openChr != '{'
                        || chr == ']' && openChr != '[') {
                    return false;
                }
            }
        }

        return openStack.isEmpty();
    }
}
