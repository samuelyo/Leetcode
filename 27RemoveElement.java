package com.leetcode.removeelement;

public class RemoveElement {

	public static void main(String[] args) {
		
		int[] nums = {3,2,2,3,3};
		System.out.println(removeElement(nums, 2));

	}

	public static int removeElement(int[] nums,int val){
		
		int index = 0;
		int change = 0;
		while(index < nums.length){
			if(val != nums[index]){
				nums[change] = nums[index];
				change ++;
			}
			index ++;
		}
		return change;
	}
	
}
