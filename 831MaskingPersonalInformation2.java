package com.leetcode.MaskingPersonalInformation;

public class MaskingPersonalInformation2 {

	public static void main(String[] args) {

		String S = "86-(10)12345678";
		String res = maskPII(S);
		System.out.println(res);

	}

	public static String[] country = { "", "+*-", "+**-", "+***-" };

	public static String maskPII(String S) {

		int at = S.indexOf("@");
		if (at > 0) {
			S = S.toLowerCase();
			return (S.charAt(0) + "*****" + S.substring(at - 1)).toLowerCase();
		}
		S = S.replaceAll("[^0-9]", "");
		return country[S.length() - 10] + "***-***-" + S.substring(S.length() - 4);
	}

}
