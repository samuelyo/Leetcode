package com.leetcode.EliminationGame;

public class EliminationGame4 {

	public static void main(String[] args) {
		
		int n = 9;
		System.out.println(lastRemaining(n));

	}
	
	public static int lastRemaining(int n) {
		
		boolean flag = true;
		int head = 1;
		int step = 1;
		while(n > 1) {
			if(flag || n % 2 == 1) {
				head += step;
			}
			n /= 2;
			step *= 2;
			flag = !flag;
		}
		return head;
		
	}

}
