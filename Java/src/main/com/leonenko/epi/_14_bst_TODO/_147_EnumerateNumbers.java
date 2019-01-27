package com.leonenko.epi._14_bst_TODO;

import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class _147_EnumerateNumbers {

    static List<ABSqrt2Number> enumerateNumbersBst(int k) {
        var possibleNumbers = new TreeSet<ABSqrt2Number>();

        possibleNumbers.add(new ABSqrt2Number(0, 0));

        var result = new ArrayList<ABSqrt2Number>();

        while (result.size() < k) {
            var nextSmallest = possibleNumbers.pollFirst();

            result.add(nextSmallest);

            possibleNumbers.addAll(nextSmallest.next());
        }

        return result;
    }

    static List<ABSqrt2Number> enumerateNumbersAdd(int k) {
        var result = new ArrayList<ABSqrt2Number>();

        result.add(new ABSqrt2Number(0, 0));

        var a = 0;
        var b = 0;

        for (int n = 1; n < k; n++) {
            var aPlus1 = new ABSqrt2Number(result.get(a).a + 1, result.get(a).b);
            var bPlus1 = new ABSqrt2Number(result.get(b).a, result.get(b).b + 1);

            result.add(aPlus1.value < bPlus1.value ? aPlus1 : bPlus1);

            if (aPlus1.compareTo(result.get(result.size() - 1)) == 0) {
                a++;
            }

            if (bPlus1.compareTo(result.get(result.size() - 1)) == 0) {
                b++;
            }
        }

        return result;
    }

    @EqualsAndHashCode
    public static class ABSqrt2Number implements Comparable<ABSqrt2Number> {
        private static final double SQRT2 = Math.sqrt(2);

        private int a;
        private int b;
        private double value;

        public ABSqrt2Number(int a, int b) {
            this.a = a;
            this.b = b;
            this.value = a + b * SQRT2;
        }

        public List<ABSqrt2Number> next() {
            return List.of(new ABSqrt2Number(a + 1, b), new ABSqrt2Number(a, b + 1));
        }

        @Override
        public int compareTo(ABSqrt2Number o) {
            return Double.compare(value, o.value);
        }

        @Override
        public String toString() {
            return String.format("%s + %s * \u221A2 = %.2f", a, b, value);
        }
    }
}
