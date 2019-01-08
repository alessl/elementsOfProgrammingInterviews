package com.leonenko.epi._17_greedy;

import lombok.Value;

import java.util.LinkedList;

/**
 * Created by Alex on 5/8/2017.
 */
public class _178_MaxRectangleUnderSkyline {

    static MaxRectangle getMaxRectangle(int[] histogram) {
        var maxArea = 0;
        var maxHeight = 0;
        var maxStart = 0;
        var maxEnd = 0;

        var prevBarIndex = new LinkedList<Integer>();

        for (int i = 0; i <= histogram.length; i++) {
            if (!prevBarIndex.isEmpty() && i < histogram.length
                    && histogram[prevBarIndex.peek()] == histogram[i]) {
                prevBarIndex.pop();
                prevBarIndex.push(i);
            }

            while (!prevBarIndex.isEmpty()
                    && (i == histogram.length || histogram[i] < histogram[prevBarIndex.peek()])) {
                // calculate area of the rectangle that end at the prev index
                var height = histogram[prevBarIndex.pop()];
                var start = prevBarIndex.isEmpty() ? i : prevBarIndex.peek() + 1;
                var end = i - 1;
                var width = end - start;
                var newRectArea = height * width;

                if (newRectArea > maxArea) {
                    maxArea = newRectArea;
                    maxHeight = height;
                    maxStart = start;
                    maxEnd = end;
                }
            }

            prevBarIndex.push(i);
        }

        return new MaxRectangle(maxArea, maxHeight, maxStart, maxEnd);
    }

    @Value
    static class MaxRectangle {
        private int area;
        private int height;
        private int start;
        private int end;
    }
}
