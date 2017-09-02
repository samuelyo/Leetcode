package com.leetcode.MagicalString;

public class MagicalString4 {

	public static void main(String[] args) {

		int n = 10;
		System.out.println(magicalString(n));

	}

	public static int magicalString(int n) {

		StringBuilder sb = new StringBuilder("122");
		if(n == 0){
			return 0;
		}
		if(n <= 3){
			return 1;
		}
		int count = 1;
		int timesIndex = 2;
		while (sb.length() < n) {
			int times = sb.charAt(timesIndex) - '0';
			Character c = sb.charAt(sb.length() - 1);
			if (c == '1') {
				for (int i = 0; i < times; i++) {
					sb.append("2");
				}
			} else {
				for (int i = 0; i < times; i++) {
					sb.append("1");
					if(sb.length() <= n){
						count ++;
					}
					
				}
			}
			timesIndex++;
		}
		return count;
	}

}
