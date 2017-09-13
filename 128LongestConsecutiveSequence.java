package com.leetcode.LongestConsecutiveSequence;

import java.util.TreeSet;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		
		int[] nums = {100, 4, 200, 1, 3, 2};
		System.out.println(longestConsecutive(nums));

	}
	
	public static int longestConsecutive(int[] nums) {
		
		TreeSet<Integer> set = new TreeSet<Integer>();
		for(int i = 0;i<nums.length;i++){
			set.add(nums[i]);
		}
		if(set.size() == 0){
			return 0;
		}
		int start = set.first();
		int maxLen = Integer.MIN_VALUE;
		int end = 0;
		while(!set.isEmpty()){
			Integer cur = set.pollFirst();
			if(set.size() == 0 || set.first() != cur + 1){
				end = cur;
				maxLen = Math.max(maxLen, end - start + 1);
				if(set.size() != 0){
					start = set.first();
				}
				
			}
		}
		return maxLen;
		
	}

}
