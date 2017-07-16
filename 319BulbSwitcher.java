package com.leetcode.BulbSwitcher;

public class BulbSwitcher {

	public static void main(String[] args) {
		
		int n = 99;
		System.out.println(bulbSwitch(n));

	}
	
	public static int bulbSwitch(int n) {
		
		return (int)Math.sqrt(n);
	}
	
}
