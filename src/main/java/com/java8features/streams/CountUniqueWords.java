package com.java8features.streams;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountUniqueWords {

    public static void main(String[] args) {
        final Map<String, Long> stats = new CountUniqueWords().stats(
                Arrays.asList("cAt", "caT", "rat", "hat", "bat", "rat", null, null, "  ", "", ""));
        System.out.println(stats);
    }

    public Map<String, Long> stats(List<String> words){
        return Optional.ofNullable(words)
                .orElseGet(() -> Collections.emptyList())
                .stream()
                .map(w -> StringUtils.trimToEmpty(w).toUpperCase())
                .filter(StringUtils::isNotEmpty)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

}
