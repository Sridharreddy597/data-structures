import java.util.*;

public class MergeSortPratice {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(divide(new int[]{1, 6, 9, 2, 8, 3, 7, 4, 5})));
//        System.out.println(containsNearbyDuplicate(new  int[]{1,2,3,1,2,3},2));

        int[] arry1= new int[]{1,3,4,5};
        int[] arry2= new int[]{8,6,2};

//        System.out.println(Arrays.toString(combine1(arry1,arry2)));
      //  System.out.println(isPalindrome("race a car"));
        System.out.println(isIsomorphic("badc", "baba"));
    }

    public static int[] divide(int[] numbers){
        if(numbers.length<=1) return numbers;


        int mid = numbers.length/2;
        int[] left = new int[mid];
        int[] right = new int[numbers.length-mid];
        int i=0;
         while(i<mid){
             left[i] = numbers[i];
             i++;
         }
         int j=0, k= mid;
        while(k<numbers.length){
            right[j] = numbers[k];
            j++; k++;
        }

        int[] sLeft = divide(left);
        int[] sRight = divide(right);

        return combine(sLeft, sRight);
    }

    private static int[] combine(int[] sLeft, int[] sRight) {
        int[] result = new int[sLeft.length+sRight.length];
        int i=0,j=0,k=0;
        while(i<sLeft.length && j<sRight.length){
         if(sLeft[i]<sRight[j]){
             result[k] = sLeft[i];
             i++; k++;
         }
         else {
             result[k] = sRight[j];
             j++; k++;
         }
        }
       while(i<sLeft.length){
           result[k] = sLeft[i];
           i++; k++;
       }
        while(j<sRight.length){
            result[k] = sRight[j];
            j++; k++;
        }
        return result;
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i]) && (i-map.get(nums[i]))<=k)
                return true;

            map.put(nums[i], i);

        }
        return false;

    }

    public static int[] combine1(int[] left, int[] right){
        int[] merged = new int[left.length+right.length];
        int i=0, j=0, k=0;
        while(i<left.length && j<right.length){
            if(left[i]<right[j]){
                merged[k]=left[i];
                k++; i++;
            }else{
                merged[k]=right[j];
                k++; j++;
            }
        }
        if(i<left.length){
            merged[k]=left[i];
            k++; i++;
        }
        if(j<right.length){
            merged[k]=right[j];
            k++; j++;
        }

        return merged;
    }

    public static  boolean isPalindrome(String s) {
        return false;
    }

    public int titleToNumber(String columnTitle) {
        int j=0; int sum= 0; int i=columnTitle.length()-1;
        for(i=columnTitle.length()-1 ; i>=0; i++){
            sum = sum + j * (columnTitle.charAt(i)+'0');
            j++;
        }
        return sum;
    }

    public static boolean isIsomorphic(String s, String t) {
        if(s.length()<=1&& s.charAt(0)==t.charAt(0))return true;
        Map<Character, Character> map = new HashMap<>();
        int i=0;
        while (i<s.length()){
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }else {
                map.put(s.charAt(i),t.charAt(i) );
            }
            i++;
        }
        return true;

    }


}
