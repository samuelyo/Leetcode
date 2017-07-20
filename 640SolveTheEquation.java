package com.leetcode.SolveTheEquation;

public class SolveTheEquation {

	public static void main(String[] args) {
		
		String equation = "1+1=x";
		String res = solveEquation(equation);
		System.out.println(res);

	}
	
	public static String solveEquation(String equation) {
		
		String[] e = equation.split("=");
		StringBuilder equ = new StringBuilder(e[0]);
		if(e[1].charAt(0) != '+' && e[1].charAt(0) != '-'){
			equ.append('-');
		}
		for(int i = 0;i<e[1].length();i++){
			if(e[1].charAt(i) == '+'){
				equ.append('-');
				continue;
			}
			if(e[1].charAt(i) == '-'){
				equ.append('+');
				continue;
			}
			equ.append(e[1].charAt(i));
		}
		equ.append('+');
		int X = 0;
		int Num = 0;
		int cur = 0;
		if(equ.charAt(cur) == '-'){
			cur ++;
		}
		while(cur < equ.length()){
			if(equ.charAt(cur) == '+' || equ.charAt(cur) == '-'){
				if(equ.charAt(cur-1) == 'x'){
					if(cur == 1){
						X ++;
						cur ++;
						continue;
					}
					int temp = cur-2;
					while(temp >= 0 && equ.charAt(temp) - '0' >= 0 && equ.charAt(temp) - '0' <= 9){
						temp --;
					}
					if(temp < 0){
						X += Integer.valueOf(equ.substring(temp + 1, cur-1));
						cur ++;
						continue;
					}
					if(equ.charAt(temp) == '+'){
						if(temp == cur-2){
							X ++;
						}else{
							X += Integer.valueOf(equ.substring(temp + 1, cur-1));
						}
					}
					if(equ.charAt(temp) == '-'){
						if(temp == cur-2){
							X --;
						}else{
							X -= Integer.valueOf(equ.substring(temp + 1, cur-1));
						}
					}
				}else{
					int temp = cur-1;
					while(temp >= 0 && equ.charAt(temp) - '0' >= 0 && equ.charAt(temp) - '0' <= 9){
						temp --;
					}
					if(temp < 0){
						Num += Integer.valueOf(equ.substring(temp + 1, cur));
						cur ++;
						continue;
					}
					if(equ.charAt(temp) == '+'){
						Num += Integer.valueOf(equ.substring(temp + 1, cur));
					}
					if(equ.charAt(temp) == '-'){
						Num -= Integer.valueOf(equ.substring(temp + 1, cur));
					}
				}
			}
			cur ++;
		}
		if(X == 0 && Num == 0){
			return "Infinite solutions";
		}
		if(X == 0 && Num != 0){
			return "No solution";
		}
		return "x=" + (-Num / X);
		
	}

}
