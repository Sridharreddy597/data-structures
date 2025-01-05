package com.codinginterview.dxc;

import java.util.LinkedList;
import java.util.Scanner;

public class DXCLuxoftSolution2 {

    public static String LRUCache(String strArr[]) {
        LinkedList<String> cache = new LinkedList<>();
        int capacity = 5;
        for (String item : strArr) {
            // If the item is already in the cache, remove it (to update its position)
            if (cache.contains(item)) {
                cache.remove(item);
            } else if (cache.size() >= capacity) {
                // If the cache is full, remove the least recently used item (first element)
                cache.removeFirst();
            }
            // Add the current item to the end of the cache
            cache.add(item);
        }
        // Join the elements of the cache with hyphens and return as a string
        return String.join("-", cache);
    }

    public static void main(String[] args) {
        // Scanner to read input
        Scanner s = new Scanner(System.in);
        // Read input as a single line and split it into an array
        String[] input = s.nextLine().split(", ");
        // Call the LRUCache function and print the result
        System.out.print(LRUCache(input));
        s.close();
    }
}
