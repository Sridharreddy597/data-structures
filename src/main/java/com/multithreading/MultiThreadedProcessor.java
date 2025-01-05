package com.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadedProcessor {

    public static void main(String[] args){
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        for(int i=0; i<500; i++){
            queue.add("Record "+i);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(25);
        List<Future<String>> futures =  new ArrayList<>();

        for(int i=0; i<500; i++) {
            Callable<String> worker = getCallable(queue);
            futures.add(executorService.submit(worker));
        }
        AtomicInteger taskCounter = new AtomicInteger();

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)){
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
        futures.stream().map(e-> {
            try {
                return e.get();
            } catch (InterruptedException | ExecutionException ex) {
                throw new RuntimeException(ex);
            }
        }).forEach(System.out::println);
    }

    private static Callable<String> getCallable(BlockingQueue<String> queue) {
        ConcurrentHashMap<String, Boolean> processedRecords = new ConcurrentHashMap<>();
        Callable<String> worker = ()->{
          while (!queue.isEmpty() || !Thread.currentThread().isInterrupted()){
              try {
                  String record = queue.poll(100, TimeUnit.MILLISECONDS);
                  if(record!=null && processedRecords.putIfAbsent(record, true)==null){
                      return processRecord(record);
                  } else if(record ==null){
                      break;
                  }
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }
          }
          return "task Completed";
        };
        return worker;
    }

    private static String processRecord(String record) {
        try {
            Thread.sleep(500);
            return Thread.currentThread().getName()+" record is " + record;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return null;
    }
}

