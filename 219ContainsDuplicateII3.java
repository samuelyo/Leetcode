package com.leetcode.containsduplicateII;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII3 {

	public static void main(String[] args){
		
		int[] nums = {2,3,4,5,6,7,8,2};
		System.out.println(Boolean.toString(containsNearbyDuplicate(nums, 6)));
	}
	
	public static boolean containsNearbyDuplicate(int[] nums,int k){
		/*
		 * Explanation: It iterates over the array using a sliding window. 
		 * The front of the window is at i, the rear of the window is k steps back. 
		 * The elements within that window are maintained using a set. 
		 * While adding new element to the set, 
		 * if add() returns false, it means the element already exists in the set. 
		 * At that point, we return true. 
		 * If the control reaches out of for loop, 
		 * it means that inner return true never executed, 
		 * meaning no such duplicate element was found.
		 */
		Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
	}
}
