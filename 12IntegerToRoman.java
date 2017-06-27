package com.leetcode.IntegerToRoman;

public class IntegerToRoman {

	public static void main(String[] args) {
		
		int num = 40;
		System.out.println(intToRoman(num));

	}

	public static String intToRoman(int num) {
		
		String[][] s = {{"","I","II","III","IV","V","VI","VII","VIII","IX"},
		{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
		{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
		{"","M","MM","MMM"}};
		
		StringBuilder roman = new StringBuilder();
        roman.append(s[3][num / 1000 % 10]);
        roman.append(s[2][num / 100 % 10]);
        roman.append(s[1][num / 10 % 10]);
        roman.append(s[0][num % 10]);
         
        return roman.toString();
		
	}
}
