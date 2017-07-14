package com.leetcode.DivideTwoIntegers;

public class DivideTwoIntegers2 {

	public static void main(String[] args) {
		
		int dividend = -2147483648;
		int divisor = -1;
		System.out.println(divide(dividend, divisor));

	}
	
	public static int divide(int dividend, int divisor) {
		
		if(dividend == -2147483648 && divisor == -1){
			return Integer.MAX_VALUE;
		}
		boolean neg = (dividend > 0) ^ (divisor > 0);
		long div1 = (long)dividend;
		long div2 = (long)divisor;
	    if(dividend < 0)
	    	div1 = -div1;
	    if(divisor < 0)
	    	div2 = -div2;
	    if(div1 < div2){
	    	return 0;
	    }
	    int msb = 0;
	    //msd记录除数需要左移的位数
	    for(msb = 0; msb < 32; msb++) {
	        if((div2 << msb) >= div1)
	            break;
	    }
	    long q = 0; //记录每次除法的商
	    for(int i = msb; i >= 0; i--) {
	        if((div2 << i) > div1)
	            continue;
	        q |= (1 << i);
	        div1 -= (div2 << i);
	    }
//	    if(q > Integer.MAX_VALUE){
//	    	q = Integer.MAX_VALUE;
//	    }
	    if(neg)
	        return (int)-q;
	    return (int)q;
		
	}

}
