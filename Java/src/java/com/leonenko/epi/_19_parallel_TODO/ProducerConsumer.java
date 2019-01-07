package com.leonenko.epi._19_parallel_TODO;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Alex on 2/8/2017.
 */
public class ProducerConsumer {

    private static final Queue<Integer> RANDOM_NUMBERS = new LinkedList<>();
    private static final int WORKER_SLEEP_SECONDS = 2;
    private static final int MAIN_SLEEP_SECONDS = 30;

    private static final Lock LOCK = new ReentrantLock();
    private static final Condition NOT_FULL = LOCK.newCondition();
    private static final Condition NOT_EMPTY = LOCK.newCondition();

    public static void main(String[] args) {
        Producer producerTask = new Producer();
        Thread producer = new Thread(producerTask);
        producer.start();

        Consumer consumerTask = new Consumer();
        Thread consumer = new Thread(consumerTask);
        consumer.start();

        sleep(MAIN_SLEEP_SECONDS);

        producerTask.stop();
        consumerTask.stop();

    }

    private static final class Producer implements Runnable {

        private volatile boolean stop = false;

        private static final Random R = new Random();
        private static final int BOUND = 1000;

        @Override
        public void run() {
            System.out.println("Producer started");
            while (!stop) {
                try {
                    LOCK.lock();
                    while (RANDOM_NUMBERS.size() > 10) {
                        NOT_FULL.awaitUninterruptibly();
                    }
                    RANDOM_NUMBERS.add(R.nextInt(BOUND));
                    NOT_EMPTY.signal();
                } finally {
                    LOCK.unlock();
                }
                sleep(WORKER_SLEEP_SECONDS);
            }
            System.out.println("Producer stopped");
        }

        void stop() {
            stop = true;
        }
    }

    private static final class Consumer implements Runnable{

        private volatile boolean stop = false;

        @Override
        public void run() {
            System.out.println("Consumer started");
            while (!stop) {
                try {
                    LOCK.lock();
                    while (RANDOM_NUMBERS.isEmpty()) {
                        NOT_EMPTY.awaitUninterruptibly();
                    }
                    System.out.println(RANDOM_NUMBERS.remove());
                    NOT_FULL.signal();
                } finally {
                    LOCK.unlock();
                }
                sleep(WORKER_SLEEP_SECONDS);
            }
            System.out.println("Consumer stopped");
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
