package com.leetcode.containsduplicate;


import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate2 {

	public static void main(String[] args) {
		
		int[] nums = {1,1};
		System.out.println(containsDuplicate(nums));
	}
	
	public static boolean containsDuplicate(int[] nums){
		
		final Set<Integer> distinct = new HashSet<Integer>();
	    for(int num : nums) {
	        if(distinct.contains(num)) {
	            return true;
	        }
	        distinct.add(num);
	    }
	    return false;
	}
}
