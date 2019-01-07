package com.leonenko.epi._24_honor_TODO;

import java.awt.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class _2419_FindLineThroughMostPoints_TODO {

    static Line findLineWithMostPoints(Point[] points) {
        Map<Line, Set<Point>> table = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            Point p1 = points[i];
            for (int j = 0; j < points.length; j++) {
                Point p2 = points[j];
                Line l = new Line(p1, p2);

                Set<Point> points1 = table.get(l);
            }
        }

        return null;
    }

    private static class Line {
        private Rational slope;
        private Rational intercept;

        public Line(Point p1, Point p2) {
            if (p1.getX() != p2.getX()) {
                this.slope = new Rational(p2.y - p1.y, p2.x - p1.x);
                this.intercept = new Rational(p2.x * p1.y - p1.x * p2.y, p2.x - p1.x);
            } else {
                this.slope = new Rational(1, 0);
                this.intercept = new Rational(p1.x, 1);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Line line = (Line) o;
            return slope.equals(line.slope) && intercept.equals(line.intercept);
        }

        @Override
        public int hashCode() {
            return Objects.hash(slope, intercept);
        }
    }

    private static class Rational {
        private int numerator;
        private int denominator;

        public Rational(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;

            if (numerator != 1 && denominator != 0) {
                canonize();
            }
        }

        private void canonize() {
            int gcd = BigInteger.valueOf(numerator).gcd(BigInteger.valueOf(denominator)).intValue();

            numerator /= gcd;
            denominator /= gcd;

            if (denominator < 0) {
                numerator = -numerator;
                denominator = -denominator;
            }
        }
    }


}
