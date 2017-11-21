package com.leetcode.InterSectionOfTwoArraysII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterSectionOfTwoArraysII3 {

	public static void main(String[] args) {
		
		int[] nums1 = {1,2,2,1,3,3,1};
		int[] nums2 = {2,2,1,3};
		int[] res = intersect(nums1, nums2);
		System.out.println(Arrays.toString(res));
		
	}
	
	public static int[] intersect(int[] nums1, int[] nums2) {
		
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		List<Integer> res = new ArrayList<Integer>();
		int index1 = 0;
		int index2 = 0;
		while(index1 < nums1.length && index2 < nums2.length) {
			if(nums1[index1] == nums2[index2]) {
				res.add(nums1[index1]);
				index1 ++;
				index2 ++;
			}else if(nums1[index1] < nums2[index2]) {
				index1 ++;
			}else {
				index2 ++;
			}
		}
		int[] ans = new int[res.size()];
		for(int i = 0;i<res.size();i++) {
			ans[i] = res.get(i);
		}
		return ans;
		
	}

}
