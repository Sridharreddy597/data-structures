package com.datastructures.arrays;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Reverse {

	public static void main(String[] args) {
		
		
		Scanner c = new Scanner(System.in);

		int noOfTestCases = c.nextInt();
		for (int k = 0; k < noOfTestCases; k++) {

			int n = c.nextInt();
			int[] inputElements = new int[n];
			for (int j = 0; j < n; j++) {
				inputElements[j] = c.nextInt();
			}
			int[] result = reverse(inputElements, n);
			for (int l = 0; l < result.length; l++) {
				System.out.print(result[l] + " ");
			}
		}
	}

	public static int[] reverse(int[] arr, int n) {

		for (int i = 0; i < n / 2; i++) {
			arr[i] = arr[i] + arr[n - 1 - i];
			arr[n - 1 - i] = arr[i] - arr[n - 1 - i];
			arr[i] = arr[i] - arr[n - 1 - i];
		}
		return arr;
	}
}
