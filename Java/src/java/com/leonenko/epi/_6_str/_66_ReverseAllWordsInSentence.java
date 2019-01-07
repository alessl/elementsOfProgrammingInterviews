package com.leonenko.epi._6_str;

/**
 * Created by Alex on 4/30/2017.
 */
public class _66_ReverseAllWordsInSentence {

    static void reverseWords(char[] sentence) {
        var startIdx = 0;

        while (startIdx < sentence.length) {
            var end = startIdx + 1;

            while (end < sentence.length && sentence[end] != ' ') {
                end++;
            }

            reverse(sentence, startIdx, end - 1);

            startIdx = end + 1;
        }

        reverse(sentence, 0, sentence.length - 1);
    }

    private static void reverse(char[] array, int start, int end) {
        var i = start;
        var j = end;

        while (i < j) {
            var tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;

            i++;
            j--;
        }
    }
}
