package com.leetcode.TotalHammingDistance;

public class TotalHammingDistance {

	public static void main(String[] args) {
		
		int[] nums = {4,14,2};
		System.out.println(totalHammingDistance(nums));

	}
	
	public static int totalHammingDistance(int[] nums) {
		
		int res = 0;
		if(nums == null || nums.length == 0){
			return res;
		}
		int len = nums.length;
		for(int i = 31;i>=0;i--){
			int numOne = 0;
			int[] temp = new int[len];
			int cur = 0;
			cur |= (1 << i);
			for(int j = 0;j<len;j++){
				temp[j] = cur & nums[j];
				if(temp[j] == cur){
					numOne ++;
				}
			}
			res += numOne * (len - numOne);
		}
		return res;
		
	}

}
