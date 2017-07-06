package com.leetcode.CountNumbersWithUniqueDigits;

public class CountNumbersWithUniqueDigits2 {

	public static void main(String[] args) {

		int n = 4;
		System.out.println(countNumbersWithUniqueDigits(n));

	}

	/**
	 * f(1) = 10. (0, 1, 2, 3, ...., 9)
	 * 
	 * f(2) = 9 * 9. Because for each number i from 1, ..., 9, we can pick j to
	 * form a 2-digit number ij and there are 9 numbers that are different from
	 * i for j to choose from.
	 * 
	 * f(3) = f(2) * 8 = 9 * 9 * 8. Because for each number with unique digits
	 * of length 2, say ij, we can pick k to form a 3 digit number ijk and there
	 * are 8 numbers that are different from i and j for k to choose from.
	 * 
	 * Similarly f(4) = f(3) * 7 = 9 * 9 * 8 * 7....
	 * 
	 * ...
	 * 
	 * f(10) = 9 * 9 * 8 * 7 * 6 * ... * 1
	 * 
	 * f(11) = 0 = f(12) = f(13)....
	 * 
	 * @param n
	 * @return
	 */
	public static int countNumbersWithUniqueDigits(int n) {

		if (n == 0)
			return 1;

		int res = 10;
		int uniqueDigits = 9;
		int availableNumber = 9;
		while (n-- > 1 && availableNumber > 0) {
			uniqueDigits = uniqueDigits * availableNumber;
			res += uniqueDigits;
			availableNumber--;
		}
		return res;
	}
}
