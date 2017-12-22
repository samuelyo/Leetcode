package com.leetcode.SelfDividingNumbers;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers3 {

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
		for(int i = left;i<=right;i++) {
			int cur = i;
			String s = String.valueOf(cur);
			if(s.contains("0")) {
				continue;
			}
			boolean flag = true;
			for(int j = 0;j<s.length();j++) {
				int value = s.charAt(j) - '0';
				if(cur % value != 0) {
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
