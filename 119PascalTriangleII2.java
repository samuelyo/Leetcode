package com.leetcode.pascaltriangle2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalTriangleII2 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(getRow(n));
	}
	
	public static List<Integer> getRow(int rowIndex){
		
		List<Integer> row = new ArrayList<Integer>();
		for(int i=0;i<=rowIndex;i++)
		{
			row.add(0, 1);
			for(int j=1;j<row.size()-1;j++)
				row.set(j, row.get(j)+row.get(j+1));
		}
		return row;
	}
}
