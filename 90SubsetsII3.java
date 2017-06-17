package com.leetcode.SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII3 {

	public static void main(String[] args) {
		
		int[] nums = {1,2,2,2};
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
		
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0){
			return ans;
		}
		Arrays.sort(nums);
		backTrack(ans,new ArrayList<Integer>(),nums,0);
		return ans;
		
	}
	
	public static void backTrack(List<List<Integer>> ans,List<Integer> res,int[] nums,int index){
		
		ans.add(new ArrayList<Integer>(res));
		for(int i = index;i<nums.length;i++){
			if(i > index && nums[i] == nums[i-1]){  // i > index
				continue;
			}
			res.add(nums[i]);
			backTrack(ans, res, nums, i + 1);
			res.remove(res.size()-1);
			
		}
	}
}
