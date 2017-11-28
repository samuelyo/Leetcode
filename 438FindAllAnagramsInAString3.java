package com.leetcode.FindAllAnagramsInAString;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString3 {

	public static void main(String[] args) {
		
		String s = "abab";
		String p = "ab";
		List<Integer> res = findAnagrams(s, p);
		for(int i = 0;i<res.size();i++){
			System.out.print(res.get(i) + " " );
		}
		

	}
	
	public static List<Integer> findAnagrams(String s, String p){
		
		List<Integer> res = new ArrayList<Integer>();
		int len = p.length();
		for(int i = 0;i<=s.length() - len;i++) {
			String cur = s.substring(i, i + len);
			if(isAnagrams(p, cur)) {
				res.add(i);
			}
		}
		return res;
		
	}
	
	public static boolean isAnagrams(String p, String cur) {
		
		char[] times = new char[26];
		for(int i = 0;i<p.length();i++) {
			times[p.charAt(i) - 'a'] ++;
		}
		for(int i = 0;i<cur.length();i++) {
			if(times[cur.charAt(i) - 'a'] <= 0) {
				return false;
			}
			times[cur.charAt(i) - 'a'] --;
		}
		for(int i = 0;i<26;i++) {
			if(times[i] != 0) {
				return false;
			}
		}
		return true;
	}

}
