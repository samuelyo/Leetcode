package com.javaoffer;

public class HasPath {

	public static void main(String[] args) {
		
		char[] matrix = {'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A'};
		int rows = 3;
		int cols = 4;
		char[] str = {'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A'};
		System.out.println(hasPath(matrix, rows, cols, str));

	}
	public static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		
		boolean[] visited = new boolean[matrix.length];
		boolean res = false;
		for(int i = 0;i<matrix.length;i++) {
			int row = i / cols;
			int col = i % cols;
			res |= hasPathHelp(matrix, rows, cols, str, 0, row, col, visited);
		}
		return res;
	}

	public static boolean hasPathHelp(char[] matrix, int rows, int cols, char[] str, int index, int i, int j, boolean[] visited) {
		
		if(matrix[i * cols + j] != str[index]) {
			return false;
		}
		if(index == str.length - 1) {
			return true;
		}
		visited[i * cols + j] = true;
		for(int k = 0;k<dir.length;k++) {
			int newI = i + dir[k][0];
			int newJ = j + dir[k][1];
			if(newI >= 0 && newI < rows && newJ >= 0 && newJ < cols && !visited[newI * cols + newJ]) {
				if(hasPathHelp(matrix, rows, cols, str, index + 1, newI, newJ, visited)) {
					return true;
				}
			}
		}
		visited[i * cols + j] = false;
		return false;
		
	}
}
