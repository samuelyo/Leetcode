package com.leetcode.KnightProbabilityInChessboard;

public class KnightProbabilityInChessboard {

	public static void main(String[] args) {
		
		int N = 8;
		int K = 30;
		int r = 6;
		int c = 4;
		System.out.println(knightProbability(N, K, r, c));

	}
	
	public static int[] x = {-1,1,2,2,1,-1,-2,-2};
	public static int[] y = {-2,-2,-1,1,2,2,1,-1};
    
    public static double knightProbability(int N, int K, int r, int c) {
        
    	double[][][] dp = new double[N + 1][N + 1][K + 1];
		double sum = Math.pow(8, K);
		double count = knightProbabilityNum(N, K, r, c, dp);
		return ((double)count / (double)sum);
		
	}

	public static double knightProbabilityNum(int N, int K, int r, int c, double[][][] dp) {
		
		if(dp[r][c][K] != 0) {
			return dp[r][c][K];
		}
		double num = 0;
		if(K == 0) {
			return 1.0;
		}
		for(int i = 0;i<8;i++) {
			int newX = r + x[i];
			int newY = c + y[i];
			if(newX < N && newX >= 0 && newY < N && newY >= 0) {
				num += knightProbabilityNum(N, K - 1, newX, newY, dp);
			}
		}
		dp[r][c][K] = num;
		return num;
    }
}
