package com.leetcode.PascalTraingle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalTriangle3 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(pascalTriangle(n));
		s.close();
	}
	
	public static List<List<Integer>> pascalTriangle(int numRows){
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(numRows == 0) {
			return res;
		}
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		res.add(list);
		if(numRows == 1) {
			return res;
		}
		for(int i = 2;i<=numRows;i++) {
			List<Integer> pre = res.get(res.size() - 1);
			List<Integer> cur = new ArrayList<Integer>();
			cur.add(1);
			for(int j = 0;j<pre.size() - 1;j++) {
				int temp = pre.get(j) + pre.get(j + 1);
				cur.add(temp);
			}
			cur.add(1);
			res.add(cur);
		}
		return res;
		
	}
}
