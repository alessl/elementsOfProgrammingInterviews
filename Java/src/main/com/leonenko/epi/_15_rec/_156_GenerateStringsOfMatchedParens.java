package com.leonenko.epi._15_rec;

import java.util.ArrayList;
import java.util.List;

public class _156_GenerateStringsOfMatchedParens {

    public static List<String> enumerateBalancedParentheses(int numPairs) {
        var enumeratedStrings = new ArrayList<String>();

        enumerateBalancedParentheses(numPairs, numPairs, new StringBuilder(), enumeratedStrings);

        return enumeratedStrings;
    }

    private static void enumerateBalancedParentheses(int numLeft, int numRight,
            StringBuilder strBuilder, List<String> enumeratedStrings) {

        if (numLeft == 0 && numRight == 0) {
            if (strBuilder.length() > 0) {
                enumeratedStrings.add(strBuilder.toString());
            }
            return;
        }

        if (numLeft > 0) {
            strBuilder.append("(");

            enumerateBalancedParentheses(numLeft - 1, numRight, strBuilder, enumeratedStrings);

            strBuilder.deleteCharAt(strBuilder.length() - 1);
        }

        if (numLeft < numRight) {
            strBuilder.append(")");

            enumerateBalancedParentheses(numLeft, numRight - 1, strBuilder, enumeratedStrings);

            strBuilder.deleteCharAt(strBuilder.length() - 1);
        }
    }
}
