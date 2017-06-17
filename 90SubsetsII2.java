package com.leetcode.SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII2 {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 2, 2 };
		List<List<Integer>> ans = subsetsWithDup(nums);
		for (int i = 0; i < ans.size(); i++) {
			List<Integer> res = ans.get(i);
			for (int j = 0; j < res.size(); j++) {
				System.out.print(res.get(j) + " ");
			}
			System.out.println();
		}

	}

	public static List<List<Integer>> subsetsWithDup(int[] nums) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> empty = new ArrayList<Integer>();
		result.add(empty);
		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			int dupCount = 0;
			while (((i + 1) < nums.length) && nums[i + 1] == nums[i]) {
				dupCount++;
				i++;
			}
			int prevNum = result.size();
			for (int j = 0; j < prevNum; j++) {
				List<Integer> element = new ArrayList<Integer>(result.get(j));
				for (int t = 0; t <= dupCount; t++) {
					element.add(nums[i]);
					result.add(new ArrayList<Integer>(element));
				}
			}
		}
		return result;
	}
}
