package com.ssafy.algo.BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class P1987 {
	private static String input = "5 5\r\n" + "IEFCJ\r\n" + "FHFKC\r\n" + "FFALF\r\n" + "HFGCF\r\n" + "HMCHH";

	private static char board[][];
	private static boolean visited[][];
	private static int max = 0;

	// public static void Move(int x, int y, int cnt, String str, int R, int C) {
	public static void Move(int x, int y, int cnt, String str, int R, int C) {
//		if (str.contains(Character.toString(board[x][y]))) {
//			max = Math.max(max, cnt);
//			return;
//		}

		// for (int i = x, j = y; i < R && j < C; i++, j++) {

		// if (!visited[x][y]) {

		if (x != 0 || y != 0) {
			if (str.contains(Character.toString(board[x][y])))
				return;
			str += board[x][y];
			visited[x][y] = true;
		}

		if (x - 1 >= 0 && !visited[x - 1][y])
			Move(x - 1, y, cnt + 1, str, R, C);
		if (x + 1 < R && !visited[x + 1][y])
			Move(x + 1, y, cnt + 1, str, R, C);
		if (y - 1 >= 0 && !visited[x][y - 1])
			Move(x, y - 1, cnt + 1, str, R, C);
		if (y + 1 < C && !visited[x][y + 1])
			Move(x, y + 1, cnt + 1, str, R, C);

		visited[x][y] = false;
		max = Math.max(max, cnt);
		return;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(input));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String temp = in.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = temp.charAt(j);
			}
		}

		visited[0][0] = true;
		Move(0, 0, 1, "" + board[0][0], R, C);
		System.out.println(max);
	}
}
