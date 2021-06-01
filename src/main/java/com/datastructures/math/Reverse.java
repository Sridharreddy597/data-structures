package com.datastructures.math;

/**
 * 
 * 
 * 
 * 
Example 1:
Input: n = 00000010100101000001111010011100
Output:    964176192 (00111001011110000010100101000000)
Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.

Example 2:
Input: n = 11111111111111111111111111111101
Output:   3221225471 (10111111111111111111111111111111)
Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 *
 */
public class Reverse {
	
	
	
	
	

	public static void main(String[] args) {

//		System.out.println(reverse(1534236469));
//		System.out.println(reverseBits(11111111111111111111111111111101));
		System.out.println(hammingWeight(00000000000000000000000000001011));

	}

	public static int reverse(int num) {
		long rev = 0L;
		while (num != 0) {
			rev = rev * 10 + num % 10;
			num = num / 10;
		}

		if (rev > Integer.MIN_VALUE && rev < Integer.MAX_VALUE)
			return (int) rev;
		else
			return 0;

	}

	public static int reverseBits(int n) {
		int rev = 0;
		for (int i = 0; i < 32; i++) {
			rev = rev << 1;
			rev = rev | (n & 1);
			n = n >> 1;
		}
		return rev;
	}
	
	  // you need to treat n as an unsigned value
    public  static int hammingWeight(int n) {
        int count=0;
        for(int i=0;i<32;i++){
            if((n & 1) ==1){
                count++;
            }
            n=n >> 1;
        }
        return count;
    }
	
}
