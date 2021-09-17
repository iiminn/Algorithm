package com.ssafy.algo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P6808 {
	private static String input = "4\r\n" + "1 3 5 7 9 11 13 15 17\r\n" + "18 16 14 12 10 8 6 4 2\r\n"
			+ "13 17 9 5 18 7 11 1 15\r\n" + "1 6 7 9 12 13 15 17 18";
	private static String input2 = "1\n1 3 5 7 9 11 13 15 17";
	private static int Gyu[];
	private static int iny[];
	private static boolean[] visited_I;
	private static int[] total;// 0: G이긴, 1:I이긴

	public static void WinOrLose(int cnt, int scoreG, int scoreI) {
		if (cnt == 9) {
			if (scoreG > scoreI) {
				total[0]++;
			} else if (scoreG < scoreI) {
				total[1]++;
			}
			return;
		}

		for (int i = 0; i < 9; i++) {

			if (!visited_I[i]) {
				visited_I[i] = true;
				if (iny[i] > Gyu[cnt]) {
					WinOrLose(cnt + 1, scoreG, scoreI + Gyu[cnt] + iny[i]);
				} else if (iny[i] < Gyu[cnt]) {
					WinOrLose(cnt + 1, scoreG + Gyu[cnt] + iny[i], scoreI);
				}
				visited_I[i] = false;
				// visited_G[i] = true;
				// cnt1++;
				// for (int j = 0; j < 9; j++) {
				// if (!visited_I[j]) {
//						visited_I[j] = true;
//						if (iny[j] > Gyu[i]) {
//							WinOrLose(i, cnt + 1, scoreG, scoreI + Gyu[i] + iny[j]);
//						} else if (iny[j] < Gyu[i]) {
//							WinOrLose(i, cnt + 1, scoreG + Gyu[i] + iny[j], scoreI);
//						}
//						visited_I[j] = false;
				// }
				// }
				// cnt1--;
				// visited_G[i] = false;
			}
			// c++;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(input));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			Gyu = new int[9];
			iny = new int[9];
			total = new int[2];
			visited_I = new boolean[9];
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");

			int[] temp = new int[9];
			for (int i = 0; i < 9; i++) {
				Gyu[i] = Integer.parseInt(st.nextToken());
				temp[i] = Gyu[i];
			}
			Arrays.sort(temp);

			int cnt = 0, cnt2 = 0;
			for (int i = 0; i < 18; i++) {
				if (cnt < 9 && (i + 1) == temp[cnt]) {
					cnt++;
				} else {
					iny[cnt2++] = i + 1;
				}
			}

			WinOrLose(0, 0, 0);
			sb.append(total[0]).append(" ").append(total[1]).append("\n");

		}
		System.out.println(sb.toString());
	}

}
