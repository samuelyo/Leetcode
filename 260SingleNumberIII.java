package com.leetcode.SingleNumberIII;

import java.util.Arrays;

public class SingleNumberIII {

	public static void main(String[] args) {
		
		int[] nums = {1,2,1,3,2,5};
		int[] res = singleNumber(nums);
		for(int i = 0;i<res.length;i++){
			System.out.print(res[i] + " ");
		}

	}
	
	public static int[] singleNumber(int[] nums) {
		
		Arrays.sort(nums);
		int index = 0;
		int[] res = new int[2];
		int count = 0;
		while(index < nums.length - 1){
			if(nums[index] == nums[index + 1]){
				index += 2;
			}else{
				res[count] = nums[index];
				index ++;
				count ++;
			}
		}
		if(count == 1){
			res[count] = nums[nums.length - 1];
		}
		return res;
		
	}

}
