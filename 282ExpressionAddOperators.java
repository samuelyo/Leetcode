package com.leetcode.ExpressionAddOperators;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

	public static void main(String[] args) {
		
		String num = "232";
		int target = 8;
		List<String> res = addOperators(num, target);
		for(int i = 0;i<res.size();i++){
			System.out.print(res.get(i) + " ");
		}

	}
	
	public static List<String> addOperators(String num, int target) {
		
		List<String> res = new ArrayList<String>();  
        dfs(num, target, 0, 0, "", res);  
        return res;  
    } 
	
    public static void dfs(String num, int target, long cur, long diff, String temp, List<String> res) {  
        
    	if(cur == target && num.length() == 0) {  
            res.add(temp);  
        }  
        for(int i = 1; i<=num.length(); i++) {  
            String str = num.substring(0, i);  
            if(str.length()>1 && '0' == str.charAt(0)) return;  
            String next = num.substring(i);  
            if(temp.length() >0) {  
                dfs(next, target, Long.parseLong(str) + cur, Long.parseLong(str), temp + "+" +str, res);  
                dfs(next, target, cur - Long.parseLong(str), -Long.parseLong(str), temp + "-" +str, res);  
                dfs(next, target, (cur - diff) + diff * Long.parseLong(str), Long.parseLong(str)*diff, temp + "*" +str, res);  
            } else {  
                dfs(next, target, Long.parseLong(str), Long.parseLong(str), str, res);  
            }  
        }  
    }  
	

}
