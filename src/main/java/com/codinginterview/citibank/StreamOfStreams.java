package com.codinginterview.citibank;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamOfStreams {
	
	
	public static void main(String[] args) {

		Stream<String> s1 = Stream.of("hello", "world", null, "", null, "  ");
		Stream<String> s2 = Stream.of("", "  ", null, "", null, "  ");
		Stream<String> s3 = Stream.empty();

		Stream<Stream<String>> streamOfStreams = Stream.of(s1, null, s2, s3, null, null);
		flat(streamOfStreams).forEach(System.out::println);
		System.out.println(Optional.of(flat(null)).orElseGet(Stream::empty).peek(System.out::println).count());
	}

	public static Stream<String> flat(Stream<Stream<String>> streamofStreams) {

		return Optional.ofNullable(streamofStreams).orElseGet(Stream :: empty)
				.filter(Objects::nonNull) 		//filter null stream
				.flatMap(Function.identity())  // same as stream->stream
				.filter(Objects::nonNull)		// filter null string(s)
				.filter(s -> !s.trim().isEmpty()); //filter blank/empty string(s) 
	}

}
