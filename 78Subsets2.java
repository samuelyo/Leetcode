package com.leetcode.Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {

	public static void main(String[] args) {
		
		int[] nums = {1,2,3};
		List<List<Integer>> subsets = subsets(nums);
		for(int i = 0;i<subsets.size();i++){
			List<Integer> sub = subsets.get(i);
			for(int j = 0;j<sub.size();j++){
				System.out.print(sub.get(j) + " ");
			}
			System.out.println();
		}

	}

	/**
	 * 0) 0 0 0  -> Dont take 3 , Dont take 2 , Dont take 1 = { } 
	 * 1) 0 0 1  -> Dont take 3 , Dont take 2 ,   take 1       =  {1 } 
	 * 2) 0 1 0  -> Dont take 3 ,    take 2       , Dont take 1 = { 2 } 
	 * 3) 0 1 1  -> Dont take 3 ,    take 2       ,      take 1    = { 1 , 2 } 
	 * 4) 1 0 0  ->    take 3      , Dont take 2  , Dont take 1 = { 3 } 
	 * 5) 1 0 1  ->    take 3      , Dont take 2  ,     take 1     = { 1 , 3 } 
	 * 6) 1 1 0  ->    take 3      ,    take 2       , Dont take 1 = { 2 , 3 } 
	 * 7) 1 1 1  ->    take 3     ,      take 2     ,      take 1     = { 1 , 2 , 3 } 
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> subsets(int[] nums) {
		
		Arrays.sort(nums);
		//totalNumber is the number of subsets
		int totalNumber = 1 << nums.length;
		List<List<Integer>> collection = new ArrayList<List<Integer>>(totalNumber);
		for (int i=0; i<totalNumber; i++) {
			List<Integer> set = new ArrayList<Integer>();
			for (int j=0; j<nums.length; j++) {
				if ((i & (1<<j)) != 0) {
					set.add(nums[j]);
				}
			}
			collection.add(set);
		}
		return collection;
	}
}
