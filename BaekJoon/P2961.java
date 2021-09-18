package com.ssafy.algo.BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class P2961 {
	private static String input = "1\r\n" + "3 10";
	private static int taste[][];
	private static int min = Integer.MAX_VALUE;
	// private static boolean visited[];

	public static void combi(int start, int cnt, int mul, int sum, int N) {
		if (start == N) {
			if (cnt == 0)
				return;
			int temp = Math.abs(mul - sum);
			min = Math.min(temp, min);
			return;
		}
		for (int i = start; i < N; i++) {
			combi(i + 1, cnt + 1, mul * taste[i][0], sum + taste[i][1], N);
			combi(i + 1, cnt, mul, sum, N);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(input));

		int N = Integer.parseInt(in.readLine());
		taste = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 2; j++) {
				taste[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		combi(0, 0, 1, 0, N);
		System.out.println(min);
	}

}
