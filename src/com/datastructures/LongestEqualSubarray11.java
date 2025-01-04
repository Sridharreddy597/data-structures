package src.com.datastructures;

import java.util.*;

public class LongestEqualSubarray11 {
    public static int longestEqualSubarray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0, prefixSum = 0;

        map.put(0, -1); // Handle edge case for full array

        for (int i = 0; i < nums.length; i++) {
            prefixSum += (nums[i] == 0 ? -1 : 1);

            if (map.containsKey(prefixSum)) {
                maxLength = Math.max(maxLength, i - map.get(prefixSum));
            } else {
                map.put(prefixSum, i);
            }
        }
        return maxLength;
    }

    public static boolean isPalindrome(int n) {
        int reverseN = 0;

        while (n > 0) {
            reverseN = reverseN * 10 + (n % 10);
            n = n / 10;
        }
        return reverseN == n;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 7, 1, 1, 0, 0, 9};
//        System.out.println("Longest equal subarray length: " + longestEqualSubarray(nums)); // Output: 6

//        System.out.println(isPalindrome(121));
//        System.out.println(romanToInt("III"));
//        System.out.println("-----------------------");
//        System.out.println(addStrings("6913259244", "71103343"));
//        System.out.println("longest string is "+ longestCommonPrefix( new String[]{"card","ar"}));
//        System.out.println("longest string is "+ longestCommonPrefix1( new String[]{"card","ar"}));
//        System.out.println("longest string is "+ longestCommonPrefix2( new String[]{"card","ar"}));
//        System.out.println("longest string is "+ longestCommonPrefix3( new String[]{"flower","flow", "low" , "ow"}));
//        System.out.println("longest string is "+ longestCommonPrefix4( new String[]{"a"}));
//        System.out.println("removeDuplicates  "+ removeDuplicates( new int[]{0 }));
//        System.out.println("removeDuplicates  "+ Arrays.toString(plusOne(new int[]{9, 9, 9, 9, 9})));
//        System.out.println("Decode String " + decodeString("11[a]"));
//        System.out.println("longestPalindrome " + longestPalindrome("abbbbca"));
//        System.out.println("myAtoi " + myAtoi(" ++1"));
//        System.out.println("subArraySum " + subArraySum(new int[]{1,2,3,7,5,8,4,-1,9,-3, 2, 0,-30 }, 12));
//        System.out.println("subArraySum " + subArraySum(new int[]{1,2,3,-2,4}, 5));

    }

    public static int romanToInt(String s) {
        int res = 0;
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (int i = 0; i < s.length() - 1; i++) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
                res = res + map.get(s.charAt(i));
            } else if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                res = res - map.get(s.charAt(i));
            }
        }
        return res + map.get(s.charAt(s.length() - 1));
    }

    public static String intToRoman(int num) {
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] numeral = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < romans.length; i++) {
            while (num >= numeral[i]) {
                result.append(romans[i]);
                num = num - numeral[i];
            }
        }
        return result.toString();
    }

    public static String addStrings(String num1, String num2) {
        int[] nums = {};
//            int max1=0, max2=0, max3=0;
//            Arrays.sort(nums);
//            Set<Integer> numbers = new LinkedHashSet<>();
//            for(int i=0; i<nums.length;i++){
//                numbers.add((Integer) nums[i]);
//            }
//            if(numbers.size()<2){
//                return numbers.get(0)>numbers.get(1) ? numbers.get(0):  numbers.get(1);
//            }
//            else {
//                return numbers.get(numbers.size()-3);
//            }
        return null;

    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();
        if (ch.length <= 1) return false;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(' || ch[i] == '{' || ch[i] == '[') {
                stack.push(ch[i]);
            } else if ((ch[i] == ')' || ch[i] == '}' || ch[i] == ']')) {
                if (stack.isEmpty()) return false;
                if ((stack.peek() == '{' && ch[i] == '}') || (stack.peek() == '(' && ch[i] == ')') || (stack.peek() == '[' && ch[i] == ']'))
                    stack.pop();
                else return false;
            }
        }
        if (stack.isEmpty()) return true;
        else return false;
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public static String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private static String longestCommonPrefix(String[] strs, int left, int right) {
        if (left == right) return strs[left];
        int mid = (left + right) / 2;
        String lcpLeft = longestCommonPrefix(strs, left, mid);
        String lcpRight = longestCommonPrefix(strs, mid + 1, right);
        return commonPrefix(lcpLeft, lcpRight);
    }

    private static String commonPrefix(String left, String right) {
        int minLength = Math.min(left.length(), right.length());
        for (int i = 0; i < minLength; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, minLength);
    }

    public static String longestCommonPrefix3(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length - 1];
        int idx = 0;
        while (idx < s1.length() && idx < s2.length()) {
            if (s1.charAt(idx) == s2.charAt(idx)) {
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx);
    }


    public static String longestCommonPrefix4(String[] strs) {
        if (strs.length == 0 || strs == null) return "";

        if (strs.length == 1 && (strs[0] == null || strs[0].length() == 0)) return "";
        else if (strs[0].length() == 1) return strs[0];

        if (strs.length == 2 && (strs[1] == null || strs[1].length() == 0)) return "";


        String prefix = strs[0];
        int prefixIndexLength = prefix.length();
        for (int i = 1; i < strs.length; i++) {
            int index = 0;
            prefixIndexLength = Math.min(prefixIndexLength, strs[i].length());

            while (index < prefixIndexLength) {
                if (strs[i].charAt(index) == prefix.charAt(index)) index++;
                else {
                    prefixIndexLength = Math.min(prefixIndexLength, index);
                    break;
                }
            }
        }
        return prefix.substring(0, prefixIndexLength);

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;

        ListNode lHead = sortList(head);
        ListNode rHead = sortList(mid);
        return merge(lHead, rHead);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode result = new ListNode(0);
        ListNode dummy = result;
        while (left != null && right != null) {
            if (left.val < right.val) {
                dummy.next = left;
                left = left.next;
            } else {
                dummy.next = right;
                right = right.next;
            }
            dummy = dummy.next;
        }
        if (left != null) {
            dummy.next = left;
        } else dummy.next = right;

        return result.next;
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int slow = 0;

        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }

        return slow + 1;
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 != 10) {
                digits[i] = digits[i] + 1;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newArray = new int[digits.length + 1];
        newArray[0] = 1;
        return newArray;
    }


    public static String decodeString(String s) {
        Stack<Object> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == ']') {
                int i = stack.size();
                String tempString = "";
                while (i > 0) {
                    if (stack.peek().equals('[')) {
                        stack.pop();
                        Integer times = Integer.parseInt(stack.pop().toString());
                        String tempFinal = "";
                        while (times > 0) {
                            tempFinal = tempFinal + tempString;
                            times--;
                        }
                        stack.push(tempFinal);
                        tempFinal = "";
                        tempString = "";
                        break;
                    } else {
                        tempString = stack.pop() + tempString;
                    }
                    i--;
                }
            } else {
                Integer i = 0;
                if (Character.isDigit(ch)) {
                    if (!stack.isEmpty() && stack.peek() instanceof Integer) {
                        i = ((int) stack.pop() * 10) + Integer.parseInt(String.valueOf(ch));
                    } else {
                        i = (i * 10) + Integer.parseInt(String.valueOf(ch));
                    }
                    stack.push(i);
                } else {
                    stack.push(ch);
                }
            }
        }
        String finalString = "";
        while (!stack.isEmpty()) {
            finalString = stack.pop() + finalString;
        }
        return finalString;
    }

    public static String longestPalindrome(String s) {
        int end=0, start=0;
        StringBuffer maxString = null;

        for(int i=0; i<s.length();i++){
            int odd = expandAroundCenter(s,i,i);
            int even = expandAroundCenter(s,i,i+1);
            int maxLength = Math.max(odd,even);
            if(maxLength> end-start){
                start = i-(maxLength-1)/2;
                end = i+maxLength/2;
            }
       }
        return s.substring(start,end+1);
    }

    public static int myAtoi(String s) {
        int negative = 1;
        int num = 0;
        s = s.trim();
        if (s.startsWith("-")) {
            negative = -1;
            s = s.substring(0);
        } else if (s.startsWith("+")) {
            s = s.replace("+", "");
        }

        if (s.startsWith("-")||s.startsWith("+")) return 0;

        String s1 = s.replaceAll("^0+", "");
        for (Character ch : s1.toCharArray()) {
            if (Character.isDigit(ch)) {
                if (num > Integer.MAX_VALUE / 10 ||
                        (num == Integer.MAX_VALUE / 10 && (ch - '0') > 7)) {
                    return negative == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                num = (num * 10) + ch - '0';
            } else {
                break;
            }
        }
        return negative * num;
    }

    public static int expandAroundCenter(String s, int left, int right){
        while(left>=0 && right<s.length()-1 && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }

    public static int subArraySum(int[] arr, int k){
        int count =0, prefixSum=0;
        Map<Integer, Integer> prefixSumFrequencyMap = new HashMap<>();
        for(int num : arr){
            prefixSum=prefixSum+num;
            if(prefixSumFrequencyMap.containsKey(prefixSum-k)){
                count=count+prefixSumFrequencyMap.get(prefixSum-k);
            }
            prefixSumFrequencyMap.put(prefixSum,prefixSumFrequencyMap.getOrDefault(prefixSum,0)+1);
        }
        return count;

//        int prefix=0;
//        List<ArrayList<Integer>> result = new ArrayList<>();
//        HashMap<Integer, Integer> prefixMap = new HashMap<>();
//        prefixMap.put(0,1);
//        for(int i=0;i<arr.length; i++){
//            prefix=prefix+arr[i];
//            if(prefixMap.containsKey(prefix-k)){
//                int index = prefixMap.get(prefix-k);
//                ArrayList<Integer> list = new ArrayList<>();
//                list.add(index+1);
//                list.add(i);
//                result.add(list);
//            }
//            prefixMap.put(prefix, i);
//        }
//        if(result.size()==0){
//            return new ArrayList<>(Arrays.asList(-1));
//        }
//        else{
//            return result.get(0);
//        }

    }


    public static int equilibriumPoint(int arr[]) {
        // code here
        int n = arr.length;
        int[] prefix = new int[n];

        //create prefix sum
        prefix[0] = arr[0];
        for(int i=1; i<n; i++){
            prefix[i] = prefix[i-1] + arr[i];
        }

        int store = -1;
        for(int i=1; i<prefix.length-1; i++){
            int left = prefix[i-1];
            int right = prefix[n-1] - prefix[i];
            if(left == right){
                store = i+1;
                break;
            }

        }

        return store;
    }



}

