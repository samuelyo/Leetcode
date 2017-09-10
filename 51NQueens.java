package com.leetcode.NQueens;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

	public static void main(String[] args) {
		
		int n = 4;
		List<List<String>> res = solveNQueens(n);
		for(int i = 0;i<res.size();i++){
			List<String> cur = res.get(i);
			for(int j = 0;j<cur.size();j++){
				System.out.println(cur.get(j));
			}
			System.out.println();
		}

	}
	
	public static List<List<String>> solveNQueens(int n) {
		
		boolean[] cols = new boolean[n]; // columns |
		boolean[] d1 = new boolean[2 * n]; // diagonals \
		boolean[] d2 = new boolean[2 * n]; // diagonals /
		List<List<String>> res = new ArrayList<List<String>>();
		List<String> list = new ArrayList<String>();
		backtracking(res, list, 0, cols, d1, d2, n);
		return res;
		
	}
	
	public static void backtracking(List<List<String>> res, List<String> list, int row, boolean[] cols, boolean[] d1, boolean[] d2, int n) {
		if (row == n)
			res.add(new ArrayList<String>(list));

		for (int col = 0; col < n; col++) {
			int id1 = col - row + n;
			int id2 = col + row;
			if (cols[col] || d1[id1] || d2[id2])
				continue;

			StringBuilder sb = new StringBuilder();
			for(int i = 0;i<n;i++){
				if(i == col){
					sb.append("Q");
				}else{
					sb.append(".");
				}
			}
			list.add(sb.toString());
			cols[col] = true;
			d1[id1] = true;
			d2[id2] = true;
			backtracking(res, list, row + 1, cols, d1, d2, n);
			list.remove(list.size() - 1);
			cols[col] = false;
			d1[id1] = false;
			d2[id2] = false;
		}
	}

}
