package com.leetcode.LongestWordInDictionaryThroughDeleting;

import java.util.ArrayList;
import java.util.List;

public class LongestWordInDictionaryThroughDeleting {

	public static void main(String[] args) {
		
		String s = "abpcplea";
		List<String> d = new ArrayList<String>();
		d.add("ale");
		d.add("apple");
		d.add("monkey");
		d.add("plea");
//		d.add("a");
//		d.add("b");
//		d.add("c");
		
		System.out.println(findLongestWord(s, d));

	}

	public static String findLongestWord(String s, List<String> d) {
		
		String ans = "";
		for(int i = 0;i<d.size();i++){
			String t = d.get(i);
			if(findLongestWordHelp(s, t)){
				if(ans.length() < t.length()){
					ans = t;
				}else if(ans.length() == t.length()){
					if(t.charAt(0) - ans.charAt(0) < 0){
						ans = t;
					}
				}
			}
		}
		return ans;
		
	}
	
	public static boolean findLongestWordHelp(String s, String t) {
		
		int sIndex = 0;
		int tIndex = 0;
		
		while(sIndex <= s.length()){
			if(tIndex == t.length()){
				return true;
			}
			while(sIndex < s.length() && s.charAt(sIndex) != t.charAt(tIndex)){
				sIndex ++;
			}
			tIndex ++;
			sIndex ++;
		}
		return false;
		
	}
}
