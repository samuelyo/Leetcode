package com.leetcode.PascalTriangle2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalTriangleII3 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(getRow(n));
		s.close();
	}
	
	public static List<Integer> getRow(int rowIndex){
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		if(rowIndex == 0) {
			return list;
		}
		list.add(1);
		if(rowIndex == 1) {
			return list;
		}
		for(int i = 2;i<=rowIndex;i++) {
			List<Integer> cur = new ArrayList<Integer>();
			cur.add(1);
			for(int j = 0;j<list.size() - 1;j++) {
				int temp = list.get(j) + list.get(j + 1);
				cur.add(temp);
			}
			cur.add(1);
			list = cur;
		}
		return list;
		
	}
}
