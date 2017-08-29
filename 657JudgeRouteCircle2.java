package com.leetcode.JudgeRouteCircle;

public class JudgeRouteCircle2 {

	public static void main(String[] args) {

		String moves = "UD";
		System.out.println(judgeCircle(moves));

	}

	public static boolean judgeCircle(String moves) {

		moves = " " + moves + " ";
		return moves.split("L").length == moves.split("R").length && moves.split("U").length == moves.split("D").length;

	}

}
