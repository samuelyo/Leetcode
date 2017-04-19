package com.leetcode.pascaltraingle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalTriangle2 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(pascalTriangle(n));
	}
	
	public static List<List<Integer>> pascalTriangle(int numRows){
		
		List<List<Integer>> allrows = new ArrayList<List<Integer>>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		for(int i=0;i<numRows;i++)
		{
			row.add(0, 1);
			for(int j=1;j<row.size()-1;j++)
				row.set(j, row.get(j)+row.get(j+1));
			allrows.add(new ArrayList<Integer>(row));
		}
		return allrows;
	}
}
