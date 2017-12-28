package com.leetcode.GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses4 {

	public static void main(String[] args) {
	
		int n = 4;
		List<String> res = generateParenthesis(n);
		for(int i = 0;i<res.size();i++) {
			System.out.println(res.get(i));
		}

	}
	
	public static List<String> generateParenthesis(int n) {
		
		List<String> res = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		generateParenthesisHelp(res, sb, 0, n);
		return res;
		
	}

	public static void generateParenthesisHelp(List<String> list, StringBuilder sb, int index, int n) {
		
		if(index > 2 * n) {
			return ;
		}
		if(index == 2 * n && isValid(sb.toString())) {
			list.add(new StringBuilder(sb).toString());
			return ;
		}
		char[] chs = new char[]{'(', ')'};
		for(int i = 0;i<chs.length;i++) {
			sb.append(chs[i]);
			generateParenthesisHelp(list, sb, index + 1, n);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
	
	public static boolean isValid(String s) {
		
		int count = 0;
		for(int i = 0;i < s.length();i++) {
			char cur = s.charAt(i);
			if(cur == '(') {
				count ++;
			}
			if(cur == ')') {
				count --;
			}
			if(count < 0) {
				return false;
			}
		}
		return count == 0;
	}
}
