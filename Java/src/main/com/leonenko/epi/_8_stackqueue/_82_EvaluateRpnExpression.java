package com.leonenko.epi._8_stackqueue;

import java.util.LinkedList;
import java.util.function.BinaryOperator;

public class _82_EvaluateRpnExpression {

    private static final String SPACE = " ";
    private static final String ADD = "+";
    private static final String SUBTRACT = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";

    static int evaluateExpression(String expression) {
        var operandStack = new LinkedList<Integer>();

        for (String c : expression.split(SPACE)) {
            switch (c) {
                case ADD:
                case SUBTRACT:
                case MULTIPLY:
                case DIVIDE:
                    var rightOperand = operandStack.pop();
                    var leftOperand = operandStack.pop();
                    var operationResult = evaluateOperation(c, leftOperand, rightOperand);

                    operandStack.push(operationResult);

                    break;
                default:
                    operandStack.push(Integer.parseInt(c));

                    break;
            }
        }

        return operandStack.pop();
    }

    private static int evaluateOperation(String action, int leftOp, int rightOp) {
        switch (action) {
            case SUBTRACT:
                return evaluateOperation(Math::subtractExact, leftOp, rightOp);
            case ADD:
                return evaluateOperation(Math::addExact, leftOp, rightOp);
            case MULTIPLY:
                return evaluateOperation(Math::multiplyExact, leftOp, rightOp);
            case DIVIDE:
                return evaluateOperation(Math::floorDiv, leftOp, rightOp);
            default:
                throw new UnsupportedOperationException("Unknown operator: " + action);
        }
    }

    private static int evaluateOperation(BinaryOperator<Integer> action, int leftOp, int rightOp) {
        return action.apply(leftOp, rightOp);
    }
}
