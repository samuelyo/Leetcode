package com.leetcode.MedianOfTwoSortedArrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianOfTwoSortedArrays2 {

	public static void main(String[] args) {

		int[] nums1 = { 1, 2 };
		int[] nums2 = { 3, 4 };
		System.out.println(findMedianSortedArrays(nums1, nums2));

	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int m = nums1.length;
		int n = nums2.length;

		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0;i<m;i++) {
			list.add(nums1[i]);
		}
		for(int i = 0;i<n;i++) {
			list.add(nums2[i]);
		}
		Collections.sort(list);
		
		if((m + n) % 2 == 1) {
			return list.get((m + n) / 2);
		}else {
			return (double)( list.get((m + n) / 2) + list.get((m + n) / 2 - 1) ) / 2;
		}
	}

}
