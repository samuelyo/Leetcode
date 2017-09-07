package com.leetcode.IncreasingTripletSubsequence;

public class IncreasingTripletSubsequence2 {

	public static void main(String[] args) {

		int[] nums = { 5, 1, 5, 5, 2, 5, 4 };
		System.out.println(increasingTriplet(nums));

	}

	public static boolean increasingTriplet(int[] nums) {

		// start with two largest values, as soon as we find a number bigger
		// than both, while both have been updated, return true.
		int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
		for (int n : nums) {
			if (n <= small) {
				small = n;
			} // update small if n is smaller than both
			else if (n <= big) {
				big = n;
			} // update big only if greater than small but smaller than big
			else
				return true; // return if you find a number bigger than both
		}
		return false;
		
	}
}
