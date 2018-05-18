package com.onlinetest.tencent;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PlayList {

	public static int MOD = 1000000007;

	public static Map<Long, Long> map1 = new HashMap<Long, Long>();
	public static Map<String, BigInteger> map = new HashMap<String, BigInteger>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			long sum = sc.nextLong();
			long A_len = sc.nextLong();
			long A_num = sc.nextLong();
			long B_len = sc.nextLong();
			long B_num = sc.nextLong();

			BigInteger res = BigInteger.ZERO;
			for (long i = 0; i <= A_num; i++) {
				for (long j = 0; j <= B_num; j++) {
					long temp = i * A_len + j * B_len;
					if (temp == sum) {
						res = res.add(combination(A_num, i).multiply(combination(B_num, j)));
					}
				}
			}
			BigInteger temp = res.mod(BigInteger.valueOf(MOD));
			System.out.println(temp.longValue());
		}
		sc.close();

	}

	public static BigInteger combination(long n, long m) {
		if (map.containsKey("" + n + " " + m)) {
			return map.get("" + n + " " + m);
		}
		if(m == 0) {
			return BigInteger.ONE;
		}
		if(m == 1) {
			return BigInteger.valueOf(n); 
		}
		if(n == 1) {
			return m == 1 ? BigInteger.ONE : BigInteger.ZERO;
		}
		BigInteger temp = combination(n - 1, m - 1).add(combination(n - 1, m));
		map.put("" + n + " " + m, temp);
		return temp;
	}

}
