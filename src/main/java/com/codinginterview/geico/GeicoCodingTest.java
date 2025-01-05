package com.codinginterview.geico;

import java.util.*;

public class GeicoCodingTest {


    public static void main(String[] args) {
        int[] input= new int[]{5,3,8,1,8,7,7,6};
//        System.out.println(4== solution(9, new int[]{5,3,8,1,8,7,7,6}));
//        System.out.println(5==solution(7, new int[]{17, 6, 5, 2, 7, 4, 5, 4}));
//        System.out.println(0==solution(7, new int[]{3, 4, 3, 1}));
//        System.out.println(0==solution(7, new int[]{1}));
//        System.out.println(0==solution(7,  new int[]{1, 1, 1, 1, 1}));
//        System.out.println(4==solution(5,  new int[]{5, 5, 5, 5, 5}));
//        System.out.println(lengthOfLongestSubstring("dvdf"));

//        System.out.println(Arrays.toString(subarraySum(new int[]{15, 2, 4, 8, 9, 5, 10, 23}, 23)));
//        System.out.println(Arrays.toString(subarraySum(new int[]{1, 4, 0, 0, 3, 10, 5}, 7)));
//        System.out.println(Arrays.toString(subarraySum(new int[]{1, 4}, 0)));
//        System.out.println(findSmallestSubstring("aabcbcdbca"));
//        System.out.println(findSmallestSubstring("aaab"));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6}, 3)));
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>(); //p w
        int left=0, right=0, longest=0; //1, (1,2)->2, (2,2)->2,
//p  wL  w  kR  e  w
//0    1  2  3  4  5
        for (right = 0; right < s.length(); right++) {
            while(left<right && set.contains(s.charAt(right))){
                set.remove(s.charAt(right));
                left++;
            }
            set.add(s.charAt(right));
            longest = Math.max(longest,right-left+1);
        }
        return longest;
    }

    public static int[] subarraySum(int[] nums, int k) {

//        Input: arr[] = { 15, 2, 4, 8, 9, 5, 10, 23}, sum = 23
//        Output: 2 5
//        Explanation: Sum of elements between indices 2 and 5 is 2 + 4 + 8 + 9 = 23
//
//        Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
//        Output: 2 5
//        Explanation: Sum of elements between indices 2 and 5 is 4 + 0 + 0 + 3 = 7
//
//        Input: arr[] = {1, 4}, sum = 0
//        Output: -1
//        Explanation: There is no subarray with 0 sum

        int left=0, counter=0, sum=0;
        int [] result = new int[2];
        for(int right=0; right<nums.length;right++){
            sum = sum + nums[right];
            while(left<=right && sum>=k){
                if(sum==k){
                    result[0]=left+1;
                    result[1]=right+1;
                    return result;
                }
                sum = sum-nums[left];
                left++;
            }
        }
        return result;

    }

    public static String findSmallestSubstring(String s) {
//        Input: aabcbcdbca
//        Output: dbca
//        Explanation:
//        Possible substrings= {aabcbcd, abcbcd,bcdbca, dbca....} Of the set of possible substrings 'dbca'
//        is the shortest substring having all the distinct characters of given string.
//
//        Input: aaab
//        Output: ab
//        Explanation:
//        Possible substrings={aaab, aab, ab} Of the set of possible substrings 'ab'
//        is the shortest substring having all the distinct characters of given string.

        Set<Character> set = new HashSet<>();
        int left=0, right=0, longest=0;
        for (right = 0; right < s.length(); right++) {
            while(left<right && set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
//            if(longest>(right-left+1)){
//                longest = longest;
//            } else{
//                longest=right-left+1;
//            }
        }
        return s.substring(left,right);
    }



        public static int[] maxSlidingWindow(int[] nums, int k) {

//            Input: arr[] = [1, 2, 3, 1, 4, 5, 2, 3, 6], k = 3
//            Output: [3, 3, 4, 5, 5, 5, 6]
//            Explanation:
//            1st contiguous subarray = [1 2 3] max = 3
//            2nd contiguous subarray = [2 3 1] max = 3
//            3rd contiguous subarray = [3 1 4] max = 4
//            4th contiguous subarray = [1 4 5] max = 5
//            5th contiguous subarray = [4 5 2] max = 5
//            6th contiguous subarray = [5 2 3] max = 5
//            7th contiguous subarray = [2 3 6] max = 6
//            Input: arr[] = [8, 5, 10, 7, 9, 4, 15, 12, 90, 13], k = 4
//            Output: [10, 10, 10, 15, 15, 90, 90]
//            Explanation:
//            1st contiguous subarray = [8 5 10 7], max = 10
//            2nd contiguous subarray = [5 10 7 9], max = 10
//            3rd contiguous subarray = [10 7 9 4], max = 10
//            4th contiguous subarray = [7 9 4 15], max = 15
//            5th contiguous subarray = [9 4 15 12], max = 15
//            6th contiguous subarray = [4 15 12 90], max = 90
//            7th contiguous subarray = [15 12 90 13], max = 90
//            Input: arr[] = [5, 1, 3, 4, 2, 6], k = 1
//            Output: [5, 1, 3, 4, 2, 6]
//            Explanation:
//            When k = 1, each element in the array is its own subarray, so the output is simply the same array
            if (nums == null || nums.length == 0 || k <= 0) {
                return new int[0];
            }

            int n = nums.length;
            int[] result = new int[n - k + 1];
            Deque<Integer> deque = new ArrayDeque<>(); // Store indices of array elements

            for (int i = 0; i < n; i++) {
                // Remove indices that are out of the current window
                if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                    deque.pollFirst();
                }

                // Remove indices whose corresponding values are less than nums[i]
                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                    deque.pollLast();
                }

                // Add the current index
                deque.offerLast(i);

                // Add the maximum value of the current window to the result
                if (i >= k - 1) {
                    result[i - k + 1] = nums[deque.peekFirst()];
                }
            }

            return result;
        }

}
