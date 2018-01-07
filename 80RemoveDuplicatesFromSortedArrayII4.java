package com.leetcode.RemoveDuplicatesFromSortedArrayII;

public class RemoveDuplicatesFromSortedArrayII4 {

	public static void main(String[] args) {
		
		int[] nums = {1,1,1,2,2,3};
		int len = removeDuplicates(nums);
		for(int i = 0;i<len;i++){
			System.out.print(nums[i] + " ");
		}
		System.out.println();
		System.out.println(len);

	}
	
	public static int removeDuplicates(int[] nums) {
		
		int index = 0;
		int res = 0;
		if(nums == null || nums.length == 0) {
			return res;
		}
		int pre = nums[0];
		int count = 0;
		while(index < nums.length) {
			if(nums[index] != pre) {
				pre = nums[index];
				nums[res] = nums[index];
				res ++;
				count = 1;
			}else {
				pre = nums[index];
				nums[res] = nums[index];
				res ++;
				count ++;
				if(count == 2) {
					while(index < nums.length && nums[index] == nums[index - 1]) {
						index ++;
					}
					index --;
					count = 0;
				}
			}
			index ++;
		}
		return res;
		
	}

}
