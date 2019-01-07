package com.leonenko.epi._13_sort;

import java.util.List;

import static java.util.Comparator.naturalOrder;

public class _1311_SalaryThreshold {

    static double findSalaryCap(double targetPayroll, List<Double> currentSalaries) {
        currentSalaries.sort(naturalOrder());

        double unadjastedSalarySum = 0;
        for (int i = 0; i < currentSalaries.size(); i++) {
            double adjustedSalarySum = currentSalaries.get(i) * (currentSalaries.size() - 1);
            if (unadjastedSalarySum + adjustedSalarySum >= targetPayroll) {
                return (targetPayroll - unadjastedSalarySum) / (currentSalaries.size() - 1);
            }
            unadjastedSalarySum += currentSalaries.get(i);
        }
        return -1.0;
    }
}
