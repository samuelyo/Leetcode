package com.leetcode.MaximumGap;

import java.util.Arrays;

public class MaximumGap4 {

	public static void main(String[] args) {

		int[] nums = { 15252,16764,27963,7817,26155,20757,3478,22602,20404,6739,16790,10588,16521,6644,20880,15632,27078,25463,20124,15728,30042,16604,17223,4388,23646,32683,23688,12439,30630,3895,7926,22101,32406,21540,31799,3768,26679,21799,23740};
		System.out.println(maximumGap(nums));

	}

	public static int maximumGap(int[] nums) {

		if (nums == null || nums.length < 2)
			return 0;
		// get the max and min value of the array
		int min = nums[0];
		int max = nums[0];
		for (int i : nums) {
			min = Math.min(min, i);
			max = Math.max(max, i);
		}
		// the minimum possible gap, ceiling of the integer division
		int gap = (int) Math.ceil((double) (max - min) / (nums.length - 1));
		int[] bucketsMIN = new int[nums.length]; // store the min value in that bucket
		int[] bucketsMAX = new int[nums.length]; // store the max value in that bucket
		Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
		Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
		// put numbers into buckets
		for (int i : nums) {
			if (i == min || i == max)
				continue;
			int idx = (i - min) / gap; // index of the right position in the buckets
			bucketsMIN[idx] = Math.min(i, bucketsMIN[idx]);
			bucketsMAX[idx] = Math.max(i, bucketsMAX[idx]);
		}
		// scan the buckets for the max gap
		int maxGap = Integer.MIN_VALUE;
		int previous = min;
		for (int i = 0; i < nums.length; i++) {
			if (bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE)
				// empty bucket
				continue;
			// min value minus the previous value is the current gap
			maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
			// update previous bucket value
			previous = bucketsMAX[i];
		}
		maxGap = Math.max(maxGap, max - previous); // updata the final max value gap
		return maxGap;

	}

}
