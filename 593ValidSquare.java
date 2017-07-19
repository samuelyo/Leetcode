package com.leetcode.ValidSquare;

import java.util.ArrayList;
import java.util.List;

public class ValidSquare {

	public static void main(String[] args) {
	
		int[] p1 = {0,0};
		int[] p2 = {1,1};
		int[] p3 = {1,0};
		int[] p4 = {0,1};
		System.out.println(validSquare(p1, p2, p3, p4));

	}

	public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		
		double k12 = 0,k13 = 0,k14 = 0,k23 = 0,k24 = 0,k34 = 0;
		if(p2[0] - p1[0] == 0){
			k12 = Double.POSITIVE_INFINITY;
		}
		if(p2[1] - p1[1] == 0){
			k12 = 0;
		}
		if(p3[0] - p1[0] == 0){
			k13 = Double.POSITIVE_INFINITY;
		}
		if(p3[1] - p1[1] == 0){
			k13 = 0;
		}
		if(p4[0] - p1[0] == 0){
			k14 = Double.POSITIVE_INFINITY;
		}
		if(p4[1] - p1[1] == 0){
			k14 = 0;
		}
		if(p3[0] - p2[0] == 0){
			k23 = Double.POSITIVE_INFINITY;
		}
		if(p3[1] - p2[1] == 0){
			k23 = 0;
		}
		if(p4[0] - p2[0] == 0){
			k24 = Double.POSITIVE_INFINITY;
		}
		if(p4[1] - p2[1] == 0){
			k24 = 0;
		}
		if(p4[0] - p3[0] == 0){
			k34 = Double.POSITIVE_INFINITY;
		}
		if(p4[1] - p3[1] == 0){
			k34 = 0;
		}
		
		boolean vertical = false;
		List<int[]> pOne = new ArrayList<int[]>();
		List<int[]> pTwo = new ArrayList<int[]>();
		if(k12 == Double.POSITIVE_INFINITY && k34 == 0 || k12 == 0 && k34 == Double.POSITIVE_INFINITY || p2[0] - p1[0] != 0 && p4[0] - p3[0] != 0 && ((p2[1] - p1[1]) * (p4[1] - p3[1]))/((p2[0] - p1[0]) * (p4[0] - p3[0])) == -1){
			vertical = true;
			pOne.add(p1);
			pOne.add(p2);
			pTwo.add(p3);
			pTwo.add(p4);
		}else if(k13 == Double.POSITIVE_INFINITY && k24 == 0 || k13 == 0 && k24 == Double.POSITIVE_INFINITY || p3[0] - p1[0] != 0 && p4[0] - p2[0] != 0 && ((p3[1] - p1[1]) * (p4[1] - p2[1]))/((p3[0] - p1[0]) * (p4[0] - p2[0])) == -1){
			vertical = true;
			pOne.add(p1);
			pOne.add(p3);
			pTwo.add(p2);
			pTwo.add(p4);
		}else if(k14 == Double.POSITIVE_INFINITY && k23 == 0 || k14 == 0 && k23 == Double.POSITIVE_INFINITY || p4[0] - p1[0] != 0 && p3[0] - p2[0] != 0 && ((p4[1] - p1[1]) * (p3[1] - p2[1]))/((p4[0] - p1[0]) * (p3[0] - p2[0])) == -1){
			vertical = true;
			pOne.add(p1);
			pOne.add(p4);
			pTwo.add(p2);
			pTwo.add(p3);
		}
		if(!vertical){
			return false;
		}else{
			int[] one = pOne.get(0);
			int[] two = pTwo.get(0);
			long temp = (one[0] - two[0])*(one[0] - two[0]) + (one[1] - two[1])*(one[1] - two[1]); 
			for(int i = 0;i<pOne.size();i++){
				for(int j = 0;j<pTwo.size();j++){
					int[] oneCur = pOne.get(i);
					int[] twoCur = pTwo.get(j);
					if(temp != (oneCur[0] - twoCur[0])*(oneCur[0] - twoCur[0]) + (oneCur[1] - twoCur[1])*(oneCur[1] - twoCur[1])){
						return false;
					}
				}
			}
			int[] three = pOne.get(1);
			int x1 = one[0] - two[0];
			int y1 = one[1] - two[1];
			int x2 = three[0] - two[0];
			int y2 = three[1] - two[1];
			if(x1 * x2 + y1 * y2 == 0){
				return true;
			}else{
				return false;
			}
			
		}
		
	}
}
