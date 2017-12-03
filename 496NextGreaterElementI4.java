package com.leetcode.NextGreaterElementI;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI4 {

	public static void main(String[] args) {
		
		int[] nums1 = {2,4};
		int[] nums2 = {1,2,3,4};
		int[] res = nextGreaterElement(nums1, nums2);
		System.out.println(Arrays.toString(res));

	}

	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		
		int[] res = new int[nums1.length];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0;i<nums2.length;i++) {
			while(!stack.isEmpty() && stack.peek() < nums2[i]) {
				map.put(stack.pop(), nums2[i]);
			}
			stack.push(nums2[i]);
		}
		for(int i = 0;i<nums1.length;i++) {
			if(map.containsKey(nums1[i])) {
				res[i] = map.get(nums1[i]);
			}else {
				res[i] = -1;
			}
		}
		return res;
		
	}
}
