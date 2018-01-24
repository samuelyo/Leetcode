package com.leetcode.RepeatedDNASequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences5 {

	public static void main(String[] args) {
		
		String s = "AAAAAAAAAAAA";
		List<String> ans = findRepeatedDnaSequences(s);
		for(int i = 0;i<ans.size();i++){
			System.out.print(ans.get(i) + " ");
		}

	}
	
	public static List<String> findRepeatedDnaSequences(String s) {
		
		List<String> res = new ArrayList<String>();
		Set<String> set = new HashSet<String>();
		for(int i = 0;i + 10<=s.length();i++) {
			String cur = s.substring(i, i + 10);
			if(set.contains(cur) && !res.contains(cur)) {
				res.add(cur);
			}else {
				set.add(cur);
			}
		}
		return res;
		
	}

}
