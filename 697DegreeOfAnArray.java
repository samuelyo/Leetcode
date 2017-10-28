package com.leetcode.DegreeOfAnArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DegreeOfAnArray {

	public static void main(String[] args) {
		
		int[] nums = {1,2,2,3,1,4,2};
		System.out.println(findShortestSubArray(nums));

	}
	
	public static int findShortestSubArray(int[] nums) {
		
		Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
		for(int i = 0;i<nums.length;i++) {
			if(map.containsKey(nums[i])) {
				List<Integer> list = map.get(nums[i]);
				list.add(i);
				map.put(nums[i], list);
			}else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(nums[i], list);
			}
		}
		int maxTimes = 0;
		for(Integer key : map.keySet()) {
			maxTimes = Math.max(maxTimes, map.get(key).size());
		}
		int res = nums.length;
		for(Integer key : map.keySet()) {
			if(map.get(key).size() == maxTimes) {
				List<Integer> list = map.get(key);
				res = Math.min(res, list.get(list.size() - 1) - list.get(0) + 1);
			}
		}
		return res;
		
	}

}
