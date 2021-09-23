package com.ssafy.algo.BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class P15686 {
	private static String input = "5 3\r\n" + "0 0 1 0 0\r\n" + "0 0 2 0 1\r\n" + "0 1 2 0 0\r\n" + "0 0 1 0 0\r\n"
			+ "0 0 0 0 2";
	private static int home[][];
	private static int chickhouse[][];
	private static int minStreet[];
	private static int min = Integer.MAX_VALUE;
	private static boolean visited[];
	private static int selectedChick[];

	public static void ChickenStreet(int M) {
		int sum = 0;
		for (int i = 0; i < minStreet.length; i++) {
			int closeValue = Integer.MAX_VALUE;
			for (int j = 0; j < M; j++) {
				closeValue = Math.min(closeValue, Math.abs(home[i][0] - chickhouse[selectedChick[j]][0])
						+ Math.abs(home[i][1] - chickhouse[selectedChick[j]][1]));
			}

			minStreet[i] = closeValue;
			sum += minStreet[i];// 임시도시 치킨거리
		}
		min = Math.min(min, sum);// 도시 치킨거리
		return;
	}

	public static void chooseChicken(int start, int cnt, int M) {
		if (cnt == M) {
			ChickenStreet(M);
			return;
		}

		// for (int c = start; chickhouse[c][0] != -1 && c < chickhouse.length; c++) {
		for (int c = start; c < visited.length; c++) {
			if (!visited[c]) {
				visited[c] = true;
				selectedChick[cnt] = c;//
				chooseChicken(c + 1, cnt + 1, M);
				selectedChick[cnt] = -1;
				visited[c] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(input));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		home = new int[2 * N][2];
		chickhouse = new int[13][2];

		for (int i = 0; i < 13; i++) {
			chickhouse[i][0] = -1;
		}
		int c = 0, h = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == 1) {
					home[h][0] = i;
					home[h++][1] = j;
				} else if (temp == 2) {
					chickhouse[c][0] = i;
					chickhouse[c++][1] = j;
				}
			}
		}

		minStreet = new int[h];
		visited = new boolean[c];
		selectedChick = new int[M];

		chooseChicken(0, 0, M);
		System.out.println(min);
	}

}
