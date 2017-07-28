package com.leetcode.SetMismatch;

import java.util.HashSet;
import java.util.Set;

public class SetMismatch {

	public static void main(String[] args) {
		
		int[] nums = {1,2,2,4};
		int[] res = findErrorNums(nums);
		for(int i = 0;i<res.length;i++){
			System.out.print(res[i] + " ");
		}

	}
	
	public static int[] findErrorNums(int[] nums) {
		
		int[] res = new int[2];
		int len = nums.length;
		int sum = (1 + len) * len / 2;
		Set<Integer> set = new HashSet<Integer>();
		int curSum = 0;
		for(int i = 0;i<len;i++){
			if(set.contains(nums[i])){
				res[0] = nums[i];
			}else{
				set.add(nums[i]);
			}
			curSum += nums[i];
		}
		res[1] = res[0] - (curSum - sum);
		return res;
		
	}

}
