package com.leetcode.CountOfSmallerNumbersAfterSelf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {

	public static void main(String[] args) {
		
		int[] nums = {5,2,6,1};
		List<Integer> res = countSmaller(nums);
		for(int i = 0;i<res.size();i++){
			System.out.print(res.get(i) + " ");
		}

	}

	public static List<Integer> countSmaller(int[] nums) {
		
		List<Integer> res = new ArrayList<Integer>();
		if(nums == null || nums.length == 0){
			return res;
		}
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i = 0;i<nums.length;i++){
			max = Math.max(max, nums[i]);
			min = Math.min(min, nums[i]);
		}
		int[] count = new int[max - min + 1];
		for(int i = nums.length - 1;i>=0;i--){
			int value = nums[i];
			for(int j = max - min;j > value - min;j--){
				count[j] ++;
			}
			res.add(count[value - min]);
		}
		Collections.reverse(res);
		return res;
		
	}
}
