package com.leetcode.PerfectNumber;

public class PerfectNumber2 {

	public static void main(String[] args) {

		int num = 6;
		System.out.println(checkPerfectNumber(num));

	}

	public static boolean checkPerfectNumber(int num) {

		if (num == 1)
			return false;

		int sum = 0;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				sum += i;
				if (i != num / i)
					sum += num / i;
			}
		}
		sum++;

		return sum == num;
	}
}
