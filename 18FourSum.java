package com.leetcode.FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	public static void main(String[] args) {
		
		int[] nums = {1,-2,-5,-4,-3,3,3,5};
		int target = -11;
		List<List<Integer>> ans = fourSum(nums, target);
		for(int i = 0;i<ans.size();i++){
			List<Integer> res = ans.get(i);
			for(int j = 0;j<res.size();j++){
				System.out.print(res.get(j) + " ");
			}
			System.out.println();
		}

	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		if(nums == null || nums.length < 4 || 4*nums[nums.length - 1] < target || 4 * nums[0] > target){
			return ans;
		}
		List<Integer> res ;
		
		int left ;
		int right ;
		for(int i = 0;i<nums.length;i++){
			while(i != 0 && i < nums.length && nums[i] == nums[i-1]){
				i++;
			}
			for(int j = i+1;j<nums.length ;j++){
				while(j != i+1 && j < nums.length && nums[j] == nums[j-1]){
					j++;
				}
				left = j+1;
				right = nums.length - 1;
				while(left < right){
					if(nums[left] + nums[right] == target - nums[i] - nums[j]){
						res = new ArrayList<Integer>();
						res.add(nums[i]);
						res.add(nums[j]);
						res.add(nums[left]);
						res.add(nums[right]);
						ans.add(res);
						while(left < nums.length-1 && nums[left] == nums[left+1]){
							left ++;
						}
						left ++;
						while(right > 1 && nums[right] == nums[right-1]){
							right --;
						}
						right --;
					}else if(nums[left] + nums[right] < target - nums[i] - nums[j]){
						while(left < nums.length-1 && nums[left] == nums[left+1]){
							left ++;
						}
						left ++;
					}else{
						while(right > 1 && nums[right] == nums[right-1]){
							right --;
						}
						right --;
					}
				}
			}
		}
		return ans;
	}
}
