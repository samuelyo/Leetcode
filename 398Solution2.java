package com.leetcode.RandomPickIndex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Solution2 {

	Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
	
	public Solution2(int[] nums) {
		
		for(int i = 0;i<nums.length;i++) {
			if(map.containsKey(nums[i])) {
				map.get(nums[i]).add(i);
			}else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(nums[i], list);
			}
		}
	}

	public int pick(int target) {

		List<Integer> list = map.get(target);
		int index = new Random().nextInt(list.size());
		return list.get(index);
		
	}

}
