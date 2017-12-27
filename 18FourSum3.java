package com.leetcode.FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum3 {

	public static void main(String[] args) {
		
		int[] nums = {1,-2,-5,-4,-3,3,3,5};
		int target = -11;
		List<List<Integer>> res = fourSum(nums, target);
		for(int i = 0;i<res.size();i++) {
			List<Integer> cur = res.get(i);
			for(int j = 0;j<cur.size();j++) {
				System.out.print(cur.get(j) + " ");
			}
			System.out.println();
		}

	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for(int i = 0;i<nums.length - 3;i++) {
			int num1 = nums[i];
			int tar = target - num1;
			for(int j = i + 1;j<nums.length - 2;j++) {
				int num2 = nums[j];
				int sum = tar - num2;
				int left = j + 1;
				int right = nums.length - 1;
				while(left < right) {
					int value = nums[left] + nums[right];
					if(value == sum) {
						res.add(Arrays.asList(num1, num2, nums[left], nums[right]));
						while(left < right && nums[left] == nums[left + 1]) {
							left ++;
						}
						while(left < right && nums[right] == nums[right - 1]) {
							right --;
						}
						left ++;
						right --;
					}else if(value < sum) {
						while(left < right && nums[left] == nums[left + 1]) {
							left ++;
						}
						left ++;
					}else {
						while(left < right && nums[right] == nums[right - 1]) {
							right --;
						}
						right --;
					}
				}
				while(j < nums.length - 1 && nums[j] == nums[j + 1]) {
					j ++;
				}
			}
			while(i < nums.length - 1 && nums[i] == nums[i + 1]) {
				i ++;
			}
		}
		return res;
		
	}
	
}
