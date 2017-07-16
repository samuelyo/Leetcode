package com.leetcode.WaterAndJugProblem;

public class WaterAndJugProblem2 {

	public static void main(String[] args) {

		int x = 6;
		int y = 9;
		int z = 1;
		System.out.println(canMeasureWater(x, y, z));

	}

	/**
	 * B¨¦zout's identity (also called B¨¦zout's lemma) is a theorem in the
	 * elementary theory of numbers:
	 * 
	 * let a and b be nonzero integers and let d be their greatest common
	 * divisor. Then there exist integers x and y such that ax+by=d
	 * 
	 * In addition, the greatest common divisor d is the smallest positive
	 * integer that can be written as ax + by
	 * 
	 * every integer of the form ax + by is a multiple of the greatest common
	 * divisor d.
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 */
	public static boolean canMeasureWater(int x, int y, int z) {

		// limit brought by the statement that water is finallly in one or both
		// buckets
		if (x + y < z)
			return false;
		// case x or y is zero
		if (x == z || y == z || x + y == z)
			return true;

		// get GCD, then we can use the property of B¨¦zout's identity
		return z % GCD(x, y) == 0;
	}

	public static int GCD(int a, int b) {
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;

	}

}
