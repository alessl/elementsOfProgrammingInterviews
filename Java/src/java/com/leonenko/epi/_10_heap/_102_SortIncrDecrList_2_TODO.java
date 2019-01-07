package com.leonenko.epi._10_heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by Alex on 5/2/2017.
 */
public class _102_SortIncrDecrList_2_TODO {

    public static void main(String[] args) {
        List<Integer> incDecList = generateIncDecList(3);
        System.out.println(incDecList);
        List<List<Integer>> splits = split(incDecList);
        splits.forEach(System.out::println);
    }

    private static List<List<Integer>> split(List<Integer> list) {
        List<List<Integer>> lists = new ArrayList<>();
        int start = 0;
        boolean increasing = true;
        for (int end = 1; end <= list.size(); end++) {
            if ((end == list.size() || list.get(end - 1) >= list.get(end))
                    && increasing) {
                lists.add(list.subList(start, end));
                start = end;
                increasing = false;
            } else if ((end == list.size() || list.get(end - 1) <= list.get(end))
                    && !increasing) {
                lists.add(list.subList(start, end));
                Collections.reverse(lists.get(lists.size() - 1));
                start = end;
                increasing = true;
            }
        }
        return lists;
    }

    private static List<Integer> generateIncDecList(int k) {
        Random r = new Random();
        List<Integer> increaseDecrease = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            IntStream
                    .iterate(r.nextInt(100 + 1), Math::incrementExact)
                    .limit(1 + r.nextInt(10))
                    .forEach(increaseDecrease::add);
            IntStream
                    .iterate(r.nextInt(100 + 1), Math::decrementExact)
                    .limit(1 + r.nextInt(10))
                    .forEach(increaseDecrease::add);
        }
        return increaseDecrease;
    }

}
