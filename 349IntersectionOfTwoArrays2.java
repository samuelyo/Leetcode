package com.leetcode.intersectionoftwoarrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class IntersectionOfTwoArrays2 {

	public static void main(String[] args) {
		
		int[] nums1 = {};
		int[] nums2 = {};
		int[] res = intersection(nums1, nums2);
		System.out.println(Arrays.toString(res));
	}
	
	public static int[] intersection(int[] nums1,int[] nums2){
		
		Set<Integer> set = new HashSet<>();
		Set<Integer> intersect = new HashSet<>();
		for (int i = 0; i < nums1.length; i++) {
			set.add(nums1[i]);
		}
		for (int i = 0; i < nums2.length; i++) {
			if (set.contains(nums2[i])) {
				intersect.add(nums2[i]);
			}
		}
		int[] result = new int[intersect.size()];
		int i = 0;
		for (Integer num : intersect) {
			result[i++] = num;
		}
		return result;
	}
}
