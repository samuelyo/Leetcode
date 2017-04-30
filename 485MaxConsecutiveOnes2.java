package com.leetcode.maxconsecutiveones;

import java.util.Arrays;

public class MaxConsecutiveOnes2 {

	public static void main(String[] args) {
		
		int[] nums = {1,1,0,1,1,1};
		System.out.println(findMaxConsecutiveOnes(nums));

	}
	
	public static int findMaxConsecutiveOnes(int[] nums){
		
		int result = 0;//�����1����ĳ���
        int count = 0;//���ڼ��������1����ĳ���
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
        	count++;
        	result = Math.max(count, result);
            }
            else count = 0;
        }
        
        return result;
	}

}
