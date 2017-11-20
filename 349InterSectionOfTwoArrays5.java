package com.leetcode.InterSectionOfTwoArrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InterSectionOfTwoArrays5 {

	public static void main(String[] args) {
		
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
		int[] res = intersection(nums1, nums2);
		System.out.println(Arrays.toString(res));

	}
	
	public static int[] intersection(int[] nums1, int[] nums2) {
		
		Set<Integer> set1 = new HashSet<Integer>();
		for(int i = 0;i<nums1.length;i++) {
			set1.add(nums1[i]);
		}
		Set<Integer> set2 = new HashSet<Integer>();
		for(int i = 0;i<nums2.length;i++) {
			set2.add(nums2[i]);
		}
		Set<Integer> res = new HashSet<Integer>();
		for(Integer i : set1) {
			if(set2.contains(i)) {
				res.add(i);
			}
		}
		for(Integer i : set2) {
			if(!res.contains(i) && set1.contains(i)) {
				res.add(i);
			}
		}
		int size = res.size();
		int[] ans = new int[size];
		int index = 0;
		for(Integer i : res) {
			ans[index] = i;
			index ++;
		}
		return ans;
		
	}

}
