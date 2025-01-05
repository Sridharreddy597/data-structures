package com.algorithms.prefixsum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Equilibrium {
    /* Input: arr[] = [1, 3, 5, 2, 2]
     * Output: 3
     * Explanation: The equilibrium point is at position 3 as the sum of elements before it (1+3) = sum of elements after it (2+2).
     */

    public static int equilibriumPoint(int arr[]) {
        int[] presumArray = new int[arr.length];
        presumArray[0]= arr[0];
        int eqPoint=0;
        for(int i=1;i<arr.length;i++){
            presumArray[i]=presumArray[i-1]+arr[i];
        }

        for(int i=1;i<arr.length-1;i++){
            int left= presumArray[i-1];
            int right = presumArray[arr.length-1]-presumArray[i];
            if(left==right){
                eqPoint=i+1;
                break;
            }
        }
        return eqPoint;
    }

    public static int maximumSumSubarray(int[] arr, int k) {
        // Code here
        int n = arr.length;
        int[] presum=new int[n];
        presum[0]=arr[0];
        for(int i=1;i<n;i++){
            presum[i]=presum[i-1]+arr[i];
        }

        if(n==k) return arr[n-1];
        int maxValue=0;
        for(int i=k;i<n;i++){
            int value= presum[i]-presum[i-k];
            if(value>maxValue){
                maxValue=value;
            }
        }
        return maxValue;
    }
    /*
    Example 1:
    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: The subarray [4,-1,2,1] has the largest sum 6.
    Example 2:

    Input: nums = [1]
    Output: 1
    Explanation: The subarray [1] has the largest sum 1.
    Example 3:

    Input: nums = [5,4,-1,7,8]
    Output: 23
    Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
    */

    public static int maxSubArray(int[] nums) {
        /*  //kandane's algorithm
        int max=nums[0], cursum=0;
        for(int i=0; i<nums.length; i++){
            cursum= cursum+nums[i];
            max = Math.max(cursum, max);
            cursum=(cursum < 0)?0:cursum;
        }
        return max;
       */
        //prefixsum Method
        int[] presumArray = new int[nums.length];
        presumArray[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            presumArray[i]= presumArray[i-1]+nums[i];
        }
        int maxsum=0, n= nums.length;
        for(int i=0;i<n;i++){
            if(i>1 && nums[i-1]<=0){
                continue;
            }
           int curSum=presumArray[n-1]-(i-1==-1?0:presumArray[i-1]);
            maxsum=Math.max(curSum, maxsum);
        }
        return maxsum;
    }

    public static void main(String[] args) {
//        System.out.println(equilibriumPoint(new int[]{1,3,5,2,2}));
//        System.out.println(maximumSumSubarray(new int[]{100,200,300,400}, 2));
//        System.out.println(maximumSumSubarray(new int[]{8819, 674, 8816, 7705, 5699, 5383, 6177, 2113, 1992}, 1));
//        System.out.println(maximumSumSubarray(new int[]{9753, 2228, 8097, 5261, 1870, 9643}, 3));
//        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
//        System.out.println(minLengthSubArray(new int[]{1, 4, 45, -6, 0, 19}, 51));
//        System.out.println(longSubarrWthSumDivByK(new int[]{-4, 5, -1, 0, 1, 0, 1, -2, 9}, 7));
//        System.out.println(longSubarrWthSumDivByK(new int[]{2, 7, 6, 1, 4, 5}, 3));
//        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
//            prefixAvg(list).forEach(System.out::println);
//        firstNegativeInteger(new int[]{-8, 2, 3, -6, 10}, 2).stream().forEach(System.out::println);
//                System.out.println(equalSum(new int[]{1, 3, 5, 2, 2}));
                System.out.println(equalSum(new int[]{0,0,0,0,0,0,0}));


    }
    static List<Integer> firstNegativeInteger(int arr[], int k) {
        // write code here
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<=arr.length-k;i++){
            int left=i; int firstVe=0;int window = left+k-1;
            while(left<=window){
                if(arr[left]<0){
                    firstVe=arr[left];
                    break;
                }
                left++;
            }
            result.add(firstVe);
        }
        return result;
    }
    //Input: x = 51, arr[] = [1, 4, 45, 6, 0, 19]
    //Output: 3  minimum-length-subarray-sum-greater-given-value

    public static int minLengthSubArray(int[] arr, int k){
        int minLength=arr.length+1;
        int left=0; int sum =0;
        for(int right=0;right<arr.length;right++){
            sum =sum+arr[right];
            while(left<=right && sum>k){
                int length = right - left + 1;
                System.out.println("sum="+sum+", length="+length+", start="+left+" right="+right);
                sum = sum-arr[left];
                left++;
                if(length<minLength) {
                    minLength=length;
                }
                sum-=arr[left];
                left++;
            }
        }
        return minLength==arr.length+1?0:minLength;
    }

   static int longSubarrWthSumDivByK(int[] arr, int k) {
        // Complete the function
        int sum=0;int maxLength=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        for(int i=0; i<arr.length;i++){
            sum = sum +arr[i];
            if (map.containsKey(sum%k)){
                int length = i-(map.get(sum%k)==0?1:map.get(sum%k))+1;
                if(maxLength<length){
                    maxLength = length;
                }
            }
            if(!map.containsKey(sum%k)){
                map.put(arr[i], i);
            }
        }
        return maxLength;
    }

    public static int countSubarrWithEqualZeroAndOne(int[] arr) {

        for(int i=0; i<arr.length;i++) {
            if(arr[i]==0) arr[i]=-1;
        }

        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        int presum=0; int count=0;
        for(int i=0; i<arr.length;i++){
            presum= presum+arr[i];
            if(map.containsKey(presum)){
                count = count+ map.get(presum);
            }
            map.put(presum, map.getOrDefault(presum, 0)+1);
        }
        return count;
    }
    public static ArrayList<Integer> prefixAvg(ArrayList<Integer> arr) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        Integer sum = 0;
        for(int i=0; i<arr.size();i++){
            sum = sum+arr.get(i);
            result.add(sum/(i+1));
        }
        return result;
    }
    public static int equalSum(int[] arr) {

        // Write your code here
        if(arr.length==1) return 0;
        int[] presum = new int[arr.length];
        int sum=0;
        int n= arr.length;
        for(int i=n-1;i>=0;i--){
            sum=sum+arr[i];
            presum[i]=sum;
        }

        int sum1=arr[0];
        for(int i=1;i<n-1;i++){
            sum1= sum1+arr[i];
            if(sum1-arr[i]==presum[i+1]){
                return i;
            }
        }
        return -1;
    }
}
