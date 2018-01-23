package com.leetcode.LargestNumber;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LargestNumber3 {

	public static void main(String[] args) {

		int[] nums = {3, 30, 34, 5, 9};
		String res = largestNumber(nums);
		System.out.println(res);

	}
	
	public static String largestNumber(int[] nums) {
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer num1, Integer num2) {
				String s1 = "" + num1 + num2;
				String s2 = "" + num2 + num1;
				int index = 0;
				while(index < s1.length()) {
					char c1 = s1.charAt(index);
					char c2 = s2.charAt(index);
					if(c1 > c2) {
						return -1;
					}else if(c1 < c2) {
						return 1;
					}
					index ++;
				}
				return 0;
			}
		});
		for(int i = 0;i<nums.length;i++) {
			queue.add(nums[i]);
		}
		String res = "";
		while(!queue.isEmpty()) {
			res += "" + queue.poll(); 
		}
		int index = 0;
		while(index < res.length() && res.charAt(index) == '0') {
			index ++;
		}
		return index == res.length() ? "0" : res.substring(index);
		
	}

}
