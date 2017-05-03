package com.leetcode.reshapethematrix;

import java.util.ArrayList;
import java.util.List;

public class ReshapeTheMatrix2 {

	public static void main(String[] args) {
		
		int[][] nums = {{1,2},{3,4}};
		int r = 1;
		int c = 4;
		int[][] res = matrixReshape(nums, r, c);
		for(int i = 0;i<res.length;i++){
			for(int j = 0;j<res[i].length;j++){
				System.out.print(res[i][j] + " " );
			}
		}

	}

	public static int[][] matrixReshape(int[][]nums,int r,int c){
		
		 int n = nums.length, m = nums[0].length, k = 0;
		    if (r*c != n*m) return nums;
		    int[][] res = new int[r][c];
		    for (int i=0;i<r;i++) 
		        for (int j=0;j<c;j++,k++) 
		            res[i][j] = nums[k/m][k%m];
		    return res;
		
	}
}
