package com.leetcode.IncreasingSubsequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences2 {

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
		
		Set<List<Integer>> res= new HashSet<List<Integer>>();
        List<Integer> holder = new ArrayList<Integer>();
        findSequence(res, holder, 0, nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>(res);
        return result;
    }

   public static void findSequence(Set<List<Integer>> res, List<Integer> holder, int index, int[] nums) {
      
	   if (holder.size() >= 2) {
           res.add(new ArrayList<Integer>(holder));
       }
       for (int i = index; i < nums.length; i++) {
           if(holder.size() == 0 || holder.get(holder.size() - 1) <= nums[i]) {
               holder.add(nums[i]);
               findSequence(res, holder, i + 1, nums);
               holder.remove(holder.size() - 1);
           }
       }
       
	}

}
