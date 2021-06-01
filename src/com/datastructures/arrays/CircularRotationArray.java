package com.datastructures.arrays;

import java.util.*;

public class CircularRotationArray {
	/*
	 * 77 69
	 * 
	 * 40 13 27 87 95 40 96 71 35 79 68 2 98 3 18 93 53 57 2 81 87 42 66 90 45 20 41
	 * 30 32 18 98 72 82 76 10 28 68 57 98 54 87 66 7 84 20 25 29 72 33 30 4 20 71
	 * 69 9 16 41 50 97 24 19 46 47 52 22 56 80 89 65 29 42 51 94 1 35 65 25
	 * 
	 * Its Correct output is: 29 42 51 94 1 35 65 25 40 13 27 87 95 40 96 71 35 79
	 * 68 2 98 3 18 93 53 57 2 81 87 42 66 90 45 20 41 30 32 18 98 72 82 76 10 28 68
	 * 57 98 54 87 66 7 84 20 25 29 72 33 30 4 20 71 69 9 16 41 50 97 24 19 46 47 52
	 * 22 56 80 89 65
	 */


public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfTestCases = Integer.parseInt(sc.nextLine());
		int[][][] inputs= new int[noOfTestCases][2][1];
		for(int i=0;i<noOfTestCases;i++) { 
		String input=sc.nextLine();
		
		String[] input1= input.trim().split("\\s+");
		int totalSize=Integer.parseInt(input1[0]); 
		int rotationSize=Integer.parseInt(input1[1]); 
	
		int[] inputElements = new int[totalSize]; 
			String e=sc.nextLine();
			String[] e1= e.trim().split("\\s+");
			for(int j=0;j<e1.length;j++) { 
		    inputElements[j]=Integer.parseInt(e1[j]);
		  } 
		  inputs[i][0]=inputElements;
		  inputs[i][1][0]=rotationSize;
	}
	
	for(int p=0;p<inputs.length;p++){
	  	    int[] result =rotateArray(inputs[p][0], inputs[p][1][0]);
		  	for (int l = 0; l < result.length; l++) {
				System.out.print(result[l] + " ");
			}
			System.out.println();
	}
}

	public static int[] rotateArray(int[] arr, int rotationSize) {
		int n=arr.length;
		int[] subArray = new int[rotationSize];
		for (int i = 0; i < rotationSize; i++) {
			subArray[i] = arr[i];
		}
		for (int k = rotationSize; k < arr.length; k++) {
			arr[k - rotationSize] = arr[k];
		}
		for (int l = 0; l < subArray.length; l++) {
			arr[n-rotationSize+l ] = subArray[l];
		}
		return arr;
	}

}
