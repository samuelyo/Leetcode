package com.leetcode.ComplexNumberMultiplication;

public class ComplexNumberMultiplication {

	public static void main(String[] args) {
		
		String a = "1+-1i";
		String b = "1+-1i";
		System.out.println(complexNumberMultiply(a, b));

	}
	
	public static String complexNumberMultiply(String a, String b) {
		
		int cur = 0;
		while(a.charAt(cur) != '+'){
			cur ++;
		}
		String num1 = a.substring(0, cur);
		String num2 = a.substring(cur + 1, a.length() - 1);
		
		cur = 0;
		while(b.charAt(cur) != '+'){
			cur ++;
		}
		String num3 = b.substring(0, cur);
		String num4 = b.substring(cur + 1, b.length() - 1);
		
//		int n1 = stringToInteger(num1);
//		int n2 = stringToInteger(num2);
//		int n3 = stringToInteger(num3);
//		int n4 = stringToInteger(num4);
		
		int n1 = Integer.valueOf(num1);
		int n2 = Integer.valueOf(num2);
		int n3 = Integer.valueOf(num3);
		int n4 = Integer.valueOf(num4);
		
		int left = n1 * n3 - n2 * n4;
		int right = n1 * n4 + n2 * n3;
		
		return left + "+" + right + "i";
		
	}
	
	public static int stringToInteger(String s) {
		
		boolean flag = true;
		if(s.charAt(0) == '-'){
			flag = false;
			s = s.substring(1);
		}
		int num = 0;
		for(int i = 0;i < s.length();i++){
			num += (s.charAt(i) - '0') * Math.pow(10, s.length() - 1 - i);
		}
		if(flag == false){
			num = 0 - num;
		}
		return num;
		
	}

}
