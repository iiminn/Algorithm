package com.ssafy.algo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class P5215 {
	private static String input = "1\r\n" + "5 1000\r\n" + "300 300\r\n" + "300 300\r\n" + "250 300\r\n"
			+ "500 1000\r\n" + "400 500\n";
	private static int ingredient[][];
	private static int N, L;
	private static boolean visited[];
	private static int answer = 0;

	public static void diet(int start, int cal, int score) {
		if (cal >= L || start == N - 1) {
			if (answer < score)
				answer = score;
			return;
		}

		for (int i = start; i < N; i++) {
			if (!visited[i] && (cal + ingredient[i][1]) <= L) {
				visited[i] = true;
				diet(i, cal + ingredient[i][1], score + ingredient[i][0]);
				visited[i] = false;
				// diet(i, cal, score);
			}
		}
		if (answer < score)
			answer = score;
		return;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(input));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			answer = 0;
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			visited = new boolean[N];
			ingredient = new int[N][2];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < 2; j++) {
					ingredient[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// Arrays.sort(ingredient);
			// int answer = diet(0, 0, 0);
			diet(0, 0, 0);
			sb.append(answer).append("\n");

		}
		System.out.println(sb.toString());
	}

}
