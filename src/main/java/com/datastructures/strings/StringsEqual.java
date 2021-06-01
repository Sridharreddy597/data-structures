package com.datastructures.strings;

/**
 * @author sridhar
 *
 *
 *
 *
You are given two strings s1 and s2 of equal length. A string swap is an operation where you choose two indices in a string (not necessarily different) 
and swap the characters at these indices.
Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of the strings. Otherwise, return false.

 Example 1:
Input: s1 = "bank", s2 = "kanb"
Output: true
Explanation: For example, swap the first character with the last character of s2 to make "bank".

Example 2:
Input: s1 = "attack", s2 = "defend"
Output: false
Explanation: It is impossible to make them equal with one string swap.

Example 3:
Input: s1 = "kelb", s2 = "kelb"
Output: true
Explanation: The two strings are already equal, so no string swap operation is required.

Example 4:
Input: s1 = "abcd", s2 = "dcba"
Output: false
 *
 *
 *
 *
 */
public class StringsEqual {

	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean areAlmostEqual(String a, String b) {
		int len1 = a.length();
		int len2 = b.length();

		if (len1 != len2)
			return false;

		int count = 0;
		int[] tempArray = new int[3];
		if (len1 == len2) {
			for (int i = 0; i < len1; i++) {
				if (a.charAt(i) != b.charAt(i)) {
					if (count > 2)
						return false;
					tempArray[count] = i;

					count++;
				}
			}

			if (count == 0 || count == 2)
				return a.charAt(tempArray[0]) == b.charAt(tempArray[1])
						&& a.charAt(tempArray[1]) == b.charAt(tempArray[0]);
		}
		return false;
	}
}
