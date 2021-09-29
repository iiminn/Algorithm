package com.ssafy.algo.BJ;

import java.util.Scanner;

public class P2839 {
	private static int m = Integer.MAX_VALUE;
	private static int N;
	private static int s[] = { 3, 5 };

//	public static int sugar(int N) {
//		int rest;
//		int cnt = 0;
//		int temp;
//		while (N >= 0) {
//			if (N >= 5) {
//				temp = N / 5;
//				N -= 5 * temp;
//				cnt += temp;
//			}
//			// if(N<5>) {}
//			if (N >= 3) {
//				temp = N / 3;
//				N -= 3 * temp;
//				cnt += temp;
//			} else
//				return -1;
//			if (N == 0) {
//				return cnt;
//			}
////			if (N / 5 == 0) {
////				Math.min(min, N / 5);
////			}
//		}
//		return -1;
//
//	}

	public static void sugar2(int sum, int cnt, int start) {
		if (sum >= N) {
			if (sum == N) {
				if (m == -1)
					m = cnt;
				else
					m = Math.min(m, cnt);
			} else {
				if (m == Integer.MAX_VALUE)
					m = -1;
			}
			return;
		}

		for (int i = start; i < 2; i++) {
			sugar2(sum + s[i], cnt + 1, i);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sugar2(0, 0, 0);
		System.out.println(m);
	}

}
