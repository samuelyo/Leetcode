package com.leetcode.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum3 {

	public static void main(String[] args) {
		
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> res = threeSum(nums);
		for(int i = 0;i<res.size();i++) {
			List<Integer> cur = res.get(i);
			for(int j = 0;j<cur.size();j++) {
				System.out.print(cur.get(j) + " ");
			}
			System.out.println();
		}

	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for(int i = 0;i<nums.length - 2;i++) {
			int num1 = nums[i];
			int target = 0 - num1;
			int left = i + 1;
			int right = nums.length - 1;
			while(left < right) {
				if(nums[left] + nums[right] == target) {
					res.add(Arrays.asList(nums[i], nums[left], nums[right]));
					while(left < right && nums[left] == nums[left + 1]) {
						left ++;
					}
					while(left < right && nums[right] == nums[right - 1]) {
						right --;
					}
					left ++;
					right --;
				}else if(nums[left] + nums[right] < target) {
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
			while(i < nums.length-2 && nums[i] == nums[i + 1]){
				i ++;
			}
		}
		return res;
	}

}
