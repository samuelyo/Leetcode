package com.leetcode.GrayCode;

import java.util.ArrayList;
import java.util.List;

public class GrayCode3 {

	public static void main(String[] args) {

		int n = 3;
		List<Integer> ans = grayCode(n);
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}

	}

	public static List<Integer> grayCode(int n) {

		if(n == 0) {
			List<Integer> res = new ArrayList<Integer>();
			res.add(0);
			return res;
		}
		List<String> list = new ArrayList<String>();
		list.add("0");
		list.add("1");
		
		for(int i = 2;i<=n;i++) {
			List<String> temp = new ArrayList<String>();
			for(int j = 0;j<list.size();j++) {
				temp.add("0" + list.get(j));
			}
			for(int j = list.size() - 1;j>=0;j--) {
				temp.add("1" + list.get(j));
			}
			list = temp;
		}
		
		List<Integer> res = new ArrayList<Integer>();
		for(int i = 0;i<list.size();i++) {
			res.add(Integer.valueOf(list.get(i), 2));
		}
		return res;
		
		
	}

}
