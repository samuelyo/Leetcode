package com.leetcode.NimGame;

public class NimGame {

	public static void main(String[] args) {
		
		int n = 4;
		System.out.println(canWinNim(n));
	}
	
	public static boolean canWinNim(int n) {
		
		return (n % 4 != 0);
		
	}

}
