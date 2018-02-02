package com.leetcode.SingleNumberIII;

import java.util.HashMap;
import java.util.Map;

public class SingleNumberIII3 {

	public static void main(String[] args) {
		
		int[] nums = {1,2,1,3,2,5};
		int[] res = singleNumber(nums);
		for(int i = 0;i<res.length;i++){
			System.out.print(res[i] + " ");
		}

	}
	
	public static int[] singleNumber(int[] nums) {
		
		int[] res = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0;i<nums.length;i++) {
			int cur = nums[i];
			if(map.containsKey(cur)) {
				map.put(cur, map.get(cur) + 1);
			}else {
				map.put(cur, 1);
			}
		}
		int index = 0;
		for(Integer key : map.keySet()) {
			if(map.get(key) == 1) {
				res[index] = key;
				index ++;
			}
		}
		return res;
		
	}

}
