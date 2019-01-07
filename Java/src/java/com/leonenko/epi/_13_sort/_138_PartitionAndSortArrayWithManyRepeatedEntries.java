package com.leonenko.epi._13_sort;

import java.util.Arrays;
import java.util.Map.Entry;
import java.util.TreeMap;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Created by Alex on 5/12/2017.
 */
public class _138_PartitionAndSortArrayWithManyRepeatedEntries {

    private static void groupPersonsByAge(Person[] persons) {
        var ageCounts = Arrays.stream(persons)
                                  .collect(groupingBy(p -> p.age, counting()));
        var ageIndices = new TreeMap<Integer, Integer>();
        var ageIndex = 0;

        for (Entry<Integer, Long> ageAndCount : ageCounts.entrySet()) {
            ageIndices.put(ageAndCount.getKey(), ageIndex);
            ageIndex += ageAndCount.getValue();
        }

        while (!ageIndices.isEmpty()) {
            var from = ageIndices.firstEntry();
            int fromOffset = from.getValue();
            var toAge = persons[fromOffset].age;
            int toOffset = ageIndices.get(toAge);

            swap(persons, fromOffset, toOffset);

            if (ageCounts.compute(toAge, (k, v) -> v - 1) == 0) {
                ageIndices.remove(toAge);
            } else {
                ageIndices.compute(toAge, (k, v) -> v + 1);
            }
        }
    }

    private static void swap(Person[] persons, int i, int j) {
        Person tmp = persons[i];
        persons[i] = persons[j];
        persons[j] = tmp;
    }

    static final class Person {
        private final String name;
        private final int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return String.format("%s(%s)", name, age);
        }
    }

}
