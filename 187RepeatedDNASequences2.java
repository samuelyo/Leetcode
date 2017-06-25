package com.leetcode.RepeatedDNASequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatedDNASequences2 {

	public static void main(String[] args) {
		
		String s = "AAAAAAAAAAAA";
		List<String> ans = findRepeatedDnaSequences(s);
		for(int i = 0;i<ans.size();i++){
			System.out.print(ans.get(i) + " ");
		}

	}
	
	public static List<String> findRepeatedDnaSequences(String s) {
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		Set<String> ans = new HashSet<String>();
		if(s == null || s.length() <= 10){
			return new ArrayList<String>(ans);
		}
		int len = s.length();
		for(int i = 10;i<=len;i++){
			String cur = s.substring(i-10, i);
			map.put(cur, map.getOrDefault(cur, 0) + 1);
			if(map.get(cur) > 1){
				ans.add(cur);
			}
		}
		return new ArrayList<String>(ans);
		
	}
}
