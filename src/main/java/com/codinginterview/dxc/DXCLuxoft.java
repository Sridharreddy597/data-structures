package com.codinginterview.dxc;

import java.util.*;

public class DXCLuxoft {

    public static int MatchingCharacters(String str) {
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int maxUniqueCount = 0;

        // Iterate through the string
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            // If the character was seen before
            if (charIndexMap.containsKey(currentChar)) {
                // Get the starting index of this pair
                int startIndex = charIndexMap.get(currentChar);

                // Extract the substring between the pair of matching characters
                String substring = str.substring(startIndex + 1, i);

                // Count unique characters in this substring using a Set
                Set<Character> uniqueChars = new HashSet<>();
                for (char c : substring.toCharArray()) {
                    uniqueChars.add(c);
                }

                // Update the maximum unique count
                maxUniqueCount = Math.max(maxUniqueCount, uniqueChars.size());
            } else {
                // Store the first occurrence of this character
                charIndexMap.put(currentChar, i);
            }
        }

        return maxUniqueCount;
    }

    public static void main(String[] args) {
        // Keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.println(MatchingCharacters(s.nextLine()));
    }
}
