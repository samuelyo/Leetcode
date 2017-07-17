package com.leetcode.IntegerReplacement;

import java.util.ArrayList;
import java.util.List;

public class IntegerReplacement2 {

	public static void main(String[] args) {
		
		int n = 2147483645;
		System.out.println(integerReplacement(n));

	}

	public static int integerReplacement(int n) {
		
		if(n == 1){
			return 0;
		}
		if(n == 2147483647){
			return 32;
		}
		List<Long> list = new ArrayList<Long>();
		for(int i = 0;i<=31;i++){
			list.add((long)Math.pow(2, i));
		}
		if(list.contains(n)){
			return list.indexOf(n);
		}
		if(n % 2 == 0){
			int count = 0;
			while(n % 2 == 0){
				n /= 2;
				count++;
			}
			count += integerReplacement(n);
			return count;
		}else{
			return 1 + Math.min(integerReplacement(n-1), integerReplacement(n+1));
		}
		
	}
	
}
