package com.leetcode.FloodFill;

public class FloodFill3 {

	public static void main(String[] args) {
		
		int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
		int sr = 1;
		int sc = 1;
		int newColor = 2;
		int[][] res = floodFill(image, sr, sc, newColor);
		for(int i = 0;i<res.length;i++) {
			for(int j = 0;j<res[0].length;j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static int[][] dir = {{1, 0},{-1, 0},{0, 1},{0, -1}};
	
	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		
		int value = image[sr][sc];
		boolean[][] visited = new boolean[image.length][image[0].length];
		floodFillHelp(image, sr, sc, newColor, value, visited);
		return image;
		
	}
	
	public static void floodFillHelp(int[][] image, int sr, int sc, int newColor, int value, boolean[][] visited) {
		
		if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != value || visited[sr][sc]) {
			return ; 
		}
		image[sr][sc] = newColor;
		visited[sr][sc] = true;
		for(int i = 0;i<dir.length;i++) {
			int row = sr + dir[i][0];
			int col = sc + dir[i][1];
			floodFillHelp(image, row, col, newColor, value, visited);
		}
		
	}
}
