package com.datastructures;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Song  {
    public static void main(String[] args) {
        Map<String, Object> concurrentMap = new ConcurrentSkipListMap<>();
        Object oldValue = new Object();
        concurrentMap.put("test", oldValue);
        concurrentMap.put("test1", oldValue);
        concurrentMap.compute("test", (s, o) -> null);

//        System.out.println(concurrentMap.get("test"));
//        System.out.println(concurrentMap.size());

        Singleton s1= Singleton.getSingletonInstance();
        Singleton s2= Singleton.getSingletonInstance();
        Singleton s3= Singleton.getSingletonInstance();

//        System.out.println(s1.hashCode());
//        System.out.println(s2.hashCode());
//        System.out.println(s3.hashCode());


        findDigits(136);
        AtomicInteger atomicInt = new AtomicInteger(0);

        System.out.println("Initial value: " + atomicInt.get());

        atomicInt.incrementAndGet(); // Increment atomically
        System.out.println("After increment: " + atomicInt.get());

        boolean updated = atomicInt.compareAndSet(1, 5); // Compare and update
        System.out.println("Updated successfully? " + updated);
        System.out.println("Final value: " + atomicInt.get());
        System.out.println(findDigits(124));
        System.out.println(findDigits(2));
        System.out.println(findDigits(12));
        System.out.println(findDigits(1012));
    }

    public static int findDigits(int n) {
        // Write your code here
        int counter=0; int original=n;

        while(n>0) {
            int lastdigit = n % 10;

            if (lastdigit != 0 && original % lastdigit == 0) {

                counter++;
            }
            n = n / 10;
        }
        return counter;

    }

}

