package com.leonenko.epi._15_rec;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SudokuBoardGenerator {

    private static final Random RAND = new Random();

    public static int[][] generateZeroedSudokuBoard(int regionSize) {
        return generateSudokuBoard(regionSize, SudokuBoardGenerator::fillZeroRegionRandom);
    }

    public static int[][] generateSolvableSudokuBoard(int regionSize) {
        int[][] sudokuBoard = generateSudokuBoard(regionSize,
                SudokuBoardGenerator::fillRegionRandom);

        printSudokuBoard(sudokuBoard);

        makeSolvable(sudokuBoard, regionSize);

        return sudokuBoard;
    }

    private static void makeSolvable(int[][] sudokuBoard, int regionSize) {
        var digitsUsedBefore = new ArrayList<List<Integer>>();

        for (int i = 0; i < sudokuBoard.length; i++) {
            digitsUsedBefore.add(IntStream.iterate(0, z -> z)
                    .limit(sudokuBoard.length)
                    .boxed()
                    .collect(Collectors.toList()));

            for (int j = 0; j < sudokuBoard[i].length; j++) {
                var currDigit = sudokuBoard[i][j];

                if (currDigit == 0) {
                    continue;
                }

                var wasUsedInCurrRow = digitsUsedBefore.get(i).stream()
                        .limit(j)
                        .anyMatch(d -> d == currDigit);

                var fromCol = j / regionSize * regionSize;
                var toCol = fromCol + regionSize;
                var wasUsedInCurrRegion = digitsUsedBefore.stream()
                        .limit(i)
                        .anyMatch(r -> r.subList(fromCol, toCol).stream()
                                .anyMatch(d -> d == currDigit));

                var col = j;
                var wasUsedInCurrCol = digitsUsedBefore.stream()
                        .limit(i)
                        .anyMatch(r -> r.get(col)  == currDigit);

                if (wasUsedInCurrCol || wasUsedInCurrRow || wasUsedInCurrRegion) {
                    sudokuBoard[i][j] = 0;
                } else {
                    digitsUsedBefore.get(i).set(j, currDigit);
                }
            }
        }
    }

    public static int[][] generateCorrectlySolvedSudokuBoard(int regionSize) {
        return generateSudokuBoard(regionSize, SudokuBoardGenerator::fillRegionSpiralClockWise);
    }

    public static int[][] generateIncorrectlySolvedSudokuBoard(int regionSize) {
        return generateSudokuBoard(regionSize, SudokuBoardGenerator::fillRegionRandom);
    }

    public static void printSudokuBoard(int[][] board) {
        Arrays.stream(board)
                .map(Arrays::toString)
                .forEach(System.out::println);
        System.out.println();
    }

    private static int[][] generateSudokuBoard(int regionSize, RegionFiller regionFiller) {
        var boardSize = (int) Math.pow(regionSize, 2);
        var board = new int[boardSize][boardSize];

        for (int rowStart = 0; rowStart < board.length; rowStart += regionSize) {
            for (int colStart = 0; colStart < board.length; colStart += regionSize) {
                regionFiller.fillRegion(board, rowStart, colStart, regionSize);
            }
        }

        return board;
    }

    private static void fillRegionRandom(int[][] board,
            int rowStart, int colStart, int regionSize) {

        var values = IntStream
                .range(1, regionSize * regionSize + 1)
                .boxed()
                .collect(Collectors.toSet());

        for (var row = rowStart; row < rowStart + regionSize; row++) {
            for (var col = colStart; col < colStart + regionSize; col++) {
                if (RAND.nextBoolean()) {
                    board[row][col] = 1 + RAND.nextInt(values.size());
                    values.remove(board[row][col]);
                }
            }
        }
    }

    private static void fillZeroRegionRandom(int[][] board,
            int rowStart, int colStart, int regionSize) {

        for (int row = rowStart; row < rowStart + regionSize; row++) {
            for (int col = colStart; col < colStart + regionSize; col++) {
                if (RAND.nextBoolean()) {
                    board[row][col] = 0;
                }
            }
        }
    }

    private static void fillRegionSimple(
            int[][] board, int rowStart, int colStart, int regionSize) {
        int value = 1;
        for (int row = rowStart; row < rowStart + regionSize; row++) {
            for (int col = colStart; col < colStart + regionSize; col++) {
                board[row][col] = value++;
            }
        }
    }

    private static void fillRegionSpiralClockWise(
            int[][] board, int rowStart, int colStart, int regionSize) {
        int value = 1;

        int top = rowStart;
        int right = colStart + regionSize - 1;
        int bottom = rowStart + regionSize - 1;
        int left = colStart;

        for (int layer = 0; layer <= regionSize / 2; layer++) {
            for (int col = left; col <= right; col++) {
                board[top][col] = value++;
            }
            top++;
            for (int row = top; row <= bottom; row++) {
                board[row][right] = value++;
            }
            right--;
            for (int col = right; col >= left; col--) {
                board[bottom][col] = value++;
            }
            bottom--;
            for (int row = bottom; row >= top; row--) {
                board[row][left] = value++;
            }
            left++;
        }
    }

    private static void fillRegionSpiralCounterClockWise(
            int[][] board, int rowStart, int colStart, int regionSize) {
        int value = 1;

        int top = rowStart;
        int right = colStart + regionSize - 1;
        int bottom = rowStart + regionSize - 1;
        int left = colStart;

        for (int layer = 0; layer <= regionSize / 2; layer++) {
            for (int row = top; row <= bottom; row++) {
                board[row][left] = value++;
            }
            left++;
            for (int col = left; col <= right; col++) {
                board[bottom][col] = value++;
            }
            bottom--;
            for (int row = bottom; row >= top; row--) {
                board[row][right] = value++;
            }
            right--;
            for (int col = right; col >= left; col--) {
                board[top][col] = value++;
            }
            top++;
        }
    }

    interface RegionFiller {
        void fillRegion(int[][] board, int rowStart, int colStart, int regionSize);
    }


}
