package com.leetcode.LargestDivisibleSubset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset4 {

	public static void main(String[] args) {
		
		int[] nums = {1,2,4,8};
		List<Integer> res = largestDivisibleSubset(nums);
		for(int i = 0;i<res.size();i++) {
			System.out.print(res.get(i) + " ");
		}

	}

	public static List<Integer> largestDivisibleSubset(int[] nums) {
		
		if(nums == null || nums.length == 0) {
			return new ArrayList<Integer>();
		}
		Arrays.sort(nums);
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		int max = 1;
		Integer maxIndex = 0;
		for(int i = 1;i<nums.length;i++) {
			for(int j = 0;j<i;j++) {
				if(nums[i] % nums[j] == 0) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			if(dp[i] > max) {
				max = dp[i];
				maxIndex = i;
			}
		}
		List<Integer> res = new ArrayList<Integer>();
		res.add(nums[maxIndex]);
		int pre = nums[maxIndex];
		int temp = max - 1;
		int index = maxIndex - 1;
		while(index >= 0 && temp >= 0) {
			if(dp[index] == temp && pre % nums[index] == 0) {
				res.add(0, nums[index]);
				pre = nums[index];
				temp --;
			}
			index --;
		}
		return res;
		
	}
}
