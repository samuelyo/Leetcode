package com.leetcode.GrayCode;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

	public static void main(String[] args) {
		
		int n = 4;
		
		List<Integer> ans = grayCode(n);
		for(int i = 0;i<ans.size();i++){
			System.out.print(ans.get(i) + " ");
		}

	}
	
	public static List<Integer> grayCode(int n) {
		
		List<Integer> ans = new ArrayList<Integer>();
		if(n < 0){
			return ans;
		}
		ans.add(0);
		if(n == 0){
			return ans;
		}
		grayCodeHelp(ans, 1, n);
		return ans;
		
	}
	
	public static void grayCodeHelp(List<Integer> list, int num, int n) {
		
		if(num > n){
			return ; 
		}
		if(num == 1){
			list.add(1);
		}else{
			int len = Integer.toBinaryString(list.get(list.size() - 1)).length();
			for(int i = list.size() - 1;i>=0;i--){
				Integer cur = list.get(i);
				String curString = Integer.toBinaryString(cur);
				if(curString.length() < len){
					int times = len - curString.length();
					StringBuilder sb = new StringBuilder(curString);
					sb = sb.reverse();
					for(int j = 0;j<times;j++){
						sb.append('0');
					}
					curString = sb.reverse().toString();
				}
				Integer newCur = Integer.valueOf("1" + curString, 2);
				list.add(newCur);
			}
		}
		grayCodeHelp(list, num + 1, n);
		
	}

}
