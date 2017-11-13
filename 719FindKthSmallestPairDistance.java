package com.leetcode.FindKthSmallestPairDistance;

import java.util.PriorityQueue;

public class FindKthSmallestPairDistance {

	public static void main(String[] args) {
		
		int[] nums = {1,3,1};
		int k = 1;
		int res = smallestDistancePair(nums, k);
		System.out.println(res);

	}
	
	public static int smallestDistancePair(int[] nums, int k) {
		
		int res = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for(int i = 1;i<nums.length;i++) {
			for(int j = 0;j<i;j++) {
				queue.add(Math.abs(nums[i] - nums[j]));
			}
		}
		for(int i = 0;i<k;i++) {
			res = queue.poll();
		}
		return res;
		
	}

}
