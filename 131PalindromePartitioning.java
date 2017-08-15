package com.leetcode.PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	public static void main(String[] args) {
		
		String s = "aaba";
		
		List<List<String>> ans = partition(s);
		
		for(int i = 0;i<ans.size();i++){
			List<String> cur = ans.get(i);
			for(int j = 0;j<cur.size();j++){
				System.out.print(cur.get(j) + " ");
			}
			System.out.println();
		}

	}
	
	public static List<List<String>> partition(String s) {
		
		List<List<String>> ans = new ArrayList<List<String>>();
		if(s == "" || s.length() == 0){
			return ans;
		}
		List<String> list = new ArrayList<String>();
		partitionHelp(ans, list, s);
		return ans;
		
	}
	
	public static void partitionHelp(List<List<String>> ans, List<String> list, String s) {
		
		if(s == "" || s.length() == 0){
			ans.add(new ArrayList<String>(list));
			return ;
		}
		for(int i = 1;i <= s.length();i++){
			String sub = s.substring(0, i);
			String left = s.substring(i, s.length());
			if(isPalindrome(sub)){
				list.add(sub);
				partitionHelp(ans, list, left);
				list.remove(list.size() - 1);
			}
		}
		
	}
	
	public static boolean isPalindrome(String s) {
		
		if(s == "" || s.length() == 0){
			return false;
		}
		int left = 0;
		int right = s.length() - 1;
		while(left <= right){
			if(s.charAt(left) == s.charAt(right)){
				left ++;
				right --;
			}else{
				return false;
			}
		}
		return true;
		
	}

}
