package com.leetcode.JudgeRouteCircle;

public class JudgeRouteCircle3 {

	public static void main(String[] args) {
		
		String moves = "DURDLDRRLL";
		System.out.println(judgeCircle(moves));

	}

	public static boolean judgeCircle(String moves) {
		
		int x = 0;
		int y = 0;
		
		for(int i = 0;i<moves.length();i++) {
			char cur = moves.charAt(i);
			switch(cur) {
			case 'U':
				y ++;
				break;
			case 'D':
				y --;
				break;
			case 'R':
				x ++;
				break;
			case 'L':
				x --;
				break;
			}
		}
		return x == 0 && y == 0;
		
	}
}
