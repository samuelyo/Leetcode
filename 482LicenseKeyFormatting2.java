package com.leetcode.LicenseKeyFormatting;

public class LicenseKeyFormatting2 {

	public static void main(String[] args) {

		String S = "2-4A0r7-4k";
		int K = 4;
		System.out.println(licenseKeyFormatting(S, K));

	}

	public static String licenseKeyFormatting(String S, int K) {

		StringBuilder sb = new StringBuilder();
		for (int i = S.length() - 1; i >= 0; i--)
			if (S.charAt(i) != '-')
				sb.append(sb.length() % (K + 1) == K ? '-' : "").append(S.charAt(i));
		return sb.reverse().toString().toUpperCase();

	}

}
