package com.leetcode.FizzBuzz;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

	public static void main(String[] args) {
		
		int n = 15;
		List<String> res = fizzBuzz(n);
		for(int i = 0;i<res.size();i++){
			System.out.print(res.get(i) + " ");
		}
		
	}
	
	public static List<String> fizzBuzz(int n) {
		
		List<String> res = new ArrayList<String>();
		for(int i = 1;i<=n;i++){
			if(i % 3 == 0 && i % 5 == 0){
				res.add("FizzBuzz");
			}else if(i % 3 == 0){
				res.add("Fizz");
			}else if(i % 5 == 0){
				res.add("Buzz");
			}else{
				res.add(i + "");
			}
		}
		return res;
		
	}

}
