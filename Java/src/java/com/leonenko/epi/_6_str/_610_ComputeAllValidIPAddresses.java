package com.leonenko.epi._6_str;

import java.util.ArrayList;
import java.util.List;

public class _610_ComputeAllValidIPAddresses {

    static List<String> getAllValidIpAddresses(String str) {
        var allIpAddresses = new ArrayList<String>();

        for (int i = 1; i < 4 && i < str.length(); i++) {
            var firstPart = str.substring(0, i);

            if (isValidPartOfIpAddress(firstPart)) {
                for (int j = 1; i + j < str.length(); j++) {
                    var secondPart = str.substring(i, i + j);

                    if (isValidPartOfIpAddress(secondPart)) {
                        for (int k = 1; i + j + k < str.length(); k++) {
                            var thirdPart = str.substring(i + j, i + j + k);
                            var fourthPart = str.substring(i + j + k);

                            if (isValidPartOfIpAddress(thirdPart)
                                    && isValidPartOfIpAddress(fourthPart)) {
                                allIpAddresses.add(String.join(".",
                                        firstPart, secondPart, thirdPart, fourthPart));
                            }
                        }
                    }
                }
            }
        }

        return allIpAddresses;
    }

    private static boolean isValidPartOfIpAddress(String str) {
        if (str.length() > 3) {
            return false;
        }

        if (str.startsWith("0") && str.length() > 1) {
            return false;
        }

        var val = Integer.parseInt(str);

        return val <= 255 && val >= 0;
    }
}
