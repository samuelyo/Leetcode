package com.leetcode.BinaryWatch;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch2 {

	public static void main(String[] args) {
		
		int num = 3;
		List<String> ans = readBinaryWatch(num);
		for(int i = 0;i<ans.size();i++){
			System.out.print(ans.get(i) + " ");
		}

	}

	public static List<String> readBinaryWatch(int num) {
		
		List<String> times = new ArrayList<>();
		for (int h = 0; h < 12; h++){
			for (int m = 0; m < 60; m++){
//				if (Integer.bitCount(h * 64 + m) == num){
//					times.add(String.format("%d:%02d", h, m));
//				}
				if(Integer.bitCount(h) + Integer.bitCount(m) == num){
					times.add(String.format("%d:%02d", h, m));
				}
			}
		}		
		return times;
	}
}
