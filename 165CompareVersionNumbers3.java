package com.leetcode.CompareVersionNumbers;

public class CompareVersionNumbers3 {

	public static void main(String[] args) {
		
		String version1 = "1.0";
		String version2 = "1";
		System.out.println(compareVersion(version1, version2));

	}
	
	public static int compareVersion(String version1, String version2) {
		
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		
		int len = Math.max(v1.length, v2.length);
		for(int i = 0;i<len;i++) {
			Integer cur1 = i < v1.length ? Integer.valueOf(v1[i]) : 0;
			Integer cur2 = i < v2.length ? Integer.valueOf(v2[i]) : 0;
			int com = cur1.compareTo(cur2);
			if(com != 0) {
				return com;
			}
		}
		return 0;
		
	}

}
