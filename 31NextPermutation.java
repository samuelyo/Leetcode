package com.leetcode.NextPermutation;

import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		
		int[] nums = {5,1,1};
		nextPermutation(nums);
		for(int i = 0;i<nums.length;i++){
			System.out.print(nums[i] + " ");
		}

	}
	
	public static void nextPermutation(int[] nums) {
	
		if(nums == null || nums.length == 0 || nums.length == 1){
			return ;
		}
		int i = nums.length - 1;
//		if(nums[i] > nums[i-1]){
//			int temp = nums[i];
//			nums[i] = nums[i-1];
//			nums[i-1] = temp;
//		}else{
			while(i > 0 && nums[i] <= nums[i-1]){
				i --;
			}
			if(i == 0){
				Arrays.sort(nums);
				return ;
			}else{
				int cha = nums[i-1];
				int j = nums.length - 1;
				while(nums[j] <= cha){
					j --;
				}
				nums[i-1] = nums[j];
				nums[j] = cha;
				int left = i;
				int right = nums.length - 1;
				while(left < right){
					int temp = nums[left];
					nums[left] = nums[right];
					nums[right] = temp;
					left ++;
					right --;
				}
//			}
		}
		
		
	}

}
