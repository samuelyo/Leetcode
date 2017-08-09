package com.leetcode.Permutations;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		
		int[] nums = {1,2,3};
		
		List<List<Integer>> ans = permute(nums);
		for(int i = 0;i<ans.size();i++){
			List<Integer> list = ans.get(i);
			for(int j = 0;j<list.size();j++){
				System.out.print(list.get(j) + " ");
			}
			System.out.println();
		}

	}
	
	public static List<List<Integer>> permute(int[] nums) {
		
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0){
			return ans;
		}
		List<Integer> list = new ArrayList<Integer>();
		boolean[] used = new boolean[nums.length];
		permuteHelp(ans, list, used, nums);
		return ans;
		
	}

	public static void permuteHelp(List<List<Integer>> ans, List<Integer> list, boolean[] used, int[] nums) {
		
		if(list.size() == used.length){
			ans.add(new ArrayList<Integer>(list));
			return ;
		}
		
		for(int i = 0;i<used.length;i++){
			if(used[i] == false){
				list.add(nums[i]);
				used[i] = true;
				permuteHelp(ans, list, used, nums);
				list.remove(list.size() - 1);
				used[i] = false;
			}
		}
		
	}

}
