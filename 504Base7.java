package com.leetcode.Base7;

public class Base7 {

	public static void main(String[] args) {
		
		int num = -7;
		System.out.println(convertToBase7(num));

	}

	public static String convertToBase7(int num) {
		
		StringBuilder res = new StringBuilder();
		boolean sign ;
		int cur ;
		if(num >= 0){
			cur = num;
			sign = true;
		}else{
			cur = -num;
			sign = false;
		}
		if(num == 0){
			return "0";
		}
		while(cur != 0){
			int temp = cur % 7;
			res.append(temp);
			cur /= 7;
		}
		return sign == true ? res.reverse().toString() : "-" + res.reverse().toString();
		
	}
}
