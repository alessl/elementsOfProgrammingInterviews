package com.leonenko.epi._24_honor_TODO;

import java.util.*;
import java.util.stream.Collectors;

public class _2425_ViewFromAbove_TODO {

    public static void main(String[] args) {

    }

    static List<LineSegment> calculateViewFromAbove(List<LineSegment> lines) {
        List<Endpoint> sortedEndpoints = lines.stream()
                .map(line -> new Endpoint(true, line))
                .sorted()
                .collect(Collectors.toList());

        List<LineSegment> result = new ArrayList<>();

        int previousEndpointValue = sortedEndpoints.get(0).value();
        LineSegment previousLine = null;
        NavigableMap<Integer, LineSegment> activeLines = new TreeMap<>();

        for (Endpoint endpoint : sortedEndpoints) {
            if (!activeLines.isEmpty() && previousEndpointValue != endpoint.value()) {
                if (previousLine == null) {
                    previousLine = new LineSegment(previousEndpointValue,
                            endpoint.value(),
                            activeLines.lastEntry().getValue().color,
                            activeLines.lastEntry().getValue().height);
                } else {
                    if (previousLine.height == activeLines.lastEntry().getValue().height
                            && previousLine.color == activeLines.lastEntry().getValue().color
                            && previousEndpointValue == previousLine.right) {
                        previousLine.right = endpoint.value();
                    } else {
                        result.add(previousLine);

                        previousLine = new LineSegment(previousEndpointValue,
                                endpoint.value(),
                                activeLines.lastEntry().getValue().color,
                                activeLines.lastEntry().getValue().height);
                    }
                }
            }

            previousEndpointValue = endpoint.value();

            if (endpoint.isLeft) {
                activeLines.put(endpoint.line.height, endpoint.line);
            } else {
                activeLines.remove(endpoint.line.height);
            }
        }

        if (previousLine != null) {
            result.add(previousLine);
        }

        return result;
    }

    private static final class LineSegment {
        private int left;
        private int right;
        private int color;
        private int height;

        public LineSegment(int left, int right, int color, int height) {
            this.left = left;
            this.right = right;
            this.color = color;
            this.height = height;
        }
    }

    private static final class Endpoint implements Comparable<Endpoint> {
        private boolean isLeft;
        private LineSegment line;

        public Endpoint(boolean isLeft, LineSegment line) {
            this.isLeft = isLeft;
            this.line = line;
        }

        public int value() {
            return isLeft ? line.left : line.right;
        }


        @Override
        public int compareTo(Endpoint o) {
            return Integer.compare(value(), o.value());
        }
    }
}
