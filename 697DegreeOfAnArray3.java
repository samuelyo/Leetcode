package com.leetcode.DegreeOfAnArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DegreeOfAnArray3 {

	public static void main(String[] args) {
		
		int[] nums = {1, 2, 2, 3, 1};
		System.out.println(findShortestSubArray(nums));

	}

	public static int findShortestSubArray(int[] nums) {
		
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		int max = 0;
		for(int i = 0;i<nums.length;i++) {
			if(map.containsKey(nums[i])) {
				List<Integer> list = map.get(nums[i]);
				list.add(i);
			}else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(nums[i], list);
			}
			max = Math.max(max, map.get(nums[i]).size());
		}
		int res = Integer.MAX_VALUE;
		for(Integer key : map.keySet()) {
			if(map.get(key).size() == max) {
				List<Integer> list = map.get(key);
				res = Math.min(res, list.get(list.size() - 1) - list.get(0) + 1);
			}
		}
		return res;
		
	}
}
