package com.leonenko.epi._19_parallel_TODO;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Alex on 2/8/2017.
 *
 * http://docs.oracle.com/javase/tutorial/essential/concurrency/deadlock.html
 */
public class Deadlock {

    public static void main(String[] args) {
        List<Integer> src = Collections.synchronizedList(
                IntStream.iterate(0, Math::incrementExact)
                        .limit(5)
                        .boxed()
                        .collect(Collectors.toList())
        );
        List<Integer> dst = Collections.synchronizedList(
                IntStream.iterate(0, Math::incrementExact)
                        .limit(5)
                        .boxed()
                        .collect(Collectors.toList())
        );
        ListCopy c1 = new ListCopy("one", src, dst);
        ListCopy c2 = new ListCopy("two", dst, src);
        new Thread(c1).start();
        new Thread(c2).start();
        sleep(30);
        c1.stop();
        c2.stop();
    }

    private static final class ListCopy implements Runnable {

        private volatile boolean stop;

        private final String name;
        private final List<Integer> src;
        private final List<Integer> dst;

        ListCopy(String name, List<Integer> src, List<Integer> dst) {
            this.name = name;
            this.src = src;
            this.dst = dst;
        }

        @Override
        public void run() {
            int count = 0;
            while (!stop) {
                System.out.println(String.format("%s started copying %s", name, count));
                dst.addAll(src);
                src.clear();
                dst.clear();
                System.out.println(String.format("%s finished copying %s", name, count));
                count++;
                // sleep(2);
            }
        }

        void stop() {
            stop = true;
        }
    }

    private static void sleep(int seconds) {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(seconds));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
