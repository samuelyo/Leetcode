package com.leetcode.MultiplyStrings;

public class MultiplyStrings3 {

	public static void main(String[] args) {
		
		String num1 = "5";
		String num2 = "12";
		System.out.println(multiply(num1, num2));

	}
	
	public static String multiply(String num1, String num2) {
		
		char[] ch1 = new StringBuilder(num1).reverse().toString().toCharArray();
		char[] ch2 = new StringBuilder(num2).reverse().toString().toCharArray();
		
		int[] res = new int[ch1.length + ch2.length];
		
		for(int i = 0;i<ch1.length;i++) {
			for(int j = 0;j<ch2.length;j++) {
				res[i + j] += (ch1[i] - '0') * (ch2[j] - '0');
			}
		}
		
		for(int i = 0;i<res.length;i++) {
			if(res[i] >= 10) {
				res[i + 1] += res[i]/10;
				res[i] %= 10;
			}
		}
		
		int index = res.length - 1;
		while(index > 0 && res[index] == 0) {
			index --;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<=index;i++) {
			sb.insert(0, res[i]);
		}
		return sb.toString();
		
	}

}
