package com.leetcode.FloodFill;

public class FloodFill {

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

	public static int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	
	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
		int m = image.length;
		int n = image[0].length;
		boolean[][] visited = new boolean[m][n];
		floodFillHelp(image, sr, sc, newColor, visited);
		return image;
		
    }
	
	public static void floodFillHelp(int[][] image, int sr, int sc, int newColor, boolean[][] visited) {
		
		int value = image[sr][sc];
		image[sr][sc] = newColor;
		visited[sr][sc] = true;
		for(int i = 0;i<dir.length;i++) {
			int m = sr + dir[i][0];
			int n = sc + dir[i][1];
			if(m < 0 || n < 0 || m >= image.length || n >= image[0].length) {
				continue ;
			}
			if(image[m][n] == value && !visited[m][n]) {
				floodFillHelp(image, m, n, newColor, visited);
			}
		}
		
	}

}
