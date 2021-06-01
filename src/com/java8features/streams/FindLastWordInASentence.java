package com.java8features.streams;

import java.util.Arrays;
import java.util.Optional;

public class FindLastWordInASentence {

    // Statement: I live in GR city. Its very nice city.
    // last word length = 5
    // I live in ......
    // reduce -> high to low (f, s) -> f

    // intStream of 1, 2, 3, 4, 5, 6.
    // --> 16

    // List<Payment> --> Payment --> amount (BigDecimal)

    // P1 --> 5.0, 6.0



    public static void main(String[] args) {
        System.out.println(find("My name is Rahul.    Yeah     its Rahul."));
        System.out.println(find(null));

        String s = "ab  cd";
        final String[] split = s.split("");


    }

    private static String find(String sentence){
        return Arrays.stream(Optional.ofNullable(sentence)
                .orElseGet(() -> "")
                .split("\\W+")) // break with 1 or more occurrences of white space
                .reduce((f,s) -> s) // reduce first, second to second & so on. In the end, only the last word will remain.
                .get();
    }

}
