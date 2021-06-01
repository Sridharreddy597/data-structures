package com.java8features.streams;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamOfStream {

    public static void main(String[] args) {
        Stream<String> s1 = Stream.of("hello", "word", null, null, "" , "   ", null);
        Stream<String> s2 = Stream.of(null, null, "" , "   ", null);
        Stream<String> s3 = Stream.empty();
        Stream<Stream<String>> streamOfStreams = Stream.of(s1, null, s2, s3, null, null);
        System.out.println(flat(streamOfStreams).peek(System.out::println).count());
        System.out.println(flat(null).peek(System.out::println).count());
    }

    public static Stream<String> flat(Stream<Stream<String>> streamOfStreams){
        return Optional.ofNullable(streamOfStreams)
                .orElseGet(() -> Stream.empty())
                .filter(Objects::nonNull) // filter null Stream
                .flatMap(Function.identity())// same as stream -> stream
                .filter(Objects::nonNull) // filter null String(s)
                .filter(s -> !s.trim().isEmpty()); // filter blank/empty String(s)
    }
}
