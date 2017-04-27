package com.leetcode.missingnumber;

import java.util.Arrays;

public class MissingNumber3 {

	public static void main(String[] args) {
		
		int[] nums = {1,2,3};
		System.out.println(missingNumber(nums));
		
	}
	
	public static int missingNumber(int[] nums){
		
		/**
		 * The basic idea is to use XOR operation. 
		 * We all know that a^b^b =a, 
		 * which means two xor operations with the same number will eliminate the number and reveal the original number.
		 * In this solution, I apply XOR operation to both the index and value of the array. 
		 * In a complete array with no missing numbers, the index and value should be perfectly corresponding( nums[index] = index), 
		 * so in a missing array, what left finally is the missing number.
		 * 
		 *  a b c
		 *  a-1 a b
		 * 
		 * xor = a-1 ^a ^a ^b ^b ^c = a-1 ^ c
		 * so the missing one is xor ^ c = a-1 ^ c ^c =a-1
		 */
		int xor = 0,i = 0;
		for (i = 0; i < nums.length; i++) {
			xor = xor ^ i ^ nums[i];
		}

		return xor ^ i;
		
	}
}
