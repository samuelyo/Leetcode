package com.leetcode.ValidTriangleNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidTriangleNumber3 {

	public static void main(String[] args) {

		int[] nums = { 0, 0, 0 };
		System.out.println(triangleNumber(nums));

	}

	public static int triangleNumber(int[] nums) {

		Arrays.sort(nums);
		int count = 0, n = nums.length;
		for (int i = n - 1; i >= 2; i--) {
			int l = 0, r = i - 1;
			while (l < r) {
				if (nums[l] + nums[r] > nums[i]) {
					count += r - l;
					r--;
				} else
					l++;
			}
		}
		return count;
		
	}

}
