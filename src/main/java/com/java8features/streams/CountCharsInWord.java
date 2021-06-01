package com.java8features.streams;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountCharsInWord {


    // palindrome --> madam >> odd / even
    // m = 2 , a = 2 , d = 1
    // hard --> does any permutation of the work is a palindrome??
    // Trie Data structure
    public static void main(String[] args) {
        System.out.println(new CountCharsInWord().frequencyOfChars("apple"));
//        String s = "abc";
//        int len = s.length();



    }



    public   Map<Character, Long> frequencyOfChars(String word){
        return Optional.ofNullable(word)
                .orElseGet(() -> "")
                .chars() // 100, 102...
                // stream if City -> stream of Districts
                // U -> U, U -> V
                .mapToObj(i -> (char)i) // a, p, p, l, e
                // map
                // flatMap
                // mapToObj
                // a = 1, p = 2,
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

//                .chars()
//                .mapToObj(c -> (char) c) // mapToObj is opposite of boxed()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

}

