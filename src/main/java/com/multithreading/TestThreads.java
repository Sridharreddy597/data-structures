package com.multithreading;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class TestThreads {
    public  static void main(String[] args){
//        Thread t = new MyThread() {
//            @Override
//            public void run() {
//                System.out.print(" foof");
//            }
//        };
//        t.start();

        System.out.println(countPairs(Arrays.asList(1,1,2,5,5,9,3,3,11), 10));

    }

    static int countPairs(List<Integer> numbers, int k) {


// Write your code here
        int count = 0, j;
        Set<Integer> numbersSet = new LinkedHashSet<>(numbers);
        System.out.println(Arrays.toString(numbersSet.toArray()));
        for(int i : numbersSet) {
            j = i + k;
            if(numbersSet.contains(j))
                count++;
        }
        return count;
    }
    
}
