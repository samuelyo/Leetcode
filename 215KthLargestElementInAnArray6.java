package com.leetcode.KthLargestElementInAnArray;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray6 {

	public static void main(String[] args) {
		
		int[] nums = {3,2,1,5,6,4};
		int k = 2;
		System.out.println(findKthLargest(nums, k));

	}

	public static int findKthLargest(int[] nums, int k) {
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		for(int i = 0;i<nums.length;i++) {
			queue.add(nums[i]);
		}
		for(int i = 0;i<k;i++) {
			if(i == k - 1) {
				return queue.poll();
			}
			queue.poll();
		}
		return 0;
		
	}
}
