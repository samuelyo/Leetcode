package com.leetcode.FindKPairsWithSmallestSums;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums3 {

	public static void main(String[] args) {
		
		int[] nums1 = {1,7,11};
		int[] nums2 = {2,4,6};
		int k = 3;
		List<int[]> res = kSmallestPairs(nums1, nums2, k);
		for(int i = 0;i<res.size();i++){
			System.out.println(res.get(i)[0] + " " + res.get(i)[1]);
		}

	}
	
	public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				int sum1 = o1[0] + o1[1];
				int sum2 = o2[0] + o2[1];
				return sum1 - sum2;
			}
		});
		for(int i = 0;i<nums1.length;i++) {
			for(int j = 0;j<nums2.length;j++) {
				queue.add(new int[]{nums1[i], nums2[j]});
			}
		}
		List<int[]> res = new ArrayList<int[]>();
		while(!queue.isEmpty() && k > 0) {
			res.add(queue.poll());
			k--;
		}
		return res;
		
	}

}
