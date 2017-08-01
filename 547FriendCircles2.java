package com.leetcode.FriendCircles;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FriendCircles2 {

	public static void main(String[] args) {

		int[][] M = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		System.out.println(findCircleNum(M));

	}

	public static int findCircleNum(int[][] M) {

		// DFS Solution
		boolean[] visited = new boolean[M.length];
		int count = 0;
		for (int i = 0; i < M.length; i++){
			if (!visited[i]) {
				dfs(M, visited, i);
				count++;
			}
		}
		return count;
	}

	public static void dfs(int[][] M, boolean[] visited, int i) {
		for (int j = 0; j < M.length; j++){
			if (M[i][j] == 1 && !visited[j]) {
				visited[j] = true;
				dfs(M, visited, j);
			}
		}
	}

}
