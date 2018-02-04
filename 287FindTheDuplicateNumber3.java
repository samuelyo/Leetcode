package com.leetcode.FindTheDuplicateNumber;

import java.util.HashMap;
import java.util.Map;

public class FindTheDuplicateNumber3 {

	public static void main(String[] args) {
		
		int[] nums = {1,3,3,2,4};
		System.out.println(findDuplicate(nums));

	}
	
	public static int findDuplicate(int[] nums) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0;i<nums.length;i++) {
			if(map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			}else {
				map.put(nums[i], 1);
			}
		}
		for(Integer key : map.keySet()) {
			if(map.get(key) > 1) {
				return key;
			}
		}
		return 0;
		
	}

}
