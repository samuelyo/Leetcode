package com.leetcode.KDiffPairsInAnArray;

import java.util.Arrays;

public class KDiffPairsInAnArray4 {

	public static void main(String[] args) {
		
		int[] nums = {1,3,1,5,4};
		int k = 0;
		System.out.println(findPairs(nums, k));

	}
	
	
	public static int findPairs(int[] nums, int k) {
		
		Arrays.sort(nums);
		int count = 0;
		int index = 0;
		while(index < nums.length) {
			int value = nums[index];
			int temp = index + 1;
			while(temp < nums.length && nums[temp] - nums[index] < k) {
				temp ++;
			}
			if(temp < nums.length && nums[temp] - nums[index] == k) {
				count ++;
			}
			temp = index + 1;
			while(temp < nums.length && nums[temp] == value) {
				temp ++;
			}
			index = temp;
		}
		return count;
		
	}

}
