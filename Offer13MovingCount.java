package com.javaoffer;

public class MovingCount {

	public static void main(String[] args) {
		
		int threshold = 18;
		int rows = 20;
		int cols = 20;
		System.out.println(movingCount(threshold, rows, cols));

	}
	public static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static int movingCount(int threshold, int rows, int cols) {
		
		if(threshold < 0) {
            return 0;
        }
		boolean[][] visited = new boolean[rows][cols];
		movingCountHelp(threshold, rows, cols, 0, 0, visited);
		int res = 0;
		for(int i = 0;i<rows;i++) {
			for(int j = 0;j<cols;j++) {
				if(visited[i][j]) {
					res ++;
				}
			}
		}
		return res;
		
	}
	
	public static void movingCountHelp(int threshold, int rows, int cols, int i, int j, boolean[][] visited) {
		
		visited[i][j] = true;
		for(int k = 0;k<dir.length;k++) {
			int newI = i + dir[k][0];
			int newJ = j + dir[k][1];
			if(newI >= 0 && newI < rows && newJ >= 0 && newJ < cols && isValid(newI, newJ, threshold) && !visited[newI][newJ]) {
				movingCountHelp(threshold, rows, cols, newI, newJ, visited);
			}
		}
		
	}
	
	public static boolean isValid(int i, int j, int threshold) {
		
		int res = 0;
		while(i != 0) {
			res += i % 10;
			i /= 10;
		}
		while(j != 0) {
			res += j % 10;
			j /= 10;
		}
		return res <= threshold;
		
	}
}
