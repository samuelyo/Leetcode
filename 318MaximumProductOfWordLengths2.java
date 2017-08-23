package com.leetcode.MaximumProductOfWordLengths;

import java.util.HashSet;
import java.util.Set;

public class MaximumProductOfWordLengths2 {

	public static void main(String[] args) {
		
		String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
		System.out.println(maxProduct(words));

	}

	public static int maxProduct(String[] words) {
		
		int res = 0;
		for(int i = 0;i<words.length;i++){
			for(int j = i+1;j<words.length;j++){
				String s1 = words[i];
				String s2 = words[j];
				if(!hasCommon(s1, s2)){
					res = Math.max(res, s1.length() * s2.length());
				}
			}
		}
		return res;
		
	}
	
	public static boolean hasCommon(String s1, String s2) {
		
		Set<Character> set = new HashSet<Character>();
		for(int i = 0;i<s1.length();i++){
			set.add(s1.charAt(i));
		}
		for(int i = 0;i<s2.length();i++){
			if(set.contains(s2.charAt(i))){
				return true;
			}
		}
		return false;
		
	}
}
