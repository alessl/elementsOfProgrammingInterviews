package com.leonenko.epi._8_stackqueue;

import java.util.LinkedList;

public class _84_NormalizePathNames {

    static String shorten(String longPath) {
        var tokenStack = new LinkedList<String>();

        if (longPath.startsWith("/")) {
            tokenStack.push("/");
        }

        for (String token : longPath.split("/")) {
            if (token.isBlank() || token.equals(".")) {
                continue;
            }

            if (token.equals("..")) {
                if (tokenStack.isEmpty() || tokenStack.peek().equals("..")) {
                    tokenStack.push(token);
                } else {
                    if (tokenStack.peek().equals("/")) {
                        throw new IllegalArgumentException("Error");
                    }
                    tokenStack.pop();
                }
            } else {
                tokenStack.push(token);
            }

            tokenStack.push("/");
        }

        var strBuilder = new StringBuilder();

        while (!tokenStack.isEmpty()) {
            strBuilder.insert(0, tokenStack.pop());
        }

        return strBuilder.toString();
    }
}
