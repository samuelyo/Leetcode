package com.leetcode.NextGreaterElementI;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NextGreaterElementI3 {

	public static void main(String[] args) {
		
		int[] nums1 = {2,4};
		int[] nums2 = {1,2,3,4};
		int[] res = nextGreaterElement(nums1, nums2);
		System.out.println(Arrays.toString(res));

	}

	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		
		int[] res = new int[nums1.length];
		List<Integer> list = new LinkedList<Integer>();
		for(Integer i : nums2) {
			list.add(i);
		}
		int count = 0;
		for(Integer i : nums1) {
			int index = list.indexOf(i);
			int j ;
			for(j = index + 1;j<nums2.length;j++) {
				if(list.get(j) > i) {
					res[count] = list.get(j);
					break;
				}
			}
			if(j == nums2.length) {
				res[count] = -1;
			}
			count ++;
		}
		return res;
		
	}
}
