package com.datastructures;

import java.util.*;

public class ArraySum {
	
static int target=40;
	static int[] num= {61, 30, 28, 47, 42, 25, 41, 56, 27, 45, 44, 34, 46, 35, 58, 36, 60, 29, 53, 55, 32, 31, 33, 59, 50, 51, 52, 37, 39, 38, 43, 49, 54, 57, 40, 26, 48
};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isSumExists(num,target));

		System.out.println(print2largest(num));

	}
	public static boolean isSumExists(int[] input, int target) {
		Map<Integer, Integer> map= new HashMap<>();
		
		for(int i=0; i<input.length; i++) {
			if(map.containsKey(target - input[i])) {
				return true;
			}
			else {
				map.put(input[i],input[i]);
			}
		}
		
		return false;
		
	}
	
	
	    static int print2largest(int arr[]) {
	      	    // code here
		int max=Integer.MIN_VALUE, smax=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++){
		    if(arr[i]>=max) {
		        smax=max;
		        max=arr[i];
		    }
		    else if(arr[i]>smax) {
		        smax=arr[i];
		        
		    }
		}
		    return smax;
		}
}
