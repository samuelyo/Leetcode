package com.leetcode.FindKPairsWithSmallestSums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {

	public static void main(String[] args) {
		
		int[] nums1 = {};
		int[] nums2 = {};
		int k = 5;
		List<int[]> res = kSmallestPairs(nums1, nums2, k);
		for(int i = 0;i<res.size();i++){
			System.out.println(res.get(i)[0] + " " + res.get(i)[1]);
		}

	}

	public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		
		PriorityQueue<int[]> pairs = new PriorityQueue<int[]>(k + 1, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				int sum1 = o1[0] + o1[1];
				int sum2 = o2[0] + o2[1];
				return sum2 - sum1;
			}
		});
		for(int i = 0;i<nums1.length;i++){
			for(int j = 0;j<nums2.length;j++){
				pairs.add(new int[]{nums1[i], nums2[j]});
				if(pairs.size() > k){
					pairs.poll();
				}
			}
		}
		
		List<int[]> list = new ArrayList<int[]>();
		for(int i = 0;i<k;i++){
			if(pairs.peek() != null){
				list.add(pairs.poll());
			}
		}
		Collections.reverse(list);
		return list;
		
	}
}
