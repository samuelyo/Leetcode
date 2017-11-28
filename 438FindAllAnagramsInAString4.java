package com.leetcode.FindAllAnagramsInAString;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString4 {

	public static void main(String[] args) {
		
		String s = "cbaebabacd";
		String p = "abc";
		List<Integer> res = findAnagrams(s, p);
		for(int i = 0;i<res.size();i++){
			System.out.print(res.get(i) + " " );
		}
		

	}
	
	public static List<Integer> findAnagrams(String s, String p){
		
		List<Integer> res = new ArrayList<Integer>();
		int[] times = new int[26];
		for(int i = 0;i<p.length();i++) {
			times[p.charAt(i) - 'a'] ++;
		}
		int left = 0;
		int right = 0;
		int count = p.length();
		while(right < s.length()) {
			if(times[s.charAt(right) - 'a'] > 0) {
				count --;
			}
			times[s.charAt(right) - 'a'] --;
			if(count == 0) {
				res.add(left);
			}
			if(right - left == p.length() - 1) {
				if(times[s.charAt(left) - 'a'] >= 0) {
					count ++;
				}
				times[s.charAt(left) - 'a'] ++;
				left ++;
			}
			right ++;
		}
		return res;
		
	}


}
