package com.leonenko.epi._17_greedy_TODO;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Alex on 5/8/2017.
 */
public class _178_MaxRectangleUnderHistogram_TODO {

    public static void main(String[] args) {
        printMaxRectangle(new int[]{1, 4, 2, 5, 6, 3, 2, 6, 5, 5, 2, 1, 3});
        printMaxRectangle(new int[]{1, 4, 2, 5, 6, 3, 2, 6, 5, 5, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1});
    }

    private static void printMaxRectangle(int[] histogram) {
        int maxRectArea = 0;
        int maxRectHeight = 0;
        int maxRectStart = 0;
        int maxRectEnd = 0;
        Deque<Integer> prevBarIndex = new LinkedList<>();
        for (int i = 0; i <= histogram.length; i++) {
            if (!prevBarIndex.isEmpty()
                    && i < histogram.length && histogram[prevBarIndex.peek()] == histogram[i]) {
                prevBarIndex.pop();
                prevBarIndex.push(i);
            }
            while (!prevBarIndex.isEmpty()
                    && (i == histogram.length || histogram[i] < histogram[prevBarIndex.peek()])) {
                // calculate area of the rectangle that end at the prev index
                int height = histogram[prevBarIndex.pop()];
                int start = prevBarIndex.isEmpty() ? i : prevBarIndex.peek() + 1;
                int end = i - 1;
                int width = end - start;
                int newRectArea = height * width;
                if (newRectArea > maxRectArea) {
                    maxRectArea = newRectArea;
                    maxRectHeight = height;
                    maxRectStart = start;
                    maxRectEnd = end;
                }
            }
            prevBarIndex.push(i);
        }
        System.out.printf("a=%s,h=%s,%s-%s%n", maxRectArea, maxRectHeight, maxRectStart, maxRectEnd);
    }
}
