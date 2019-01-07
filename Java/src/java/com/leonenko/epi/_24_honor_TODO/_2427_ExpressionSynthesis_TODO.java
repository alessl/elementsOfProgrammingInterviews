package com.leonenko.epi._24_honor_TODO;

import java.util.*;

public class _2427_ExpressionSynthesis_TODO {

    static Optional<String> synthesizeExpression(String stringOfDigits, int target) {
        int[] digits = stringOfDigits.chars()
                                     .map(Character::getNumericValue)
                                     .toArray();
        return synthesizeExpression(digits, target);
    }

    static Optional<String> synthesizeExpression(int[] digits, int target) {
        var opds = new ArrayList<Integer>();
        var ops = new ArrayList<Character>();

        if (synthesizeExpression(digits, target, 0, 0, opds, ops)) {
            return createExpr(opds, ops);
        }

        return Optional.empty();
    }

    private static Optional<String> createExpr(ArrayList<Integer> opds, ArrayList<Character> ops) {
        var expr = new StringBuilder();

        var opd = 0;
        var op = 0;

        while (opd < opds.size()) {
            expr.append(opds.get(opd++));

            if (op < ops.size()) {
                expr.append(ops.get(op++));
            }
        }

        return Optional.of(expr.toString());
    }

    private static boolean synthesizeExpression(int[] digits,
                                                int target,
                                                int prevTerm,
                                                int digitIdx,
                                                List<Integer> opds,
                                                List<Character> ops) {
        var currTerm = prevTerm * 10 + digits[digitIdx];

        if (digitIdx == digits.length - 1) {
            opds.add(currTerm);
            if (evaluate(opds, ops) == target) {
                return true;
            }
            opds.remove(opds.size() - 1);
            return false;
        }

        // no operator
        if (synthesizeExpression(digits, target, currTerm, digitIdx + 1, opds, ops)) {
            return true;
        }

        opds.add(currTerm);

        // '*' operator
        ops.add('*');
        if (synthesizeExpression(digits, target, 0, digitIdx + 1, opds, ops)) {
            return true;
        }
        ops.remove(ops.size() - 1);

        // '+' operator
        if (target - evaluate(opds, ops) <= remainingInt(digits, digitIdx + 1)) {
            ops.add('+');
            if (synthesizeExpression(digits, target, 0, digitIdx + 1, opds, ops)) {
                return true;
            }
            ops.remove(ops.size() - 1);
        }

        opds.remove(opds.size() - 1);

        return false;
    }

    private static int remainingInt(int[] digits, int startIndex) {
        var val = 0;
        for (int j = startIndex; j < digits.length; j++) {
            val = val * 10 + digits[j];
        }
        return val;
    }

    private static int evaluate(List<Integer> opds, List<Character> ops) {
        int opdIdx = 0;
        var interimOpds = new LinkedList<>(Collections.singletonList(opds.get(opdIdx++)));

        for (char op : ops) {
            if (op == '*') {
                int interimOpd = interimOpds.removeFirst() * opds.get(opdIdx++);
                interimOpds.addFirst(interimOpd);
            } else {
                interimOpds.addFirst(opds.get(opdIdx++));
            }
        }

        int sum = 0;
        while (!interimOpds.isEmpty()) {
            sum += interimOpds.removeFirst();
        }

        return sum;
    }
}
