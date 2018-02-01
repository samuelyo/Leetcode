package com.leetcode.DifferentWaysToAddParentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferentWaysToAddParentheses3 {

	public static void main(String[] args) {
		
		String input = "1-2+3*4-5*6-7+8*9";
		List<Integer> res = diffWaysToCompute(input);
		for(int i = 0;i<res.size();i++){
			System.out.print(res.get(i) + " ");
		}

	}
	
	public static Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
	
	public static List<Integer> diffWaysToCompute(String input) {
		
		if(map.containsKey(input)) {
			return map.get(input);
		}
		
		if(input.length() == 0) {
			map.put("", new ArrayList<Integer>());
			return new ArrayList<Integer>();
		}
		if(!input.contains("*") && !input.contains("-") && !input.contains("+")) {
			List<Integer> res = new ArrayList<Integer>();
			res.add(Integer.valueOf(input));
			map.put(input, res);
			return res;
		}
		List<Integer> res = new ArrayList<Integer>();
		for(int i = 0;i<input.length();i++) {
			char cur = input.charAt(i);
			String left = input.substring(0, i);
			String right = input.substring(i + 1);
			List<Integer> leftRes = diffWaysToCompute(left);
			List<Integer> rightRes = diffWaysToCompute(right);
			if(cur == '*') {
				for(int j = 0;j<leftRes.size();j++) {
					for(int k = 0;k<rightRes.size();k++) {
						res.add(leftRes.get(j) * rightRes.get(k));
					}
				}
			}else if(cur == '-') {
				for(int j = 0;j<leftRes.size();j++) {
					for(int k = 0;k<rightRes.size();k++) {
						res.add(leftRes.get(j) - rightRes.get(k));
					}
				}
			}else if(cur == '+') {
				for(int j = 0;j<leftRes.size();j++) {
					for(int k = 0;k<rightRes.size();k++) {
						res.add(leftRes.get(j) + rightRes.get(k));
					}
				}
			}
		}
		map.put(input, res);
		return res;
		
	}

}
