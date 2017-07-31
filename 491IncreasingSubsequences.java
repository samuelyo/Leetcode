package com.leetcode.IncreasingSubsequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class IncreasingSubsequences {

	public static void main(String[] args) {
		
		int[] nums = {4,3,2,1};
		List<List<Integer>> res = findSubsequences(nums);
		for(int i = 0;i<res.size();i++){
			List<Integer> list = res.get(i);
			for(int j = 0;j<list.size();j++){
				System.out.print(list.get(j) + " ");
			}
			System.out.println();
		}

	}
	
	public static List<List<Integer>> findSubsequences(int[] nums) {
		
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		Set<List<Integer>> ansSet = new HashSet<List<Integer>>();
		Queue<Integer> queue = new LinkedList<Integer>();
		if(nums == null || nums.length == 0){
			return ans;
		}
		for(int i = 0;i<nums.length - 1;i++){
			ans.clear();
			List<Integer> list = new ArrayList<Integer>();
			list.add(nums[i]);
			ans.add(list);
			queue.add(i);
			while(!queue.isEmpty()){
				List<List<Integer>> pre = new ArrayList<List<Integer>>();
				int len = ans.get(ans.size() - 1).size();
				int index = ans.size() - 1;
				while(index >= 0 && ans.get(index).size() == len){
					pre.add(0, ans.get(index));
					index --;
				}
				for(int j = 0;j<pre.size();j++){
					List<Integer> cur = pre.get(j);
					int last = cur.get(cur.size() - 1);
					int lastIndex = queue.poll();
					for(int k = lastIndex + 1;k<nums.length;k++){
						if(nums[k] >= last){
							List<Integer> newList = new ArrayList<Integer>(cur);
							newList.add(nums[k]);
							queue.add(k);
							if(newList.size() > 1){
								ansSet.add(newList);
							}
							ans.add(newList);
						}
					}
				}
			}
		}
		return new ArrayList<List<Integer>>(ansSet);
	}

}
