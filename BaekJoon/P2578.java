package com.ssafy.algo.BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class P2578 {
	private static String input = "11 12 2 24 10\r\n" + "16 1 13 3 25\r\n" + "6 20 5 21 17\r\n" + "19 4 8 14 9\r\n"
			+ "22 15 7 23 18\r\n" + "5 10 7 16 2\r\n" + "4 22 8 17 13\r\n" + "3 18 1 6 25\r\n" + "12 19 23 14 21\r\n"
			+ "11 24 9 20 15";

	private static Node[] arr = new Node[26];
	private static boolean ch[][] = new boolean[5][5];
	private static int bingoCnt = 0;

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static boolean searchLine() {
		bingoCnt = 0;

		for (int i = 0; i < 5; i++) {
			// 가로
			int col = 0;
			for (int j = 0; j < 5; j++) {
				if (ch[i][j] == false)
					break;
				col++;
				if (col == 5)
					bingoCnt++;
			}

			if (bingoCnt >= 3)
				return true;
			// 세로
			int row = 0;
			for (int j = 0; j < 5; j++) {
				if (ch[j][i] == false)
					break;
				row++;
				if (row == 5)
					bingoCnt++;
			}
			if (bingoCnt >= 3)
				return true;

		}

		int diagonal1 = 0;
		for (int i = 0; i < 5; i++) {
			// 대각선
			if (ch[i][i] == false)
				break;
			diagonal1++;
			if (diagonal1 == 5)
				bingoCnt++;
		}
		if (bingoCnt >= 3)
			return true;

		int diagonal2 = 0;
		for (int i = 0; i < 5; i++) {
			// 대각선
			if (ch[i][4 - i] == false)
				break;
			diagonal2++;
			if (diagonal2 == 5)
				bingoCnt++;
		}
		if (bingoCnt >= 3)
			return true;
		return false;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(input));

		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				int temp = Integer.parseInt(st.nextToken());
				Node n = new Node(i, j);
				arr[temp] = n;
			}
		}

		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				int temp = Integer.parseInt(st.nextToken());
				ch[arr[temp].x][arr[temp].y] = true;
				cnt++;

				if (cnt >= 5) {
					if (searchLine()) {
						System.out.println(cnt);
						return;
					}

				}

			}
		}
	}
}
