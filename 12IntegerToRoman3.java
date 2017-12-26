package com.leetcode.IntegerToRoman;

public class IntegerToRoman3 {

	public static void main(String[] args) {
		
		int num = 100;
		System.out.println(intToRoman(num));

	}
	
	public static String intToRoman(int num) {
		
		String[][] s = {{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
						{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
						{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
						{"", "M", "MM", "MMM"}};
		StringBuilder res = new StringBuilder();
		int index = 0;
		while(num != 0) {
			res.insert(0, s[index][num % 10]);
			num /= 10;
			index ++;
		}
		return res.toString();
		
	}

}
