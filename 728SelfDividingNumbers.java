package com.leetcode.SelfDividingNumbers;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {

	public static void main(String[] args) {
		
		int left = 1;
		int right = 22;
		List<Integer> res = selfDividingNumbers(left, right);
		for(int i = 0;i<res.size();i++) {
			System.out.print(res.get(i) + " ");
		}

	}

	public static List<Integer> selfDividingNumbers(int left, int right) {
		
		List<Integer> res = new ArrayList<Integer>();
		for(int cur = left;cur<=right;cur++){
			String s = Integer.toString(cur);
			if(s.contains("0")) {
				continue;
			}
			List<Integer> digits = new ArrayList<Integer>();
			boolean flag = true;
			for(int i = 0;i<s.length();i++) {
				digits.add(s.charAt(i) - '0');
				if(cur % (s.charAt(i) - '0') != 0) {
					flag = false;
					break;
				}
			}
			if(flag) {
				res.add(cur);
			}
		}
		return res;
		
	}
}
