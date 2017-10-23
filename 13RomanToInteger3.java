package com.leetcode.Romantointeger;

import java.util.ArrayList;
import java.util.List;

public class RomanToInteger3 {

	public static void main(String[] args) {

		String s = "MMMCMXCIX";
		System.out.println(romanToInt(s));

	}

	public static int romanToInt(String s) {

		List<Character> c = new ArrayList<Character>();
		c.add('I');
		c.add('V');
		c.add('X');
		c.add('L');
		c.add('C');
		c.add('D');
		c.add('M');
		int[] v = {1,5,10,50,100,500,1000};
		
		int res = 0;
		for(int i = 0;i<s.length();i++) {
			char cur = s.charAt(i);
			char pre = 0 ;
			if(i - 1 >= 0) {
				pre = s.charAt(i - 1);
			}
			int indexCur = c.indexOf(cur);
			int indexPre = c.indexOf(pre);
			res += v[indexCur];
			if(indexPre != -1 && indexCur > indexPre) {
				res -= 2 * v[indexPre];
			}
		}
		return res;

	}
}
