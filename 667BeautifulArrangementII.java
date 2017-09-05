package com.leetcode.BeautifulArrangementII;

public class BeautifulArrangementII {

	public static void main(String[] args) {
		
		int n = 5;
		int k = 4;

		int[] res = constructArray(n, k);
		for(int i = 0;i<res.length;i++){
			System.out.print(res[i] + " ");
		}
		
	}
	
	public static int[] constructArray(int n, int k) {
		
		int[] res = new int[n];
		if(k == 1){
			for(int i = 0;i<n;i++){
				res[i] = i+1;
			}
			return res;
		}else{
			int times = 1;
			res[times - 1] = 1;
			int end = n;
			int start = 2;
			boolean flag = true;
			while(times < k){
				if(flag){
					res[times] = end;
					end --;
					flag = !flag;
				}else{
					res[times] = start;
					start ++;
					flag = !flag;
				}
				times ++;
			}
			if(!flag){
				for(int i = times;i<=n-1;i++){
					res[i] = end;
					end --;
				}
			}else{
				for(int i = times;i<=n-1;i++){
					res[i] = start;
					start ++;
				}
			}
			return res;
			
		}
		
	}
		

}
