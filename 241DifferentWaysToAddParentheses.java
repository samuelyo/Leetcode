package com.leetcode.DifferentWaysToAddParentheses;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {

	public static void main(String[] args) {
		
		String input = "2*3-4*5";
		List<Integer> res = diffWaysToCompute(input);
		for(int i = 0;i<res.size();i++){
			System.out.print(res.get(i) + " ");
		}

	}

	public static List<Integer> diffWaysToCompute(String input) {
		
		List<Integer> res = new ArrayList<Integer>();
		int index = 0;
		while(index < input.length()){
			if(input.charAt(index) == '+' || input.charAt(index) == '-' || input.charAt(index) == '*'){
				String left = input.substring(0, index);
				String right = input.substring(index + 1);
				List<Integer> resLeft = diffWaysToCompute(left);
				List<Integer> resRight = diffWaysToCompute(right);
				for(int i = 0;i<resLeft.size();i++){
					for(int j = 0;j<resRight.size();j++){
						if(input.charAt(index) == '+'){
							res.add(resLeft.get(i) + resRight.get(j));
						}else if(input.charAt(index) == '-'){
							res.add(resLeft.get(i) - resRight.get(j));
						}else{
							res.add(resLeft.get(i) * resRight.get(j));
						}
					}
				}
			}
			index ++;
		}
		if(res.size() == 0){
			res.add(Integer.valueOf(input));
		}
		return res;
		
	}
}
