package com.leetcode.FindKPairsWithSmallestSums;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums4 {

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
		
		List<int[]> res = new ArrayList<int[]>();
		if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0) {
			return res;
		}
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				int sum1 = o1[0] + o1[1];
				int sum2 = o2[0] + o2[1];
				return sum1 - sum2;
			}
		});
		for(int i = 0;i<nums1.length;i++) {
			queue.add(new int[]{nums1[i], nums2[0], 1});
		}
		while(!queue.isEmpty() && k > 0) {
			int[] cur = queue.poll();
			res.add(new int[]{cur[0], cur[1]});
			if(cur[2] < nums2.length) {
				queue.add(new int[]{cur[0], nums2[cur[2]], cur[2] + 1});
			}
			k--;
		}
		return res;
		
	}

}
