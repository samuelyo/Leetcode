package com.leetcode.JudgeRouteCircle;

public class JudgeRouteCircle {

	public static void main(String[] args) {
		
		String moves = "UD";
		System.out.println(judgeCircle(moves));

	}
	
	public static boolean judgeCircle(String moves) {
		
		int x = 0;
		int y = 0;
		
		for(int i = 0;i<moves.length();i++){
			Character cur = moves.charAt(i);
			if(cur == 'R'){
				x ++;
			}else if(cur == 'L'){
				x --;
			}else if(cur == 'U'){
				y ++;
			}else{
				y --;
			}
		}
		
		return x == 0 && y == 0;
	}

}
