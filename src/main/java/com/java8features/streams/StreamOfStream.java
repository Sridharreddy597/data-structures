package com.java8features.streams;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamOfStream {

    public static void main(String[] args) {
//        Stream<String> s1 = Stream.of("hello", "word", null, null, "", "   ", null);
//        Stream<String> s2 = Stream.of(null, null, "", "   ", null);
//        Stream<String> s3 = Stream.empty();
//        Stream<Stream<String>> streamOfStreams = Stream.of(s1, null, s2, s3, null, null);
//        System.out.println(flat(streamOfStreams).peek(System.out::println).count());
//        System.out.println(flat(null).peek(System.out::println).count());

        System.out.println(getLatestVersion("1.0.0", "1.0.1")); // Output: 1.0.1
        System.out.println(getLatestVersion("1.0", "1.0.0"));   // Output: 1.0.0
        System.out.println(getLatestVersion("2.5.1", "2.4.10")); // Output: 2.5.1
        System.out.println(getLatestVersion("3", "3.0.0.0"));   // Output: 3.0.0.0
        System.out.println(getLatestVersion("1.0.10", "1.0.2")); // Output: 1.0.10
    }

    public static Stream<String> flat(Stream<Stream<String>> streamOfStreams) {
        return Optional.ofNullable(streamOfStreams)
                .orElseGet(() -> Stream.empty())
                .filter(Objects::nonNull) // filter null Stream
                .flatMap(Function.identity())// same as stream -> stream
                .filter(Objects::nonNull) // filter null String(s)
                .filter(s -> !s.trim().isEmpty()); // filter blank/empty String(s)
    }


    public static String getLatestVersion(String version1, String version2) {
        // Split the versions by "." to compare subversions
        String[] v1Parts = version1.split("\\.");
        String[] v2Parts = version2.split("\\.");

        // Find the maximum length to iterate through both versions
        int maxLength = Math.max(v1Parts.length, v2Parts.length);

        for (int i = 0; i < maxLength; i++) {
            // Parse each subversion; if not present, default to 0
            int v1 = i < v1Parts.length ? Integer.parseInt(v1Parts[i]) : 0;
            int v2 = i < v2Parts.length ? Integer.parseInt(v2Parts[i]) : 0;

            // Compare subversions
            if (v1 > v2) {
                return version1;
            } else if (v2 > v1) {
                return version2;
            }
        }

        // If all subversions are equal, return either (versions are the same)
        return version1; // or version2 (since they're equal)
    }
}
