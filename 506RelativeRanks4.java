package com.leetcode.RelativeRanks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RelativeRanks4 {

	public static void main(String[] args) {
		
		int[] nums = {5,4,3,2,1};
		String[] res = findRelativeRanks(nums);
		System.out.println(Arrays.toString(res));

	}

	public static String[] findRelativeRanks(int[] nums) {
		
		List<int[]> list = new ArrayList<int[]>();
		for(int i = 0;i<nums.length;i++) {
			list.add(new int[]{i, nums[i], 0});
		}
		Collections.sort(list, new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1] - o1[1];
			}
			
		});
		for(int i = 0;i<list.size();i++) {
			int[] cur = list.get(i);
			cur[2] = i;
		}
		Collections.sort(list, new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
			
		});
		String[] res = new String[list.size()];
		for(int i = 0;i<res.length;i++) {
			int[] cur = list.get(i);
			if(cur[2] == 0) {
				res[i] = "Gold Medal";
			}else if(cur[2] == 1) {
				res[i] = "Silver Medal";
			}else if(cur[2] == 2) {
				res[i] = "Bronze Medal";
			}else {
				res[i] = cur[2] + 1 + "";
			}
		}
		return res;
		
	}
}
