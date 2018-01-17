package com.leetcode.SingleNumberII;

import java.util.HashMap;
import java.util.Map;

public class SingleNumberII3 {

	public static void main(String[] args) {
		
		int[] nums = {-19,-46,-19,-46,-9,-9,-19,17,17,17,-13,-13,-9,-13,-46,-28};
		System.out.println(singleNumber(nums));

	}

	public static int singleNumber(int[] nums) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0;i<nums.length;i++) {
			if(map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			}else {
				map.put(nums[i], 1);
			}
		}
		for(Integer key : map.keySet()) {
			if(map.get(key) == 1) {
				return key;
			}
		}
		return 0;
		
	}
}
