package com.ssafy.algo.BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class P1149 {
	private static String input = "3\r\n" + "26 40 83\r\n" + "49 60 57\r\n" + "13 89 99";
	// private static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(input));
		int N = Integer.parseInt(in.readLine());

		int[][] rgb = new int[N][3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				rgb[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dp = new int[N][3];
		dp[0][0] = rgb[0][0];
		dp[0][1] = rgb[0][1];
		dp[0][2] = rgb[0][2];

		for (int i = 1; i < N; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + rgb[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + rgb[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + rgb[i][2];
		}

		System.out.println(Math.min(Math.min(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]));

	}

}
