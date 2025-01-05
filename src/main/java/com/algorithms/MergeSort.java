package com.algorithms;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergesort(new int[]{1, 5, 2, 8, 4, 9, 3})));
    }
    public static int[] mergesort(int[] numbers){
        if(numbers.length<=1){ return numbers;
}
        int mid = numbers.length/2;
        int[] left = new int [mid];
        int[] right = new int [numbers.length-mid];
        int i=0, j=0;
        while (i<left.length){
            left[i]= numbers[i];
            i++;
        }
        int k=mid;

        while (k<numbers.length){
            right[j]=numbers[k];
            k++; j++;
        }
        int[] sleft = mergesort(left);
        int[] sright= mergesort(right);

        return combine(sleft, sright);
    }

    public static int[] combine(int[] leftArray, int[] rightArray){
        int[] result = new int[leftArray.length+rightArray.length];
        int i=0, j=0, k=0;
        while(i<leftArray.length && j<rightArray.length){
            if(leftArray[i]<rightArray[j]){
                result[k]= leftArray[i]; k++;
                i++;
            }
            else {
                result[k]= rightArray[j]; k++;
                j++;
            }
        }


        while (i<leftArray.length) {
            result[k] = leftArray[i];
            k++; i++;
        }
        while(j<rightArray.length) {
            result[k] = rightArray[j];
            k++; j++;
        }

        return result;

    }


}
