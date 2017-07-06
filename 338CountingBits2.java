package com.leetcode.CountingBits;

public class CountingBits2 {

	public static void main(String[] args) {

		int num = 100;
		int[] ans = countBits(num);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}

	}

	public static int[] countBits(int num) {

		int[] ans = new int[num + 1];
		int nearPower = 0;
		if (num == 0) {
			ans[0] = 0;
			return ans;
		} else {
			ans[0] = 0;
			for (int i = 1; i <= num; i++) {
				if ((i & (i - 1)) == 0) {
					ans[i] = 1;
					nearPower = i;
				} else {
					ans[i] = 1 + ans[i - nearPower];
				}
			}
			return ans;
		}
	}
}
