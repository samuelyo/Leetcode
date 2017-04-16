package com.leetcode.maximumsubarray;

import java.util.Arrays;

public class maximumSubarray2 {

	public static void main(String[] args) {
		
		int[] nums = {-1};
		System.out.println(maxSubarray(nums));
	}

	
	public static int maxSubarray(int[] nums){
		
	    //sum[i]��ʾ�������nums[i]���ڵ������е�����ֵ
		int[] sum = new int[nums.length];
		sum[0] = nums[0];
		//maxsum��ʾ��������к�
		int maxsum = sum[0];
		
		for(int i = 1;i<nums.length;i++){
			//���ȱ������nums[i]���ڣ�����ж�����nums[i-1]���ڵ������к͵������ԣ����������¿�һ��������
			sum[i] = nums[i]  + (sum[i-1] > 0?sum[i-1]:0);
			//����Ŀǰ״̬�µ���������к�
			maxsum = Math.max(maxsum, sum[i]);
		}
		return maxsum;
	}
}
