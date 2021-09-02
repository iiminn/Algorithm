package com.ssafy.algo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class P9229 {
	private static String input = "4\r\n" + "3 45\r\n" + "20 20 20\r\n" + "6 10\r\n" + "1 2 5 8 9 11\r\n" + "4 100\r\n"
			+ "80 80 60 60\r\n" + "4 20\r\n" + "10 5 10 16\n";
	private static int weights[];
	private static int N, M, max;
	private static boolean visited[];

	public static void Cookie(int start, int cnt, int sum) {
		if (cnt == 2) {
			if (max < sum)
				max = sum;
			return;
		}
		for (int i = start; i < N; i++) {
			if (!visited[i] && sum + weights[i] <= M) {
				visited[i] = true;
				Cookie(i, cnt + 1, sum + weights[i]);
				visited[i] = false;
			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(input));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			weights = new int[N];
			visited = new boolean[N];
			max = 0;
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < N; i++) {
				weights[i] = Integer.parseInt(st.nextToken());
			}

			Cookie(0, 0, 0);

			if (max == 0)
				max = -1;
			sb.append(max).append("\n");
		}

		System.out.println(sb.toString());
	}

}
