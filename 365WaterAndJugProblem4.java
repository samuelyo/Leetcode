package com.leetcode.WaterAndJugProblem;

public class WaterAndJugProblem4 {

	public static void main(String[] args) {

		System.out.println(canMeasureWater(4, 7, 11));

	}

	public static boolean canMeasureWater(int x, int y, int z) {

		if (x + y < z) {
			return false;
		}
		if(x == 0 && y == 0) {
			return z == 0;
		}
		return z % GCD(x, y) == 0;

	}

	public static int GCD(int a, int b) {

		if (b == 0) {
			return a;
		}	
		return a % b == 0 ? b : GCD(b, a % b);
	}

}
