package com.leetcode.BaseballGame;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

	public static void main(String[] args) {
		
		String[] ops = {"5","-2","4","C","D","9","+","+"};
		System.out.println(calPoints(ops));
		
	}

	public static int calPoints(String[] ops) {
		
		List<Integer> list = new ArrayList<Integer>();
		int sum = 0;
		for(int i = 0;i<ops.length;i++) {
			if(ops[i].equals("C")) {
				int value = list.get(list.size() - 1);
				sum -= value;
				list.remove(list.size() - 1);
			}else if(ops[i].equals("D")) {
				int last = list.get(list.size() - 1);
				sum += 2 * last;
				list.add(2 * last);
			}else if(ops[i].equals("+")) {
				int last = list.get(list.size() - 1);
				int lastLast = list.get(list.size() - 2);
				sum += last + lastLast;
				list.add(last + lastLast);
			}else {
				int value = Integer.valueOf(ops[i]);
				sum += value;
				list.add(value);
			}
		}
		return sum;
		
	}
}
