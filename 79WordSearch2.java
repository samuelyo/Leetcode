package com.leetcode.WordSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearch2 {
	
	public static int[][] dir = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
	
	public static void main(String[] args) {
		
		char[][] board = { { 'A', 'B', 'C', 'E' }, 
						   { 'S', 'F', 'C', 'S' }, 
						   { 'A', 'D', 'E', 'E' } };
		String word = "ABCB";
		System.out.println(exist(board, word));

	}
	
	public static boolean exist(char[][] board, String word) {
		
		int m = board.length;
		int n = board[0].length;
		
		boolean[][] visited = new boolean[m][n];
		Map<Character, List<int[]>> map = new HashMap<Character, List<int[]>>();
		for(int i = 0;i<m;i++) {
			for(int j = 0;j<n;j++) {
				char cur = board[i][j];
				if(map.containsKey(cur)) {
					map.get(cur).add(new int[]{i,j});
				}else {
					List<int[]> list = new ArrayList<int[]>();
					list.add(new int[]{i,j});
					map.put(cur, list);
				}
			}
		}
		
		char[] chs = word.toCharArray();
		if(!map.containsKey(chs[0])) {
			return false;
		}
		List<int[]> list = map.get(chs[0]);
		boolean res = false;
		for(int[] pos : list) {
			res = res || existHelp(board, visited, chs, pos[0], pos[1], 0);
		}
		return res;
		
	}
	
	public static boolean existHelp(char[][] board, boolean[][] visited, char[] chs, int i, int j, int index) {
		
		if(index == chs.length - 1) {
			return true;
		}
		boolean res = false;
		visited[i][j] = true;
		for(int k = 0;k<dir.length;k++) {
			int newI = i + dir[k][0];
			int newJ = j + dir[k][1];
			if(newI < board.length && newI >= 0 && newJ < board[0].length && newJ >=0 && !visited[newI][newJ] && board[newI][newJ] == chs[index + 1]) {
				visited[newI][newJ] = true;
				res = res || existHelp(board, visited, chs, newI, newJ, index + 1);
				visited[newI][newJ] = false;
			}
		}
		visited[i][j] = false;
		return res;
		
	}

}
