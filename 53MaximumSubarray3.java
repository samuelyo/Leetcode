package com.leetcode.MaximumSubarray;

public class MaximumSubarray3 {

	public static void main(String[] args) {

		int[] nums = { -1 };
		System.out.println(maxSubarray(nums));
	}

	public static int maxSubarray(int[] nums) {
		// ˼������
		// ����Ҫ����ר�ŵĿռ����洢��������ǰλ������µ���������к�ֵ
		// ֻ��ÿһ��λ���ϣ�ÿһ�εı����и���ֵ����
		int maxSoFar = nums[0], maxEndingHere = nums[0];
		for (int i = 1; i < nums.length; ++i) {
			maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
	}
}
