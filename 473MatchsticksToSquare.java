package com.leetcode.MatchsticksToSquare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatchsticksToSquare {

	public static void main(String[] args) {
		
		int[] nums = {5,5,5,5,16,4,4,4,4,4,3,3,3,3,4};
		System.out.println(makesquare(nums));
	}
	
	public static boolean makesquare(int[] nums) {
		
		int sum = 0;
		for(int i = 0;i<nums.length;i++){
			sum += nums[i];
		}
		if(sum % 4 != 0){
			return false;
		}else{
			int len = sum / 4;
			int lenCount = 0;
			List<Integer> numList = new ArrayList<Integer>();
			for(int i = 0;i<nums.length;i++){
				if(nums[i] == len){
					lenCount ++;
				}else if(nums[i] > len){
					return false;
				}else{
					numList.add(nums[i]);
				}
			}
			int num = 4 - lenCount;
			if(num == 0){
				return true;
			}else{
				Collections.sort(numList);
				List<List<Integer>> res = new ArrayList<List<Integer>>();
				List<Integer> temp = new ArrayList<Integer>();
				boolean[] used = new boolean[numList.size()];
				makesquareHelp(res, temp, numList, len, 0, used);
				if(res.size() >= num){
					for(int i = 0;i<numList.size();i++){
						boolean in = false;
						for(int j = 0;j<res.size();j++){
							if(res.get(j).contains(numList.get(i))){
								in = true;
								break;
							}
						}
						if(in == false){
							return false;
						}
					}
					return true;
				}else{
					return false;
				}
			}
			
			
		}
		
	}
	
	public static void makesquareHelp(List<List<Integer>> res, List<Integer> temp, List<Integer> numList, int sum, int start, boolean[] used) {
		
		if(sum == 0){
			res.add(new ArrayList<Integer>(temp));
			return ;
		}
		for(int i = start;i<numList.size();i++){
			if(used[i] == false){
				temp.add(numList.get(i));
				used[i] = true;
				makesquareHelp(res, temp, numList, sum - numList.get(i), i+1, used);
				temp.remove(temp.size() - 1);
				used[i] = false;
			}
			
		}
	}

}
