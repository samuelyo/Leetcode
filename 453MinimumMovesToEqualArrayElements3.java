package com.leetcode.MinimumMovesToEqualArrayElements;

public class MinimumMovesToEqualArrayElements3 {

	public static void main(String[] args) {

		int[] nums = { -100, 0, 100 };
		System.out.println(minMoves(nums));

	}

	//let's define sum as the sum of all the numbers, before any moves; 
	//minNum as the min number int the list; 
	//n is the length of the list;
	//After, say m moves, we get all the numbers as x , and we will get the following equation
	//sum + m * (n - 1) = x * n
	//and actually , x = min + m;
	//and finally, we will get sum - minNum * n = m
	
	public static int minMoves(int[] nums) {

		int min = nums[0];
		for(int i = 1;i<nums.length;i++) {
			min = Math.min(min, nums[i]);
		}
		int res = 0;
		for(int i = 0;i<nums.length;i++) {
			res += nums[i] - min;
		}
		return res;
	
	}
}
