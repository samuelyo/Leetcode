package com.leetcode.FractionToRecurringDecimal;

import java.util.ArrayList;
import java.util.List;

public class FractionToRecurringDecimal {

	public static void main(String[] args) {
		
		int numerator = -2147483648;
		int denominator = 1;
		System.out.println(fractionToDecimal(numerator, denominator));

	}

	public static String fractionToDecimal(int numerator, int denominator) {
		
		if(numerator == 0){
			return "0";
		}
		int sign = (numerator < 0) ^ (denominator < 0) ? -1 : 1;
		long num = (long)numerator;
		num = Math.abs(num);
		long den = (long)denominator;
		den = Math.abs(den);
		StringBuilder res = new StringBuilder();
		if(num >= den){
			res.append(num / den);
			num -= num / den * den;
			if(num == 0){
				return (sign == -1) ? "-" + res.toString() : res.toString();
			}else{
				res.append(".");
			}
		}else{
			res.append("0.");
		}
		long temp = num;
		List<Long> nums = new ArrayList<Long>();
		nums.add(num);
		while(temp != 0){
			temp *= 10;
			long cur = temp / den;
			temp = temp % den;
			if(nums.contains(temp)){
				res.append(cur);
				int index = nums.indexOf(temp);
				int base = res.indexOf(".");
				String couples = res.substring(base + index + 1, res.length());
				res = new StringBuilder(res.substring(0, base + index + 1) + "(" + couples + ")");
				break;
			}else{
				nums.add(temp);
				res.append(cur);
			}
		}
		return (sign == -1) ? "-" + res.toString() : res.toString();
		
	}
}
