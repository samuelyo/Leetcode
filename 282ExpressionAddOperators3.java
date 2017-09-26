package com.leetcode.ExpressionAddOperators;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators3 {

	public static void main(String[] args) {

		String num = "232";
		int target = 8;
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
		addOperatorsHelp(num, target, res, "", 0, 0, 0);
		return res;
		
	}
	
	public static void addOperatorsHelp(String num, int target, List<String> res, String cur, long value, long diff, int pos) {
		
		if(pos == num.length() && value == target) {
			res.add(cur);
			return ;
		}
		
		for(int i = pos;i<num.length();i++) {
			String next = num.substring(pos, i + 1);
			if(next.length() > 1 && next.charAt(0) == '0') {
				break;
			}
			Long nextValue = Long.valueOf(next);
			if(pos == 0) {
				addOperatorsHelp(num, target, res, cur + next, nextValue, nextValue, i + 1);
			}else{
				addOperatorsHelp(num, target, res, cur + "+" + next, value + nextValue, nextValue, i + 1);
				addOperatorsHelp(num, target, res, cur + "-" + next, value - nextValue, -nextValue, i + 1);
				addOperatorsHelp(num, target, res, cur + "*" + next, value - diff + diff * nextValue, diff * nextValue, i + 1);
			}
			
		}
	}

}
