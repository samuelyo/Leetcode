package com.leetcode.SummaryRanges;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges3 {

	public static void main(String[] args) {
		
		int[] nums = {0,2,3,4,6,8,9};
		List<String> ans = summaryRanges(nums);
		for(int i = 0;i<ans.size();i++){
			System.out.println(ans.get(i));
		}

	}

	public static List<String> summaryRanges(int[] nums) {
		
		List<String> res = new ArrayList<String>();
		if(nums == null || nums.length == 0) {
			return res;
		}
		int start = 0;
		while(start < nums.length) {
			int temp = start;
			int value = nums[start];
			value ++;
			temp ++;
			while(temp < nums.length && nums[temp] == value) {
				temp ++;
				value ++;
			}
			if(start == temp - 1) {
				res.add("" + nums[start]);
			}else {
				res.add("" + nums[start] + "->" + nums[temp - 1]);
			}
			start = temp;
		}
		return res;
		
	}
}
