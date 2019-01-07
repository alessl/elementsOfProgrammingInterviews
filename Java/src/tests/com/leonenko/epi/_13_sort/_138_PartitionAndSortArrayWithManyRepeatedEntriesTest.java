package com.leonenko.epi._13_sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class _138_PartitionAndSortArrayWithManyRepeatedEntriesTest {

    public static void main(String[] args) {
        _138_PartitionAndSortArrayWithManyRepeatedEntries.Person[] persons = {
                new _138_PartitionAndSortArrayWithManyRepeatedEntries.Person("P1", 28),
                new _138_PartitionAndSortArrayWithManyRepeatedEntries.Person("P2", 25),
                new _138_PartitionAndSortArrayWithManyRepeatedEntries.Person("P3", 30),
                new _138_PartitionAndSortArrayWithManyRepeatedEntries.Person("P4", 28),
                new _138_PartitionAndSortArrayWithManyRepeatedEntries.Person("P5", 25),
                new _138_PartitionAndSortArrayWithManyRepeatedEntries.Person("P6", 30),
                new _138_PartitionAndSortArrayWithManyRepeatedEntries.Person("P7", 30),
        };
        System.out.println(Arrays.toString(persons));
//        groupPersonsByAge(persons);
        System.out.println(Arrays.toString(persons));
    }

    @Test
    void name() {

    }
}