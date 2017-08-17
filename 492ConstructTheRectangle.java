package com.leetcode.ConstructTheRectangle;

public class ConstructTheRectangle {

	public static void main(String[] args) {
		
		int area = 2;
		int[] res = constructRectangle(area);
		for(int i = 0;i<res.length;i++){
			System.out.print(res[i] + " ");
		}

	}

	public static int[] constructRectangle(int area) {
		
		int[] res = new int[2];
		int sqrt = (int) Math.sqrt(area);
		if(sqrt * sqrt == area){
			res[0] = sqrt;
			res[1] = sqrt;
			return res;
		}else if(sqrt * sqrt < area){
			sqrt ++;
		}
		int length = sqrt;
		for(int i = length;i<=area;i++){
			if(area % i == 0){
				res[0] = i;
				res[1] = area / i;
				break;
			}
		}
		return res;
		
	}
}
