package com.leetcode.LargestDivisibleSubset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset2 {

	public static void main(String[] args) {
		
		int[] nums = {4,8,10,240};
		List<Integer> ans = largestDivisibleSubset(nums);
		for(int i = 0;i<ans.size();i++){
			System.out.print(ans.get(i) + " ");
		}

	}
	
	public static List<Integer> largestDivisibleSubset(int[] nums) {
		
		if(nums == null || nums.length == 0){
			return new ArrayList<Integer>();
		}
		Arrays.sort(nums);
		List[] dp = new List[nums.length + 1];
		List<Integer> cur = new ArrayList<Integer>();
		cur.add(nums[0]);
		int max = 1;
		dp[1] = cur;
		for(int i = 2;i<=nums.length;i++){
			List<Integer> temp = new ArrayList<Integer>();
			int curMax = 0;
			int addIndex = 0;
			for(int index = i-1;index>0;index--){
				if(nums[i-1] % nums[index-1] == 0){
					if(dp[index].size()+1 > curMax){
						curMax = dp[index].size();
						addIndex = index;
					}
				}
			}
			if(curMax != 0){
				temp.addAll(dp[addIndex]);
			}
			temp.add(nums[i-1]);
			dp[i] = temp;
			max = Math.max(max, temp.size());
		}
		List<Integer> ans = null ;
		for(int i = nums.length;i>=1;i--){
			if(dp[i].size() == max){
				ans = dp[i];
				break;
			}
		}
		return ans;
	}

}
