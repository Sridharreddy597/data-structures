package com.multithreading;

import java.util.concurrent.ExecutorService;
    import java.util.concurrent.Executors;
    import java.util.concurrent.atomic.AtomicInteger;

    public class AtomicIntegerExample {
        private static AtomicInteger counter = new AtomicInteger(0);

        public static void main(String[] args) {
//            Runnable task = () -> System.out.println(Thread.currentThread().getName() + " - " + counter.incrementAndGet());
//            try (ExecutorService executorService = Executors.newFixedThreadPool(5)) {
//                for(int i=0; i< 100; i++) {
//                    executorService.submit(task);
//                }
//            }
        }
    }

