package com.leonenko.epi._12_hash_TODO;

import java.util.*;

/**
 * Created by Alex on 5/13/2017.
 */
public class _123_LRU_TODO {

    public static void main(String[] args) {
        int capacity = 3;
        Random random = new Random();

        var lru = new LinkedHashMap<Integer, String>(capacity, 1f, true);

        for (int i = 0; i < 10; i++) {
            int n = random.nextInt(100 + 1);
            lru.put(n, Integer.toString(n));
            System.out.println(lru);
        }

        List<Integer> numbers = new ArrayList<>();

        lru = new LinkedHashMap<>(capacity, 1f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
                int i = numbers.indexOf(eldest.getKey());

                if (i >= 0) {
                    numbers.remove(i);
                }

                return size() > capacity;
            }
        };

        for (int i = 0; i < 10; i++) {
            int n = random.nextInt(100 + 1);
            lru.put(n, Integer.toString(n));
            numbers.add(n);
            System.out.println(lru);
            if (random.nextBoolean()) {
                System.out.println("Get " + lru.get(numbers.get(0)));
            }
        }
    }
}
