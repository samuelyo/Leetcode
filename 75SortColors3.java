package com.leetcode.SortColors;

public class SortColors3 {

	public static void main(String[] args) {
		
		int[] nums = {0,1,2,1,2,1,2,0,1,2,2,0};
		sortColors(nums);
		for(int i = 0;i<nums.length;i++){
			System.out.print(nums[i] + " ");
		}
		
	}
	
	public static void sortColors(int[] nums) {
        
		int index = 0;
		int start = 0;
		int end = nums.length - 1;
		while(index <= end) {
			int cur = nums[index];
			if(cur == 0) {
				swap(nums, index, start);
				start ++;
			}else if(cur == 2) {
				swap(nums, index, end);
				end --;
				continue;
			}
			index ++;
		}
		
    }

	public static void swap(int[] nums, int i, int j) {
		
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		
	}
}
