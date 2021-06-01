package com.datastructures.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicates {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> numbers = Arrays.asList("1","4","4","2","34","23");
		Set<String> set= new HashSet<>();
		
		Set<String> result= numbers.stream().filter(s->!set.add(s)).collect(Collectors.toSet());
		result.forEach(System.out::println);
		
		 // 3, 4, 9
        List<Integer> list = Arrays.asList(5, 3, 4, 1, 3, 7, 2, 9, 9, 4);
        
//        list.stream().
		
	}

}
