package com.leetcode.intersectionoftwoarrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class IntersectionOfTwoArrays4 {

	public static void main(String[] args) {
		
		int[] nums1 = {};
		int[] nums2 = {};
		int[] res = intersection(nums1, nums2);
		System.out.println(Arrays.toString(res));
	}
	
	public static int[] intersection(int[] nums1,int[] nums2){
		
		Set<Integer> set = new HashSet<>();
		Arrays.sort(nums2);
		for (Integer num : nums1) {
			if (binarySearch(nums2, num)) {
				set.add(num);
			}
		}
		int i = 0;
		int[] result = new int[set.size()];
		for (Integer num : set) {
			result[i++] = num;
		}
		return result;
	}
	
	public static boolean binarySearch(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				return true;
			}
			if (nums[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return false;
	}
}
