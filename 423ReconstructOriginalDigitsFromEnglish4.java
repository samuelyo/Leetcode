package com.leetcode.ReconstructOriginalDigitsFromEnglish;

public class ReconstructOriginalDigitsFromEnglish4 {

	public static void main(String[] args) {
		
		String s = "esnve";
		String res = originalDigits(s);
		System.out.println(res);

	}
	
	public static String originalDigits(String s) {
		
		int[] map = new int[26];
		for(int i = 0;i<s.length();i++) {
			map[s.charAt(i) - 'a'] ++;
		}
		int[] num = new int[10];
		num[0] = map['z' - 'a'];
		num[2] = map['w' - 'a'];
		num[4] = map['u' - 'a'];
		num[6] = map['x' - 'a'];
		num[8] = map['g' - 'a'];
		num[1] = map['o' - 'a'] - num[0] - num[2] - num[4];
		num[3] = map['t' - 'a'] - num[2] - num[8];
		num[7] = map['s' - 'a'] - num[6];
		num[5] = map['v' - 'a'] - num[7];
		num[9] = map['i' - 'a'] - num[5] - num[6] - num[8];
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<num.length;i++) {
			for (int j = 0; j < num[i]; j++) {
				sb.append(i);
			}
		}
		return sb.toString();
		
	}

}
