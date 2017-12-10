package com.leetcode.LongestHarmoniousSubsequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestHarmoniousSubsequence3 {

	public static void main(String[] args) {
		
		int[] nums = {1,3,2,2,5,2,3,7};
		System.out.println(findLHS(nums));

	}
	
	public static int findLHS(int[] nums) {
		
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for(int i = 0;i<nums.length;i++) {
			if(map.containsKey(nums[i])) {
				map.get(nums[i]).add(i);
			}else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(nums[i], list);
			}
		}
		int res = 0;
		for(Integer key : map.keySet()) {
			if(map.containsKey(key + 1)) {
				res = Math.max(res, map.get(key).size() + map.get(key + 1).size());
			}
		}
		return res;
		
	}

}
