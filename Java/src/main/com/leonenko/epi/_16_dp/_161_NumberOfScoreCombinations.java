package com.leonenko.epi._16_dp;

import java.util.*;

public class _161_NumberOfScoreCombinations {

    static List<List<Integer>> listUniqueScoreCombinations(int totalScore, int[] scores) {
        return listCombinations(totalScore, scores, 0, new LinkedList<>(), new ArrayList<>());
    }

    static List<List<Integer>> listCombinations(int totalScore,
                                                int[] scores,
                                                int scoreIndex,
                                                Deque<Integer> combination,
                                                List<List<Integer>> allCombinations) {
        if (totalScore == 0) {
            allCombinations.add(List.copyOf(combination));
            return allCombinations;
        }
        if (totalScore < 0 || scoreIndex == scores.length) {
            return allCombinations;
        }

        var tempTotalScore = totalScore;

        while (tempTotalScore >= 0) {
            combination.addLast(scores[scoreIndex]);
            tempTotalScore -= scores[scoreIndex];

            listCombinations(tempTotalScore, scores, scoreIndex + 1, combination, allCombinations);
        }

        while (tempTotalScore < totalScore) {
            combination.removeLast();
            tempTotalScore += scores[scoreIndex];
        }

        listCombinations(totalScore, scores, scoreIndex + 1, combination, allCombinations);

        return allCombinations;
    }

    static int countUniqueScoreCombinations(int totalScore, int[] scores) {
        return countCombinations(totalScore, scores, 0);
    }

    static int countCombinations(int totalScore, int[] scores, int scoreIndex) {
        if (totalScore == 0) {
            return 1;
        }
        if (totalScore < 0 || scoreIndex == scores.length) {
            return 0;
        }

        var combinationsCount = 0;
        var tempTotalScore = totalScore;

        while (tempTotalScore >= 0) {
            tempTotalScore -= scores[scoreIndex];
            combinationsCount += countCombinations(tempTotalScore, scores, scoreIndex + 1);
        }
        combinationsCount += countCombinations(totalScore, scores, scoreIndex + 1);

        return combinationsCount;
    }

    static int countCombinationsDP(int totalScore, int[] scores) {
        return computeDP(totalScore, scores)[scores.length][totalScore];
    }

    private static int[][] computeDP(int totalScore, int[] scores) {
        int[][] combinationsCount = new int[scores.length + 1][totalScore + 1];

        Arrays.stream(combinationsCount).forEach(row -> row[0] = 1);

        for (var i = 1; i <= scores.length; i++) {
            var score = scores[i - 1];

            for (int j = 1; j <= totalScore; j++) {
                combinationsCount[i][j] = combinationsCount[i - 1][j];

                if (j - score >= 0) {
                    combinationsCount[i][j] += combinationsCount[i][j - score];
                }
            }
        }

        Arrays.stream(combinationsCount).forEach(row -> System.out.println(Arrays.toString(row)));

        return combinationsCount;
    }
}
