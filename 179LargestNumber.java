package com.leetcode.LargestNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {

	public static void main(String[] args) {
		
		int[] nums = {0,0};
		String res = largestNumber(nums);
		System.out.println(res);

	}
	
	public static String largestNumber(int[] nums) {
		
		StringBuilder res = new StringBuilder();
		if(nums == null || nums.length == 0){
			return res.toString();
		}
		List<String> list = new ArrayList<String>();
		for(int i = 0;i<nums.length;i++){
			list.add(numToString(nums[i]));
		}
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				
				int s1Index = 0;
				int s2Index = 0;
				while(s1Index < s1.length() && s2Index < s2.length() && s1.charAt(s1Index) == s2.charAt(s2Index)){
					s1Index ++;
					s2Index ++;
				}
				if(s1Index == s1.length() || s2Index == s2.length()){
					if(s1Index == s1.length() && s2Index == s2.length()){
						return 0;
					}else{
						StringBuilder s1S2 = new StringBuilder(s1);
						s1S2.append(s2);
						StringBuilder s2S1 = new StringBuilder(s2);
						s2S1.append(s1);
						int index1 = 0;
						int index2 = 0;
						while(index1 < s1S2.length() && index2 < s2S1.length() && s1S2.charAt(index1) == s2S1.charAt(index2)){
							index1 ++;
							index2 ++;
						}
						if(index1 == s1S2.length()){
							return 0;
						}else if(s1S2.charAt(index1) > s2S1.charAt(index2)){
							return -1;
						}else {
							return 1;
						}
					}
				}else{
					return s2.charAt(s2Index) - s1.charAt(s1Index);
				}
			}
		});
		for(int i = 0;i<list.size();i++){
			res.append(list.get(i));
		}
		int index = 0;
		while(index < res.length() && res.charAt(index) == '0'){
			index ++;
		}
		if(index == res.length()){
			return "0";
		}else{
			return res.toString().substring(index);
		}
		
		
	}
	
	public static String numToString(int num) {
		
		StringBuilder sb = new StringBuilder();
		if(num == 0){
			return "0";
		}
		while(num != 0){
			sb.append(num % 10);
			num /= 10;
		}
		return sb.reverse().toString();
		
	}

}
