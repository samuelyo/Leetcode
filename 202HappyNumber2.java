package com.leetcode.happynumber;

import java.util.ArrayList;
import java.util.List;

public class HappyNumber2 {

	public static void main(String[] args) {
		
		System.out.println(isHappy(19));
	}
	
	public static boolean isHappy(int n){
		
		int slow,fast;
		slow = fast = n;
		do{
			
			slow = digitSquareSum(slow);
			fast = digitSquareSum(fast);
			fast = digitSquareSum(fast);
			if(1 == fast){
				return true;
			}
		}while(slow != fast);
		return false;
	}
	
	public static int digitSquareSum(int n){
		int sum = 0;
		while(0 != n){
			int temp = n%10;
			sum += temp * temp;
			n = n/10;
		}
		return sum;
	}

}
