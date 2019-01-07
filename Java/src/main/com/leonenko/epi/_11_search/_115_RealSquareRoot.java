package com.leonenko.epi._11_search;

public class _115_RealSquareRoot {

    private static final double EPSILON = 0.00001;

    static double squareRoot(double number) {
        var lowNumber = number < 1.0 ? number : 1.0;
        var highNumber = number < 1.0 ? 1.0 : number;

        while (isSmaller(lowNumber, highNumber)) {
            var middleNumber = lowNumber + 0.5 * (highNumber - lowNumber);
            var middleNumberSquared = middleNumber * middleNumber;

            if (isEqual(middleNumberSquared, number)) {
                return middleNumber;
            } else if (isLarger(middleNumberSquared, number)) {
                highNumber = middleNumber;
            } else {
                lowNumber = middleNumber;
            }
        }

        return lowNumber;
    }

    private static boolean isLarger(double numberLeft, double numberRight) {
        return diff(numberLeft, numberRight) > EPSILON;
    }

    private static boolean isEqual(double numberLeft, double numberRight) {
        return !isLarger(numberLeft, numberRight) && !isSmaller(numberLeft, numberRight);
    }

    private static boolean isSmaller(double numberLeft, double highNumber) {
        return diff(numberLeft, highNumber) < -EPSILON;
    }

    private static double diff(double numberLeft, double numberRight) {
        return (numberLeft - numberRight) / numberRight;
    }

}
