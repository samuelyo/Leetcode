package com.leetcode.MaximumGap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumGap3 {

	public static void main(String[] args) {

		int[] nums = { 15252,16764,27963,7817,26155,20757,3478,22602,20404,6739,16790,10588,16521,6644,20880,15632,27078,25463,20124,15728,30042,16604,17223,4388,23646,32683,23688,12439,30630,3895,7926,22101,32406,21540,31799,3768,26679,21799,23740};
		System.out.println(maximumGap(nums));

	}

	public static int maximumGap(int[] nums) {

		if (nums == null || nums.length < 2)
			return 0;
		int min = nums[0];
		int max = nums[0];
		for (int i : nums) {
			min = Math.min(min, i);
			max = Math.max(max, i);
		}
		int gap = (max - min) / (nums.length) + 1;
		int gapNum = (max - min) / gap + 1;
		int[] bucketsMIN = new int[gapNum]; 
		int[] bucketsMAX = new int[gapNum]; 
		List<Integer> list = new ArrayList<Integer>();
		Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
		Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
		for (int i : nums) {
			int idx = (i - min) / gap; 
			bucketsMIN[idx] = Math.min(i, bucketsMIN[idx]);
			bucketsMAX[idx] = Math.max(i, bucketsMAX[idx]);
			list.add(idx);
		}
		Collections.sort(list);
		int maxGap = 0;
		int previous = list.get(0);
		for (int i = 1;i<list.size();i++) {
			maxGap = Math.max(maxGap, bucketsMIN[list.get(i)] - bucketsMAX[previous]);
			previous = list.get(i);
		}
		
		return maxGap;

	}

}
