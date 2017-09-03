package com.leetcode.EliminationGame;

import java.util.ArrayList;
import java.util.List;

public class EliminationGame {

	public static void main(String[] args) {
		
		int n = 9;
		System.out.println(lastRemaining(n));

	}

	public static int lastRemaining(int n) {
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 1;i<=n;i++){
			list.add(i);
		}
		boolean flag = true;
		int count = 0;
		while(list.size() - count != 1){
			if(flag){
				int index = 0;
				int num = 0;
				while(index < list.size()){
					if(list.get(index) != null){
						num ++;
						if(num % 2 == 1){
							list.set(index, null);
							count ++;
						}
					}
					index ++;
				}
				flag = !flag;
			}else{
				int index = list.size() - 1;
				int num = 0;
				while(index >= 0){
					if(list.get(index) != null){
						num ++;
						if(num % 2 == 1){
							list.set(index, null);
							count ++;
						}
					}
					index --;
				}
				flag = !flag;
			}
		}
		int res = 0;
		for(int i = 0;i<list.size();i++){
			if(list.get(i) != null){
				res = list.get(i);
				break;
			}
		}
		return res;
		
	}
}
