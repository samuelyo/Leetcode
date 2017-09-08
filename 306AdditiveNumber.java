package com.leetcode.AdditiveNumber;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class AdditiveNumber {

	public static void main(String[] args) {
		
		String num = "112358";
		System.out.println(isAdditiveNumber(num));

	}

	public static boolean isAdditiveNumber(String num) {
		
		List<BigInteger> list = new ArrayList<BigInteger>();
		return isAdditiveNumberHelp(num, 0, list);
		
		
	}
	
	public static boolean isAdditiveNumberHelp(String num, int start, List<BigInteger> list) {
		
		if(start == num.length()){
			if(list.size() < 3){
				return false;
			}else{
				return true;
			}
			
		}
		for(int i = start + 1;i<=num.length();i++){
			String cur = num.substring(start, i);
			if(cur.length() > 1 && cur.charAt(0) == '0'){
				continue;
			}
			list.add(new BigInteger(cur, 10));
			if(list.size() < 3){
				if(isAdditiveNumberHelp(num, i, list)){
					return true;
				}
			}else{
				if(list.get(list.size() - 1).equals(list.get(list.size() - 2).add(list.get(list.size() - 3)))){
					if(isAdditiveNumberHelp(num, i, list)){
						return true;
					}
				}
			}
			list.remove(list.size() - 1);
		}
		
		return false;
	}
}
