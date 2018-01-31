package com.leetcode.MajorityElementII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElementII3 {

	public static void main(String[] args) {
		
		int[] nums = {2,2,3,3};
		List<Integer> res = majorityElement(nums);
		for(int i = 0;i<res.size();i++) {
			System.out.print(res.get(i) + " ");
		}

	}
	
	public static List<Integer> majorityElement(int[] nums) {
		
		List<Integer> res = new ArrayList<Integer>();
		if(nums == null || nums.length == 0) {
			return res;
		}
		int times = nums.length / 3;
		Arrays.sort(nums);
		int index = 0;
		while(index < nums.length) {
			int temp = index;
			int value = nums[index];
			temp ++;
			while(temp < nums.length && nums[temp] == value) {
				temp ++;
			}
			if(temp - index > times) {
				res.add(value);
			}
			index = temp;
		}
		return res;
		
	}

}
