package com.leetcode.TwentyFourGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwentyFourGame {

	public static final double eps = 0.001;

	public static void main(String[] args) {
		
		int[] nums = {3,3,8,8};
		System.out.println(judgePoint24(nums));

	}
	
	public static boolean judgePoint24(int[] nums) {
		
		List<Double> list = new ArrayList<Double>();
		for(int i = 0;i<nums.length;i++) {
			list.add((double) nums[i]);
		}
		return judgePoint24Help(list);
		
	}
	
	public static boolean judgePoint24Help(List<Double> nums) {
		
		if(nums.size() == 1) {
			if(Math.abs(nums.get(0) - 24.0) < eps) {
				return true;
			}else{
				return false;
			}
		}
		
		for(int i = 0;i<nums.size();i++) {
			for(int j = i+1;j<nums.size();j++) {
				List<Double> temp = new ArrayList<Double>();
				Double iValue = nums.get(i);
				Double jValue = nums.get(j);
				temp.addAll(new ArrayList<Double>(Arrays.asList(iValue + jValue,iValue - jValue,jValue - iValue,iValue * jValue)));
				if(Math.abs(jValue) > eps) {
					temp.add(iValue / jValue);
				}
                if(Math.abs(iValue) > eps) {
                	temp.add(jValue / iValue);
                }
				nums.remove(iValue);
				nums.remove(jValue);
				for(Double v : temp) {
					nums.add(v);
					if(judgePoint24Help(nums)) {
						return true;
					}
					nums.remove(nums.size() - 1);
				}
				nums.add(i, iValue);
				nums.add(j, jValue);
			}
		}
		
		return false;
		
	}

}
