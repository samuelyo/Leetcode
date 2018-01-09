package com.leetcode.SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII4 {

	public static void main(String[] args) {
		
		int[] nums = {1,2,2};
		List<List<Integer>> ans = subsetsWithDup(nums);
		for(int i = 0;i<ans.size();i++){
			List<Integer> res = ans.get(i);
			for(int j = 0;j<res.size();j++){
				System.out.print(res.get(j) + " ");
			}
			System.out.println();
		}

	}
	
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(nums);
		subsetsWithDupHelp(res, list, nums, 0);
		return res;
		
	}
	
	public static void subsetsWithDupHelp(List<List<Integer>> res, List<Integer> list, int[] nums, int start) {
		
		res.add(new ArrayList<Integer>(list));
		
		for(int i = start;i<nums.length;i++) {
			list.add(nums[i]);
			subsetsWithDupHelp(res, list, nums, i + 1);
			list.remove(list.size() - 1);
			int temp = i + 1;
			while(temp < nums.length && nums[temp] == nums[temp - 1]) {
				temp ++;
			}
			i = temp - 1;
		}
		
	}

}
