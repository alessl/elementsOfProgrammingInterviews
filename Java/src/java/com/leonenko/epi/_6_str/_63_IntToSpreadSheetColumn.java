package com.leonenko.epi._6_str;

/**
 * Created by Alex on 5/12/2017.
 *
 * http://www.geeksforgeeks.org/find-excel-column-name-given-number/
 */
public class _63_IntToSpreadSheetColumn {

    static String intToCol(int number) {
        var columnBuilder = new StringBuilder();

        while (number > 0) {
            number -= 1;
            columnBuilder.append((char) (number % 26 + 'A'));
            number = number / 26;
        }

        columnBuilder.reverse();

        return columnBuilder.toString();
    }

    static int colToInt(String column) {
        var number = 0;

        for (int i = 0; i < column.length(); i++) {
            char ch = column.charAt(i);
            number *= 26;
            number += ch - 'A' + 1;
        }

        return number;
    }
}
