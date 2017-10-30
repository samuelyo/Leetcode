package com.leetcode.MergeSortedArray;

import java.util.Arrays;

public class MergeSortedArray5 {
//
//	//[-1,0,1,1,0,0,0,0,0]
//	4
//	[-1,0,2,2,3]
//	5
	public static void main(String[] args) {
		
		int[] nums1 = new int[]{-1, 0, 1, 1, 0, 0, 0, 0, 0};
		int[] nums2 = new int[]{-1,0,2,2,3};
		int m = 4;
		int n = 5;
		merge(nums1, m, nums2, n);
		System.out.println(Arrays.toString(nums1));
	}
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		
		int[] nums1Copy = new int[m];
		nums1Copy = Arrays.copyOf(nums1, m);
		int cur = 0;
		int index1 = 0;
		int index2 = 0;
		while(index1 < m && index2 < n) {
			if(nums1Copy[index1] <= nums2[index2]) {
				nums1[cur] = nums1Copy[index1];
				cur ++;
				index1 ++;
			}else {
				nums1[cur] = nums2[index2];
				cur ++;
				index2 ++;
			}
		}
		if(index1 == m) {
			while(index2 < n) {
				nums1[cur] = nums2[index2];
				cur ++;
				index2 ++;
			}
		}else {
			while(index1 < m) {
				nums1[cur] = nums1Copy[index1];
				cur ++;
				index1 ++;
			}
		}
	}
}
