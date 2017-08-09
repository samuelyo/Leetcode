package com.leetcode.PermutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

	public static void main(String[] args) {

		int[] nums = { 1, 1, 2 };

		List<List<Integer>> ans = permuteUnique(nums);
		for (int i = 0; i < ans.size(); i++) {
			List<Integer> list = ans.get(i);
			for (int j = 0; j < list.size(); j++) {
				System.out.print(list.get(j) + " ");
			}
			System.out.println();
		}

	}

	public static List<List<Integer>> permuteUnique(int[] nums) {

		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			return ans;
		}
		List<Integer> list = new ArrayList<Integer>();
		boolean[] used = new boolean[nums.length];
		Arrays.sort(nums);
		permuteUniqueHelp(ans, list, nums, used);
		return ans;

	}

	public static void permuteUniqueHelp(List<List<Integer>> ans, List<Integer> list, int[] nums, boolean[] used) {

		if (list.size() == nums.length) {
			ans.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
				continue;
			}
			if (used[i] == false) {
				list.add(nums[i]);
				used[i] = true;
				permuteUniqueHelp(ans, list, nums, used);
				list.remove(list.size() - 1);
				used[i] = false;
			}

		}

	}
}
