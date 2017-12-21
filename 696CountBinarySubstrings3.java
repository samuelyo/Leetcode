package com.leetcode.CountBinarySubstrings;

public class CountBinarySubstrings3 {

	public static void main(String[] args) {
	
		String s = "00110011";
		int res = countBinarySubstrings(s);
		System.out.println(res);

	}
	
	public static int countBinarySubstrings(String s) {
		
		int count = 0;
		int index = 0;
		char[] chs = s.toCharArray();
		while(index < chs.length) {
			int temp = index;
			char pre = chs[temp];
			while(temp < chs.length && chs[temp] == pre) {
				temp ++;
			}
			int diff = temp;
			if(diff == chs.length) {
				break;
			}
			char pree = chs[diff];
			while(diff < chs.length && chs[diff] == pree) {
				diff ++;
			}
			count += Math.min(temp - index, diff - temp);
			index = temp;
		}
		return count;
		
	}

}
