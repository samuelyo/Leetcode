package com.leetcode.WiggleSortII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WiggleSortII3 {

	public static void main(String[] args) {
		
		int[] nums = {4,5,5,6};
		wiggleSort(nums);
		for(int i = 0;i<nums.length;i++){
			System.out.print(nums[i] + " ");
		}

	}

	public static void wiggleSort(int[] nums) {
		
		List<Integer> list = new ArrayList<Integer>();
		for(int num : nums) {
			list.add(num);
		}
		Collections.sort(list);
		int size = list.size();
		int start = size % 2 == 0 ? size / 2 : size / 2 + 1;
		int index = 0;
		for(int i = 0;i<start;i++) {
			nums[index] = list.get(i);
			index += 2;
		}
		index = 1;
		for(int i = start;i<list.size();i++) {
			nums[index] = list.get(i);
			index += 2;
		}
		boolean isValid = true;
		for(int i = 1;i<nums.length;i++) {
			if(nums[i] == nums[i - 1]) {
				isValid = false;
				break;
			}
		}
		if(!isValid) {
			index = 0;
			for(int i = start - 1;i>=0;i--) {
				nums[index] = list.get(i);
				index += 2;
			}
			index = 1;
			for(int i = list.size() - 1;i>=start;i--) {
				nums[index] = list.get(i);
				index += 2;
			}
		}
	}
}
