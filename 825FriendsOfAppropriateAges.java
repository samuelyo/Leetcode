package com.leetcode.FriendsOfAppropriateAges;

public class FriendsOfAppropriateAges {

	public static void main(String[] args) {

		int[] ages = { 16, 16 };
		int res = numFriendRequests(ages);
		System.out.println(res);

	}

	public static int numFriendRequests(int[] ages) {

		if (ages == null || ages.length == 0) {
			return 0;
		}
		int[] dp = new int[121];
		for (int age : ages) {
			dp[age]++;
		}
		int count = 0;
		for (int i = 15; i <= 120; i++) {
			for (int j = (int) (0.5 * i + 8); j <= i; j++) {
				count += dp[j] * (dp[i] - (i == j ? 1 : 0));
			}
		}
		return count;
	}

}
