package com.leetcode.AdditiveNumber;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class AdditiveNumber5 {

	public static void main(String[] args) {
		
		String num = "199100199";
		System.out.println(isAdditiveNumber(num));

	}
	
	public static boolean isAdditiveNumber(String num) {
		
		List<BigInteger> list = new ArrayList<BigInteger>();
		return isAdditiveNumberHelp(num, list, 0);
		
	}
	
	public static boolean isAdditiveNumberHelp(String num, List<BigInteger> list, int start) {
		
		if(start == num.length()) {
			if(list.size() < 3) {
				return false;
			}else {
				return true;
			}
		}
		for(int i = start + 1;i<=num.length();i++) {
			String temp = num.substring(start, i);
			if(temp.length() > 1 && temp.charAt(0) == '0') {
				continue;
			}
			if(list.size() < 2) {
				list.add(new BigInteger(temp, 10));
				if(isAdditiveNumberHelp(num, list, i)) {
					return true;
				}
				list.remove(list.size() - 1);
			}else {
				if(new BigInteger(temp, 10).equals(list.get(list.size() - 1).add(list.get(list.size() - 2)))) {
					list.add(new BigInteger(temp, 10));
					if(isAdditiveNumberHelp(num, list, i)) {
						return true;
					}
					list.remove(list.size() - 1);
				}
			}
		}
		return false;
		
	}

}
