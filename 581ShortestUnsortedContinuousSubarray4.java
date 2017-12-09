package com.leetcode.ShortestUnsortedContinuousSubarray;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray4 {

	public static void main(String[] args) {
		
		int[] nums = {2, 6, 4, 8, 10, 9, 15};
		System.out.println(findUnsortedSubarray(nums));

	}
	
	public static int findUnsortedSubarray(int[] nums) {
		
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int[] temp = new int[nums.length];
		for(int i = 0;i<nums.length;i++) {
			temp[i] = nums[i];
		}
		Arrays.sort(temp);
		int bef = 0;
		while(bef < nums.length && nums[bef] == temp[bef]) {
			bef ++;
		}
		int aft = nums.length - 1;
		while(aft >= 0 && nums[aft] == temp[aft]) {
			aft --;
		}
		if(bef >= aft) {
			return 0;
		}else {
			return aft - bef + 1;
		}
	}

}
