package com.leetcode.LongestCommonPrefix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LongestCommonPrefix4 {

	public static void main(String[] args) {
		
		String[] strs = {"abc", "abcd","ab"};
		System.out.println(longestCommonPrefix(strs));

	}
	
	public static String longestCommonPrefix(String[] strs){
		
		if(strs == null || strs.length == 0) {
			return "";
		}
		List<String> list = new ArrayList<String>();
		for(int i = 0;i<strs.length;i++) {
			list.add(strs[i]);
		}
		Collections.sort(list, new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
			
		});
		int len = list.get(0).length();
		for(int i = len;i>0;i--) {
			String pre = list.get(0).substring(0, i);
			if(isCommonPrefix(strs, pre)) {
				return pre;
			}
		}
		return "";
		
	}
	
	public static boolean isCommonPrefix(String[] strs, String pre) {
		
		for(int i = 0;i<strs.length;i++) {
			if(!strs[i].startsWith(pre)) {
				return false;
			}
		}
		return true;
		
	}

}
