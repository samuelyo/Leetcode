package com.leetcode.ChampagneTower;

public class ChampagneTower {

	public static void main(String[] args) {
		
		int poured = 2;
		int query_row = 1;
		int query_glass = 1;
		System.out.println(champagneTower(poured, query_row, query_glass));

	}
	
	public static double champagneTower(int poured, int query_row, int query_glass) {
		
		double[][] res = new double[100][100];
		res[0][0] = poured;
		for(int i = 0;i<100;i++) {
			for(int j = 0;j<=i;j++) {
				if(res[i][j] > 1) {
					res[i + 1][j] += (res[i][j] - 1) / 2.0;
					res[i + 1][j + 1] += (res[i][j] - 1) / 2.0;
					res[i][j] = 1;
				}
			}
		}
		return res[query_row][query_glass];
		
	}

}
