package com.multithreading;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExample {

    static int[] numbers = new int[1000];
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            numbers[i] = i+1;
        }
        ForkJoinPool fjp = new ForkJoinPool();
        Long sum = fjp.invoke(new SumTask(0,1000, numbers));
        System.out.println("sum is "+ sum);
    }
}

class SumTask extends RecursiveTask<Long> {

    int start;
    int end;
    int[] numbers;
    static final int THRESHOLD =100;

    public SumTask(int start, int end, int[] numbers){
        this.start=start;
        this.end=end;
        this.numbers=numbers;
    }
    @Override
    protected Long compute() {
        if(end-start<=100){
            Long sum= 0L;
            for(int i=start; i<end;i++){
                sum+=numbers[i];
            }
            return sum;

        }else{
            int mid = (this.end+this.start)/2;
            SumTask leftTask = new SumTask(start, mid, numbers);
            SumTask rightTask = new SumTask(mid, end, numbers);

            leftTask.fork();
            rightTask.fork();

           Long left =  leftTask.join();
            Long right = rightTask.join();
            return left+right;
        }
    }
}

