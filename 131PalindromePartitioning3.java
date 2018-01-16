package com.leetcode.PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning3 {

	public static void main(String[] args) {

		String s = "aaba";

		List<List<String>> ans = partition(s);

		for (int i = 0; i < ans.size(); i++) {
			List<String> cur = ans.get(i);
			for (int j = 0; j < cur.size(); j++) {
				System.out.print(cur.get(j) + " ");
			}
			System.out.println();
		}

	}
	
	public static List<List<String>> partition(String s) {
		
		List<List<String>> res = new ArrayList<List<String>>();
		if(s == "" || s.length() == 0){
			return res;
		}
		List<String> list = new ArrayList<String>();
		partitionHelp(res, list, s, 0);
		return res;
		
	}
	
	public static void partitionHelp(List<List<String>> res, List<String> list, String s, int index) {
		
		if(index == s.length()) {
			res.add(new ArrayList<String>(list));
			return ;
		}
		for(int i = index + 1;i<=s.length();i++) {
			String cur = s.substring(index, i);
			if(isPalindrome(cur)) {
				list.add(cur);
				partitionHelp(res, list, s, i);
				list.remove(list.size() - 1);
			}
		}
		
	}
	
 	public static boolean isPalindrome(String s) {
 		
 		int start = 0;
 		int end = s.length() - 1;
 		while(start <= end) {
 			if(s.charAt(start) == s.charAt(end)) {
 				start ++;
 				end --;
 			}else {
 				return false;
 			}
 		}
 		return true;
 		
 	}

}
