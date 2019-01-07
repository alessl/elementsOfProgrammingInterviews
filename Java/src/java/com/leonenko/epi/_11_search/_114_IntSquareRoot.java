package com.leonenko.epi._11_search;

public class _114_IntSquareRoot {

    static int squareRootOf(int number) {
        var lowNumber = 0;
        var highNumber = number;

        while (lowNumber <= highNumber) {
            var middleNumber = lowNumber + (highNumber - lowNumber) / 2;
            var middleNumberSquared = middleNumber * middleNumber;

            if (middleNumberSquared <= number) {
                lowNumber = middleNumber + 1;
            } else {
                highNumber = middleNumber - 1;
            }
        }

        return lowNumber - 1;
    }
}
