package com.leetcode.SingleElementInASortedArray;

public class SingleElementInASortedArray {

	public static void main(String[] args) {
		
		int[] nums = {3,3,7,7,10,11,11};
		System.out.println(singleNonDuplicate(nums));
		
	}
	
	public static int singleNonDuplicate(int[] nums) {
		
		int index = 0;
		while(index < nums.length - 1){
			if(nums[index] + nums[index+1] == 2 * nums[index]){
				index += 2;
			}else{
				return nums[index];
			}
		}
		return nums[nums.length - 1];
		
	}

}
