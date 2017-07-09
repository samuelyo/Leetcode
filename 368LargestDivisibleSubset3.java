package com.leetcode.LargestDivisibleSubset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset3 {

	public static void main(String[] args) {

		int[] nums = { 4, 8, 10, 240 };
		List<Integer> ans = largestDivisibleSubset(nums);
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}

	}

	public static List<Integer> largestDivisibleSubset(int[] nums) {

		int n = nums.length;
		int[] count = new int[n];
		int[] pre = new int[n];
		Arrays.sort(nums);
		int max = 0, index = -1;
		for (int i = 0; i < n; i++) {
			count[i] = 1;
			pre[i] = -1;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] % nums[j] == 0) {
					if (1 + count[j] > count[i]) {
						count[i] = count[j] + 1;
						pre[i] = j;
					}
				}
			}
			if (count[i] > max) {
				max = count[i];
				index = i;
			}
		}
		List<Integer> res = new ArrayList<Integer>();
		while (index != -1) {
			res.add(nums[index]);
			index = pre[index];
		}
		return res;
	}

}
