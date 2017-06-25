package com.leetcode.RepeatedDNASequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences4 {

	public static void main(String[] args) {

		String s = "AAAAAAAAAAAA";
		List<String> ans = findRepeatedDnaSequences(s);
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}

	}

	public static List<String> findRepeatedDnaSequences(String s) {

		Set<String> seen = new HashSet<String>(), repeated = new HashSet<String>();
		for (int i = 0; i + 9 < s.length(); i++) {
			String ten = s.substring(i, i + 10);
			if (!seen.add(ten))
				repeated.add(ten);
		}
		return new ArrayList<String>(repeated);

	}
}
