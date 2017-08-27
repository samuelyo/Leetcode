package com.leetcode.WiggleSortII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WiggleSortII {

	public static void main(String[] args) {
		
		int[] nums = {4,5,5,6};
		wiggleSort(nums);
		for(int i = 0;i<nums.length;i++){
			System.out.print(nums[i] + " ");
		}

	}

	public static void wiggleSort(int[] nums) {
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0;i<nums.length;i++){
			list.add(nums[i]);
		}
		Collections.sort(list);
		int len = nums.length;
		int start;
		if(len % 2 == 0){
			start = len / 2;
		}else{
			start = len / 2 + 1;
		}
		int indexIn = start;
		for(int i = 1;i<nums.length;i+=2){
			nums[i] = list.get(indexIn);
			indexIn ++;
		}
		int index = 0;
		for(int i = 0;i<nums.length;i+=2){
			nums[i] = list.get(index);
			index ++;
		}
		boolean isValid = true;
		for(int i = 0;i<nums.length - 1;i++){
			if(nums[i] == nums[i+1]){
				isValid = false;
				break;
			}
		}
		if(!isValid){
			int indexIndex = nums.length - 1;
			for(int i = 1;i<nums.length;i+=2){
				nums[i] = list.get(indexIndex);
				indexIndex --;
			}
			int indexindex = start - 1;
			for(int i = 0;i<nums.length;i+=2){
				nums[i] = list.get(indexindex);
				indexindex --;
			}
		}
	}
}
