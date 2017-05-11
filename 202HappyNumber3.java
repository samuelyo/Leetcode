package com.leetcode.happynumber;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber3 {

	public static void main(String[] args) {
		
		System.out.println(isHappy(19));
	}
	
	public static boolean isHappy(int n){
		
		Set<Integer> inLoop = new HashSet<Integer>();
	    int squareSum,remain;
		while (inLoop.add(n)) {
			squareSum = 0;
			while (n > 0) {
			    remain = n%10;
				squareSum += remain*remain;
				n /= 10;
			}
			if (squareSum == 1)
				return true;
			else
				n = squareSum;

		}
		return false;

		
	}
	
	
}
