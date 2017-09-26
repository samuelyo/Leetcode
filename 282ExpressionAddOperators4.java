package com.leetcode.ExpressionAddOperators;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators4 {

	public static void main(String[] args) {

		String num = "000";
		int target = 0;
		List<String> res = addOperators(num, target);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i) + " ");
		}

	}

	public static List<String> addOperators(String num, int target) {

		List<String> res = new ArrayList<String>();
		if(num == null || num.length() == 0) {
			return res;
		}
		addOperatorsHelp(num, target, res, "", 0, 0);
		return res;
		
	}
	
	public static void addOperatorsHelp(String num, int target, List<String> res, String cur, long value, long diff) {
		
		if(0 == num.length() && value == target) {
			res.add(cur);
			return ;
		}
		
		for(int i = 1;i<=num.length();i++) {
			String next = num.substring(0, i);
			if(next.length() > 1 && next.charAt(0) == '0') {
				break;
			}
			Long nextValue = Long.valueOf(next);
			String newNum = num.substring(i);
			if(cur.length() == 0) {
				addOperatorsHelp(newNum, target, res, next, nextValue, nextValue);
			}else{
				addOperatorsHelp(newNum, target, res, cur + "+" + next, value + nextValue, nextValue);
				addOperatorsHelp(newNum, target, res, cur + "-" + next, value - nextValue, -nextValue);
				addOperatorsHelp(newNum, target, res, cur + "*" + next, value - diff + diff * nextValue, diff * nextValue);
			}
			
		}
	}

}
