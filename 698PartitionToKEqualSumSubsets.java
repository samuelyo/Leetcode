package com.leetcode.PartitionToKEqualSumSubsets;

public class PartitionToKEqualSumSubsets {

	public static void main(String[] args) {
		
		int[] nums = {4, 3, 2, 3, 5, 2, 1};
		int k = 4;
		System.out.println(canPartitionKSubsets(nums, k));

	}

	public static boolean canPartitionKSubsets(int[] nums, int k) {
		
		int sum = 0;
		for(int num : nums) {
			sum += num;
		}
		if(sum % k != 0) {
			return false;
		}
		int target = sum / k;
		boolean[] visited = new boolean[nums.length];
		return canPartitionKSubsetsHelp(nums, k, target, visited, 0, 0);
		
	}
	
	public static boolean canPartitionKSubsetsHelp(int[] nums, int k, int target, boolean[] visited, int curSum, int start) {
		
		if(k == 1) {
			return true;
		}
		
		if(curSum == target) {
			return canPartitionKSubsetsHelp(nums, k - 1, target, visited, 0, 0);
		}
		
		for(int i = start;i<nums.length;i++) {
			if(!visited[i]) {
				curSum += nums[i];
				visited[i] = true;
				if(canPartitionKSubsetsHelp(nums, k, target , visited, curSum, i + 1)) {
					return true;
				}
				curSum -= nums[i];
				visited[i] = false;
			}
		}
		return false;
		
	}
}
