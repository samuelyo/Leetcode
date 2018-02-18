package com.leetcode.ShuffleAnArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Solution3 {

	int[] old;
	List<Integer> list = new ArrayList<Integer>();
	
	public Solution3(int[] nums) {
        
		old = Arrays.copyOf(nums, nums.length);
		for(int i = 0;i<nums.length;i++) {
			list.add(nums[i]);
		}
		
    }

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {

		return old;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {

		int[] res = new int[old.length];
		List<Integer> temp = new ArrayList<Integer>(list);
		for(int i = 0;i<res.length;i++) {
			int index = new Random().nextInt(temp.size());
			res[i] = temp.get(index);
			temp.remove(index);
		}
		return res;
		
	}
}
