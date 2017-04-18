package com.leetcode.mergesortedarray;

import java.util.Arrays;

public class MergeSortedArray2 {

	public static void main(String[] args) {
		int[] nums1 = new int[]{-1, 0, 1, 1, 0, 0, 0, 0, 0};
		int[] nums2 = new int[]{-1,0,2,2,3};
		int m = 4;
		int n = 5;
		merge(nums1, m, nums2, n);
		System.out.println(Arrays.toString(nums1));
	}
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		
		int i = m-1;
		int j = n-1;
		int k = m+n-1;
		while(i >= 0 && j>= 0)
		{
			if(nums1[i] > nums2[j])
				nums1[k--] = nums1[i--];
			else
				nums1[k--] = nums2[j--];
		}
		while(j>=0)
			nums1[k--] = nums2[j--];
	}
}
