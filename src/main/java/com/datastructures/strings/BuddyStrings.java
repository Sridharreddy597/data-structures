package com.datastructures.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sridhar
 *
 *
 *         Example 1: Input: a = "ab", b = "ba" Output: true Explanation: You
 *         can swap a[0] = 'a' and a[1] = 'b' to get "ba", which is equal to b.
 * 
 *         Example 2: Input: a = "ab", b = "ab" Output: false Explanation: The
 *         only letters you can swap are a[0] = 'a' and a[1] = 'b', which
 *         results in "ba" != b.
 * 
 *         Example 3: Input: a = "aa", b = "aa" Output: true Explanation: You
 *         can swap a[0] = 'a' and a[1] = 'a' to get "aa", which is equal to b.
 * 
 *         Example 4: Input: a = "aaaaaaabc", b = "aaaaaaacb" Output: true
 *
 */
class BuddyStrings {

	
	
	public static void main(String[] args) {
		System.out.println(buddyStrings("ab", "ba"));
		System.out.println(buddyStrings("ab", "ab"));
		System.out.println(buddyStrings("aa", "aa"));
		System.out.println(buddyStrings("aaaaaaabc", "aaaaaaacb"));
	
	}
	
	
	public static boolean buddyStrings(String a, String b) {
		// length of 2 strins should be same
		// char count occurrences shoulb be same & map size should be same

		if (a.length() != b.length() || a.length() < 2 || b.length() < 2)
			return false;

		if (a.length() == b.length()) {
			List<Integer> characterList = new ArrayList<>();
			for (int i = 0; i < a.length(); i++) {
				if (a.charAt(i) != b.charAt(i)) {
					characterList.add(i);
				}
			}
			return (characterList.size() == 2 && a.charAt(characterList.get(0)) == b.charAt(characterList.get(1))
					&& a.charAt(characterList.get(1)) == b.charAt(characterList.get(0)));
			
		}
		if(a.equals(b)) {
			Set<Character> set= new HashSet<>();
			for(char c: a.toCharArray()) { 
			if(set.contains(c))
				set.add(c);
			}
			if(set.size()<a.length())
				return true;
			else  return false;
			
		}
		return false;
	}
}
