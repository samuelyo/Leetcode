package com.leetcode.MaximumSubarray;

public class MaximumSubarray3 {

	public static void main(String[] args) {

		int[] nums = { -1 };
		System.out.println(maxSubarray(nums));
	}

	public static int maxSubarray(int[] nums) {
		// 思想类似
		// 不需要开辟专门的空间来存储遍历到当前位置情况下的最大子数列和值
		// 只在每一个位置上，每一次的便利中更新值即可
		int maxSoFar = nums[0], maxEndingHere = nums[0];
		for (int i = 1; i < nums.length; ++i) {
			maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
	}
}
