package com.leetcode.NumberOfIslands;

public class NumberOfIslands {

	public static void main(String[] args) {
		
		char[][] grid = new char[4][5];
		grid[0][0] = '1';
		grid[0][1] = '1';
		grid[0][2] = '1';
		grid[0][3] = '1';
		grid[0][4] = '0';
		grid[1][0] = '1';
		grid[1][1] = '1';
		grid[1][2] = '0';
		grid[1][3] = '1';
		grid[1][4] = '0';
		grid[2][0] = '1';
		grid[2][1] = '1';
		grid[2][2] = '0';
		grid[2][3] = '0';
		grid[2][4] = '0';
		grid[3][0] = '0';
		grid[3][1] = '0';
		grid[3][2] = '0';
		grid[3][3] = '0';
		grid[3][4] = '0';
		
		
//		char[][] grid = new char[3][3];
//		grid[0][0] = '1';
//		grid[0][1] = '1';
//		grid[0][2] = '1';
//		grid[1][0] = '0';
//		grid[1][1] = '1';
//		grid[1][2] = '0';
//		grid[2][0] = '1';
//		grid[2][1] = '1';
//		grid[2][2] = '1';
		
		System.out.println(numIslands(grid));
	}
	
	public static int numIslands(char[][] grid) {
	
		if(grid == null || grid.length == 0 || grid[0].length == 0){
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		int num = 0;
		Integer[][] island = new Integer[m][n];
		boolean[][] beLand = new boolean[m][n];
		for(int i = 0;i<m;i++){
			for(int j = 0;j<n;j++){
				if(grid[i][j] == '1' && beLand[i][j] == false){
					if(island[i][j] != null){
						num = Math.max(num, island[i][j]);
					}else{
						num ++;
						island[i][j] = num;
					}
					beLand[i][j] = true;
					isIsland(grid, island,i, j, beLand);
				}
			}
		}
		return num;
		
	}
	
	public static void isIsland(char[][] grid, Integer[][] island, int i, int j, boolean[][] beLand) {
		
		for(int m = i + 1;m < grid.length;m++){
			if(grid[m][j] == '1' && beLand[m][j] == false){
				island[m][j] = island[i][j];
				beLand[m][j] = true;
				if(m != i){
					isIsland(grid, island, m, j, beLand);
				}
			}else{
				break;
			}
		}
		for(int m = i - 1;m >= 0;m--){
			if(grid[m][j] == '1' && beLand[m][j] == false){
				island[m][j] = island[i][j];
				beLand[m][j] = true;
				if(m != i){
					isIsland(grid, island, m, j, beLand);
				}
			}else{
				break;
			}
		}
		for(int m = j + 1;m < grid[0].length;m++){
			if(grid[i][m] == '1' && beLand[i][m] == false){
				island[i][m] = island[i][j];
				beLand[i][m] = true;
				if(m != j){
					isIsland(grid, island, i, m, beLand);
				}
			}else{
				break;
			}
		}
		for(int m = j - 1;m >= 0;m--){
			if(grid[i][m] == '1' && beLand[i][m] == false){
				island[i][m] = island[i][j];
				beLand[i][m] = true;
				if(m != j){
					isIsland(grid, island, i, m, beLand);
				}
			}else{
				break;
			}
		}
		
	}

}
