package com.leetcode.RestoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses2 {

	public static void main(String[] args) {

		String s = "11111111";
		List<String> ans = restoreIpAddresses(s);
		for (int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i));
		}

	}

	public static List<String> restoreIpAddresses(String s) {

		List<String> res = new ArrayList<String>();
		int len = s.length();
		for (int i = 1; i < 4 && i < len - 2; i++) {
			for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
				for (int k = j + 1; k < j + 4 && k < len; k++) {
					String s1 = s.substring(0, i), s2 = s.substring(i, j), s3 = s.substring(j, k),
							s4 = s.substring(k, len);
					if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
						res.add(s1 + "." + s2 + "." + s3 + "." + s4);
					}
				}
			}
		}
		return res;
	}

	public static boolean isValid(String s) {
		if (s.length() > 3 || s.length() == 0 || (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255)
			return false;
		return true;

	}
}
