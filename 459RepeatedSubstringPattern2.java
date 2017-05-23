package com.leetcode.repeatedsubstringpattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedSubstringPattern2 {

	public static void main(String[] args) {

		String s = "aba";
		System.out.println(repeatedSubstringPattern(s));

	}

	public static boolean repeatedSubstringPattern(String str) {

		int l = str.length();
		for (int i = l / 2; i >= 1; i--) {
			if (l % i == 0) {
				int m = l / i;
				String subS = str.substring(0, i);
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < m; j++) {
					sb.append(subS);
				}
				if (sb.toString().equals(str))
					return true;
			}
		}
		return false;
	}

}
