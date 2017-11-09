package com.leetcode.HappyNumber;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber4 {

	public static void main(String[] args) {
		
		int n = 19;
		boolean res = isHappy(n);
		System.out.println(res);

	}

	public static boolean isHappy(int n){
		
		Set<Integer> set = new HashSet<Integer>();
		int temp = n;
		while(!set.contains(temp)) {
			set.add(temp);
			int cur = 0;
			while(temp != 0) {
				cur += (temp % 10) * (temp % 10);
				temp /= 10;
			}
			temp = cur;
			if(temp == 1) {
				return true;
			}
		}
		return false;
		
	}
}
