package com.leetcode.FractionAdditionAndSubtraction;

import java.util.ArrayList;
import java.util.List;

public class FractionAdditionAndSubtraction2 {

	public static void main(String[] args) {
		
		String expression = "-1/122+1/2+1/32";
		String ans = fractionAddition(expression);
		System.out.println(ans);

	}

	public static String fractionAddition(String expression) {
		
		List<Integer> denominator = new ArrayList<Integer>();
		List<Integer> numerator = new ArrayList<Integer>();
		int count = 0;
		for(int i = 0;i<expression.length();i++){
			if(expression.charAt(i) == '/'){
				int curIndex = i+1;
				while(curIndex < expression.length() && expression.charAt(curIndex) - '0' >=0 && expression.charAt(curIndex) - '0' <= 9){
					curIndex ++;
				}
				denominator.add(Integer.valueOf(expression.substring(i+1, curIndex)));
				if(count == 0){
					curIndex = i-1;
					while(curIndex >= 0 && expression.charAt(curIndex) - '0' >=0 && expression.charAt(curIndex) - '0' <= 9){
						curIndex --;
					}
					if(curIndex == 0){
						numerator.add(0 - Integer.valueOf(expression.substring(curIndex + 1, i)));
					}else{
						numerator.add(Integer.valueOf(expression.substring(curIndex + 1, i)));
					}
				}else{
					curIndex = i-1;
					while(curIndex >= 0 && expression.charAt(curIndex) - '0' >=0 && expression.charAt(curIndex) - '0' <= 9){
						curIndex --;
					}
					if(expression.charAt(curIndex) == '+'){
						numerator.add(Integer.valueOf(expression.substring(curIndex + 1, i)));
					}else{
						numerator.add(0 - Integer.valueOf(expression.substring(curIndex + 1, i)));
					}
				}
				count ++;
			}
		}
		if(denominator.size() == 1){
			return expression;
		}else{
			int len = denominator.size();
			int base = denominator.get(0) * denominator.get(1) / gcd(denominator.get(0), denominator.get(1));
			for(int i = 2;i<len;i++){
				base = base * denominator.get(i) / gcd(base, denominator.get(i));
			}
			int sum = 0;
			for(int i = 0;i<numerator.size();i++){
				sum += numerator.get(i) * (base / denominator.get(i));
			}
			boolean flag = sum < 0 ? true : false;
			sum = Math.abs(sum);
			int maxGCD = gcd(sum, base);
			return flag == false ? sum/maxGCD + "/" + base/maxGCD : "-" + sum/maxGCD + "/" + base/maxGCD;
		}
		
	}
	
	public static int gcd(int a, int b) {
		
		int r = a, s = a, t = b;
		if (a < b) {
		r = a;
		a = b;
		b = r;
		}
		while (r != 0) {
		r = a % b;
		a = b;
		b = r;
		}
		return a;
		
	}
}
