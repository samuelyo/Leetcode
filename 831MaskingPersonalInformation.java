package com.leetcode.MaskingPersonalInformation;

import java.util.ArrayList;
import java.util.List;

public class MaskingPersonalInformation {

	public static void main(String[] args) {

		String S = "86-(10)12345678";
		String res = maskPII(S);
		System.out.println(res);

	}

	public static String maskPII(String S) {

		if (S == null || S.length() == 0) {
			return "";
		}
		if (S.indexOf('@') >= 0) {
			int index = S.indexOf('@');
			String pre = S.substring(0, index);
			char[] chs = pre.toCharArray();
			String left = S.substring(index).toLowerCase();
			return Character.toLowerCase(chs[0]) + "*****" + Character.toLowerCase(chs[chs.length - 1]) + left;
		} else {
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < S.length(); i++) {
				if (Character.isDigit(S.charAt(i))) {
					list.add(S.charAt(i) - '0');
				}
			}
			if (list.size() == 10) {
				return "***-***-" + list.get(6) + list.get(7) + list.get(8) + list.get(9);
			} else {
				int diff = list.size() - 10;
				String temp = "";
				for (int i = 0; i < diff; i++) {
					temp += "*";
				}
				return "+" + temp + "-***-***-" + list.get(list.size() - 4) + list.get(list.size() - 3) + list.get(list.size() - 2) + list.get(list.size() - 1);
			}
		}
	}

}
