package com.coderscampus.assignment;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DataCollector {
    private ExecutorService executorService;

    public DataCollector(int numberOfThreads) {
        executorService = Executors.newFixedThreadPool(numberOfThreads);
    }
    public void collectData(Assignment8 assignment8, List<List<Integer>> numberLists) {
        CountDownLatch latch = new CountDownLatch(1000); // Create a latch to wait for all tasks to complete
        for (int i = 0; i < 1000; i++) {
            final int index = i;
            executorService.execute(() -> {
                System.out.println("Thread " + Thread.currentThread().getId() + " processing request " + index);
                List<Integer> numbers = assignment8.getNumbers();
                synchronized (numberLists) {
                    numberLists.add(numbers);
                }
                latch.countDown(); // Decrease the latch count
            });
        }

        try {
            latch.await(); // Wait for all tasks to complete
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    public void collectData(Assignment8 assignment8, List<List<Integer>> numberLists) {
//        for (int i = 0; i < 1000; i++) {
//            final int index = i;
//            executorService.execute(() -> {
//                System.out.println("Thread " + Thread.currentThread().getId() + " processing request " + index);
//                List<Integer> numbers = assignment8.getNumbers();
//                synchronized (numberLists) {
//                	numberLists.add(numbers);
//                }
//            });
//        }
//    }

    public void shutdown() {
        executorService.shutdown();
    }
}

