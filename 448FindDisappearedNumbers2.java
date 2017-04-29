package com.leetcode.findallnumbersdisappeared;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindDisappearedNumbers2 {

	public static void main(String[] args) {
		
		int[] nums = {4,3,2,7,8,2,3,1};
		List<Integer> list = findDisappearedNumbers(nums);
		for(int i = 0;i<list.size();i++){
			System.out.print(list.get(i) + " ");
		}
	}
	
	public static List<Integer> findDisappearedNumbers(int[] nums){
		/**
		 * In the first loop, 
		 * the number in the position of an existing number will be set as negative, 
		 * in order to indicate that number has been found in the array.
		 * In the second iteration, 
		 * if a value is not marked as negative, 
		 * it implies we have never seen that index before, 
		 * so just add it to the return list.
		 */
		List<Integer> ret = new ArrayList<Integer>();

		for (int i = 0; i < nums.length; i++) {
			int val = Math.abs(nums[i]) - 1;  //index
			if (nums[val] > 0) {
				nums[val] = -nums[val];
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				ret.add(i + 1);
			}
		}
		return ret;
    
	
	}

}
