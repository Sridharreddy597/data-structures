package com.datastructures.arrays;

class CountSmallerElements {
	long nearestIndex;

/*	public long countOfElements(long arr[], long n, long x) {
		this.getnearestIndexOfGivenNumber(arr, 0, n, x);
		if (nearestIndex < x) {
			return nearestIndex + 1;
		} else if (nearestIndex > x) {
			return nearestIndex;
		}
		return -1;
	}

	public long getnearestIndexOfGivenNumber(long arr[], long start, long end, long x) {
		if (arr.length == 0)
			return -1;
		else if (arr[arr.length / 2] == x) {
			nearestIndex = arr.length / 2;
			return arr.length / 2;
		} else if (x > arr[arr.length / 2]) {
			nearestIndex = arr.length / 2;
			return getnearestIndexOfGivenNumber(arr, arr.length / 2, arr.length - 1, x);
		} else {
			nearestIndex = arr.length / 2;
			return getnearestIndexOfGivenNumber(arr, 0, arr.length / 2, x);
		}
	}
	*/


public long countOfElements(long arr[], long n, long x) {
	if (x == 0)
		return 0;
	if (x > arr[n--])
		return n;
	for (long i = 0; i < n; i++) {
		if (arr[i] < x) {
			nearestIndex = i;
		} else {
		}
	}
	return nearestIndex + 1;
}
	
	
	
}
