package com.leonenko.myinterview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Alex on 4/20/2017.
 */
public class ListPrefix {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
        int[] numsInArray = nums.stream().mapToInt(i -> i).toArray();
        int[] index = new int[1];
        List<Integer> pref = nums
                .stream()
                .collect(
                        () -> nums,
                        (result, value) -> {
                            if (index[0] == 0) {
                                result.set(0, value);
                            } else {
                                result.set(index[0], result.get(index[0] - 1) + value);
                            }
                            index[0]++;
                        },
                        (result1, result2) -> {}
        );
        System.out.println("nums=" + nums);
        System.out.println("pref=" + pref);

        IntStream
                .range(0, numsInArray.length)
                .map(i -> i > 0 ? numsInArray[i] += numsInArray[i - 1] : numsInArray[i])
                .forEach(System.out::println);


    }
}
