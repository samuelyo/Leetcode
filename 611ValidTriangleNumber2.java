package com.leetcode.ValidTriangleNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidTriangleNumber2 {

	public static void main(String[] args) {
		
		int[] nums = {0,0,0};
		System.out.println(triangleNumber(nums));

	}
	
	public static int triangleNumber(int[] nums) {
		
		if(nums == null || nums.length < 3){
			return 0;
		}
		Arrays.sort(nums);
		int count = 0;
		for(int i = 0;i<nums.length - 2;i++){
			int left = i + 1;
			while(left < nums.length - 1){
				int right = nums.length - 1;
				while(right >= 0 && nums[right] >= nums[i] + nums[left]){
					right --;
				}
				if(right > left){
					count += right - left;
				}
				left ++;
			}	
		}
		return count;
	}

}
