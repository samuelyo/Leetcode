package com.leetcode.NumberOfLongestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NumberOfLongestIncreasingSubsequence {

	public static void main(String[] args) {

		int[] nums = {2,2,2,2,2};
		System.out.println(findNumberOfLIS(nums));

	}

	public static int findNumberOfLIS(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}
		int max = 1;
		int len = nums.length;
		int[] dp = new int[len + 1];
		Arrays.fill(dp, 1);
		for (int i = 2; i <= len; i++) {
			for (int j = i - 1; j >= 1; j--) {
				if (nums[i - 1] > nums[j - 1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
		for(int i = 1;i<=len;i++) {
			Set<Integer> set ;
			if(map.containsKey(dp[i])){
				set = map.get(dp[i]);
			}else{
				set = new HashSet<Integer>();
			}
			set.add(i);
			map.put(dp[i], set);
		}
		if(max == 1) {
			return map.get(1).size();
		}
		int count = 0;
		Set<Integer> set = map.get(max);
		for(Integer index : set) {
			List<List<Integer>> res = new ArrayList<List<Integer>>();
			List<Integer> list = new ArrayList<Integer>();
			list.add(nums[index - 1]);
			BackTracking(res, list, map, index, dp, nums);
			count += res.size();
		}
		return count;
	}
	
	public static void BackTracking(List<List<Integer>> res, List<Integer> list, Map<Integer,Set<Integer>> map, Integer index, int[] dp, int[] nums) {
		
		if(dp[index] == 1) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		Set<Integer> set = map.get(dp[index] - 1);
		for(Integer cur : set) {
			if(cur < index && nums[cur - 1] < list.get(list.size() - 1)) {
				list.add(nums[cur - 1]);
				BackTracking(res, list, map, cur, dp, nums);
				list.remove(list.size() - 1);
			}
		}
		
	}
}
