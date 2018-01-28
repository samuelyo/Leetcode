package com.leetcode.ContainsDuplicateIII;

import java.util.TreeSet;

public class ContainsDuplicateIII4 {

	public static void main(String[] args) {
		
		int[] nums = {-1, 2147483647};
		int k = 1;
		int t = 2147483647;
		System.out.println(containsNearbyAlmostDuplicate(nums, k, t));

	}
	
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		
		if(nums == null || nums.length == 0 || k < 0) {
			return false;
		}
		TreeSet<Long> set = new TreeSet<Long>();
		for(int i = 0;i<nums.length;i++) {
			Long floor = set.floor((long)((long)nums[i] + t));
			Long ceiling = set.ceiling((long)((long)nums[i] - t));
			if(floor != null && floor >= (long)nums[i] || ceiling != null && ceiling <= (long)nums[i]) {
				return true;
			}
			set.add((long)nums[i]);
			if(i >= k) {
				set.remove((long)nums[i - k]);
			}
		}
		return false;
		
	}

}
