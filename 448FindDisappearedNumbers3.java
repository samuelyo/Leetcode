package com.leetcode.FindAllNumbersDisappeared;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDisappearedNumbers3 {

	public static void main(String[] args) {
		
		int[] nums = {4,3,2,7,8,2,3,1};
		List<Integer> list = findDisappearedNumbers(nums);
		for(int i = 0;i<list.size();i++){
			System.out.print(list.get(i) + " ");
		}
	}
	
	public static List<Integer> findDisappearedNumbers(int[] nums){
		
		List<Integer> res = new ArrayList<Integer>();
		Arrays.sort(nums);
		int len = nums.length;
		for(int i = 1;i<=len;i++) {
			if(Arrays.binarySearch(nums, i) < 0) {
				res.add(i);
			}
		}
		return res;
	
	}

}
