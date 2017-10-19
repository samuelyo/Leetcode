package com.leetcode.DungeonGame;

public class DungeonGame {

	public static void main(String[] args) {
		
//		int[][] dungeon = {{0,-40,100},{-30,-30,1},{30,30,0}};
//		int[][] dungeon = {{-3, 5}};
		int[][] dungeon = {{10,4,-48,-8,-87,9},{49,-100,6,-15,41,-99},{-76,-45,-26,50,46,14},{-81,-92,46,-62,-26,1},{-44,19,26,-98,-49,-72}};
		int res = calculateMinimumHP(dungeon);
		System.out.println(res);

	}
	
	public static int calculateMinimumHP(int[][] dungeon) {
		
		int m = dungeon.length;
		int n = dungeon[0].length;
		
		int[][] dp = new int[m + 1][n + 1];
		dp[m][n] = dungeon[m-1][n-1] <= 0 ? 1 - dungeon[m-1][n-1] : 1;
		
		for(int i = n - 1;i>=1;i--) {
			dp[m][i] = dp[m][i + 1] - dungeon[m - 1][i - 1];
			if(dp[m][i] <= 0) {
				dp[m][i] = 1;
			}
		}
		
		for(int i = m - 1;i>=1;i--) {
			dp[i][n] = dp[i + 1][n] - dungeon[i - 1][n - 1];
			if(dp[i][n] <= 0) {
				dp[i][n] = 1;
			}
		}
		
		for(int j = m - 1;j>=1;j--) {
			for(int i = n - 1;i>=1;i--) {
				dp[j][i] = Math.min(Math.abs(dp[j + 1][i]), Math.abs(dp[j][i + 1])) - dungeon[j - 1][i - 1];
				if(dp[j][i] <= 0) {
					dp[j][i] = 1;
				}
			}
		}
		
		if(dp[1][1] <= 0) {
			return 1;
		}
		return dp[1][1];
	}

}
