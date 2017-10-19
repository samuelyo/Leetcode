package com.leetcode.DungeonGame;

import java.util.Arrays;

public class DungeonGame2 {

	public static void main(String[] args) {

		// int[][] dungeon = {{0,-40,100},{-30,-30,1},{30,30,0}};
		// int[][] dungeon = {{-3, 5}};
		int[][] dungeon = { { 10, 4, -48, -8, -87, 9 }, { 49, -100, 6, -15, 41, -99 }, { -76, -45, -26, 50, 46, 14 },
				{ -81, -92, 46, -62, -26, 1 }, { -44, 19, 26, -98, -49, -72 } };
		int res = calculateMinimumHP(dungeon);
		System.out.println(res);

	}

	public static int calculateMinimumHP(int[][] dungeon) {
		
		int M = dungeon.length;
        int N = dungeon[0].length;
        // hp[i][j] represents the min hp needed at position (i, j)
        // Add dummy row and column at bottom and right side
        int[][] hp = new int[M + 1][N + 1];
        for(int i = 0;i<M+1;i++) {
        	Arrays.fill(hp[i], Integer.MAX_VALUE);
        }
        hp[M][N - 1] = 1;
        hp[M - 1][N] = 1;
        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                int need = Math.min(hp[i + 1][j], hp[i][j + 1]) - dungeon[i][j];
                hp[i][j] = need <= 0 ? 1 : need;
            }
        }
        return hp[0][0];
	}

}
