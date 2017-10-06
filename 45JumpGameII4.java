package com.leetcode.JumpGameII;

public class JumpGameII4 {

	public static void main(String[] args) {

		int[] nums = { 2, 3, 1, 1, 4 };
		System.out.println(jump(nums));

	}

	public static int jump(int[] nums) {

		int res = 0, i = 0, cur = 0;
		while (cur < nums.length - 1) {
			int pre = cur;
			while (i <= pre) {
				cur = Math.max(cur, i + nums[i]);
				++i;
			}
			res ++;
		}
		return res;
	}

}
