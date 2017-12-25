package com.leetcode.StringToIntegerAtoi;

import java.math.BigInteger;

public class StringToIntegerAtoi3 {

	public static void main(String[] args) {
		
		String str = "    +11191657170";
		System.out.println(myAtoi(str));

	}
	
	public static int myAtoi(String str) {
		
		str = str.trim();
		if(str.matches("\\d+.*")) {
			int index = 0;
			while(index < str.length() && str.charAt(index) - '0' >= 0 && str.charAt(index) - '0' <= 9) {
				index ++;
			}
			BigInteger temp = new BigInteger(str.substring(0, index));
			if(temp.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) == 1){
				return Integer.MAX_VALUE;
			}
			if(temp.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) == -1){
				return Integer.MIN_VALUE;
			}
			return temp.intValue();
		}
		if(str.matches("[+-]\\d+.*")) {
			int index = 1;
			while(index < str.length() && str.charAt(index) - '0' >= 0 && str.charAt(index) - '0' <= 9) {
				index ++;
			}
			BigInteger temp = new BigInteger(str.substring(0, index));
			if(temp.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) == 1){
				return Integer.MAX_VALUE;
			}
			if(temp.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) == -1){
				return Integer.MIN_VALUE;
			}
			return temp.intValue();
		}
		return 0;
	}

}
