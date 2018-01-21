package com.leetcode.FractionToRecurringDecimal;

import java.util.ArrayList;
import java.util.List;

public class FractionToRecurringDecimal3 {

	public static void main(String[] args) {
		
		int numerator = -2147483648;
		int denominator = 1;
		System.out.println(fractionToDecimal(numerator, denominator));

	}

	public static String fractionToDecimal(int numerator, int denominator) {
		
		if(numerator == 0) {
			return "0";
		}
		int sign = (numerator > 0) ^ (denominator > 0) ? -1 : 1;
		long div1 = Math.abs((long) numerator);
		long div2 = Math.abs((long) denominator);
		String res = "";
		
		res += div1 / div2;
		div1 = div1 % div2;
		if (div1 == 0) {
			return sign == -1 ? "-" + res : res;
		} else {
			res += ".";
		}
		List<Long> list = new ArrayList<Long>();
		while(div1 != 0) {
			if(!list.contains(div1)) {
				list.add(div1);
				div1 *= 10;
				res += div1 / div2;
				div1 = div1 % div2;
			}else {
				int index = list.indexOf(div1);
				String recurring = res.substring(res.length() - list.size() + index, res.length());
				res = res.substring(0, res.length() - list.size() + index) + "(" + recurring + ")";
				break;
			}
		}
		return sign == -1 ? "-" + res : res;
		
	}
}
