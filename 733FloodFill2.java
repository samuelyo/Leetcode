package com.leetcode.FloodFill;

public class FloodFill2 {

	public static void main(String[] args) {

		int[][] image = {{0,0,0},{0,1,1}};
		int sr = 1;
		int sc = 1;
		int newColor = 1;
		int[][] res = floodFill(image, sr, sc, newColor);
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

		if (image[sr][sc] == newColor)
			return image;
		fill(image, sr, sc, image[sr][sc], newColor);
		return image;
	}

	private static void fill(int[][] image, int sr, int sc, int color, int newColor) {
		
		if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color)
			return;
		image[sr][sc] = newColor;
		fill(image, sr + 1, sc, color, newColor);
		fill(image, sr - 1, sc, color, newColor);
		fill(image, sr, sc + 1, color, newColor);
		fill(image, sr, sc - 1, color, newColor);

	}

}
