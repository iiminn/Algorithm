package com.ssafy.algo.BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class P1992 {

	private static String input = "8\n11110000\r\n" + "11110000\r\n" + "00011100\r\n" + "00011100\r\n" + "11110000\r\n"
			+ "11110000\r\n" + "11110011\r\n" + "11110011\n";

	private static int arr[][];
	private static String answer = "";

	public static boolean check(int startx, int starty, int N) {
		int ch = arr[startx][starty];

		for (int i = startx; i < startx + N; i++) {
			for (int j = starty; j < starty + N; j++) {
				if (ch != arr[i][j])
					return false;
			}
		}
		return true;
	}

	public static String QuadTree(int startx, int starty, int N) {
		String temp = "";

		if (N == 1) {
			temp += arr[startx][starty];
			return temp;
		}

		if (check(startx, starty, N)) {
			temp += arr[startx][starty];
			return temp;
		}
		temp += "(";
		temp += QuadTree(startx, starty, N / 2);
		temp += QuadTree(startx, starty + N / 2, N / 2);
		temp += QuadTree(startx + N / 2, starty, N / 2);
		temp += QuadTree(startx + N / 2, starty + N / 2, N / 2);
		temp += ")";

		return temp;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(input));
		int N = Integer.parseInt(in.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String tempS = in.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = tempS.charAt(j) - 48;
			}
		}
		answer += QuadTree(0, 0, N);

		System.out.println(answer);
	}

}
