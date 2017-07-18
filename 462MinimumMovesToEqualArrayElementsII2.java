package com.leetcode.MinimumMovesToEqualArrayElementsII;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElementsII2 {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 4, 5, 6, 3, 2, 4, 5, 3, 2 };
		System.out.println(minMoves2(nums));

	}

	/**
	 * Suppose you have two endpoints A and B, when you want to find a point C
	 * that has minimum sum of distance between AC and BC, the point C will
	 * always between A and B. Draw a graph and you will understand it.
	 * Lets keep moving forward. After we locating the point C between A and B, we
	 * can define that dis(AC) = c - a; dis(CB) = b - c; sum = dis(AC) + dis(CB)
	 * = b - a. b - a will be a constant value, given specific b and a. Thus
	 * there will be no difference between points among A and B.
	 * 
	 * In this problem, we set two boundaries, saying i and j, and we move the i
	 * and j to do the computation.
	 * 
	 * @param nums
	 * @return
	 */
	public static int minMoves2(int[] nums) {

		Arrays.sort(nums);
		int i = 0, j = nums.length - 1;
		int count = 0;
		while (i < j) {
			count += nums[j] - nums[i];
			i++;
			j--;
		}
		return count;

	}
}
