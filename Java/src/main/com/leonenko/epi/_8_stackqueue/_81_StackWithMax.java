package com.leonenko.epi._8_stackqueue;

import java.util.Arrays;

public class _81_StackWithMax {

    private int[] data;
    private int topIndex;
    private int min;
    private int max;

    _81_StackWithMax(int size) {
        this.data = new int[size];
    }

    void push(int valueToInsert) {
        if (topIndex == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }

        if (isEmpty()) {
            min = valueToInsert;
            max = valueToInsert;
        } else if (valueToInsert < min) {
            var newMin = valueToInsert;
            valueToInsert = valueToInsert * 2 - min;
            min = newMin;
        } else if (valueToInsert > max) {
            var newMax = valueToInsert;
            valueToInsert = valueToInsert * 2 - max;
            max = newMax;
        }

        data[topIndex++] = valueToInsert;
    }

    int peek() {
        if (isEmpty()) {
            return -1;
        }

        var peekResult = data[topIndex - 1];

        if (peekResult < min) {
            peekResult = min;
        } else if (peekResult > max) {
            peekResult = max;
        }

        return peekResult;
    }

    int pop() {
        if (isEmpty()) {
            return -1;
        }

        if (topIndex - 1 < data.length / 4) {
            data = Arrays.copyOf(data, data.length / 2);
        }

        int popResult = data[--topIndex];

        if (popResult < min) {
            var tmp = min * 2 - popResult;
            popResult = min;
            min = tmp;
        } else if (popResult > max) {
            var tmp = max * 2 - popResult;
            popResult = max;
            max = tmp;
        }
        return popResult;
    }

    int min() {
        return min;
    }

    int max() {
        return max;
    }

    boolean isEmpty() {
        return topIndex == 0;
    }

    @Override
    public String toString() {
        return String.format("%s, min=%s, max=%s", Arrays.toString(data), min(), max());
    }
}
