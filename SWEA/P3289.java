package com.ssafy.algo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class P3289 {
	private static String input = "1\r\n" + "7 8\r\n" + "0 1 3\r\n" + "1 1 7\r\n" + "0 7 6\r\n" + "1 7 1\r\n"
			+ "0 3 7\r\n" + "0 4 2\r\n" + "0 1 1\r\n" + "1 1 1\n";

	private static int[] calculation;
	private static int[][] ab;
	private static int n;
	private static int[] parents;

	public static void make() {
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
	}

	public static int find(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = find(parents[a]);

	}

	public static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return;
		parents[bRoot] = aRoot;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(input));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			parents = new int[n + 1];

			calculation = new int[m];
			ab = new int[m][2];
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				calculation[i] = Integer.parseInt(st.nextToken());
				for (int j = 0; j < 2; j++) {
					ab[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			make();
			for (int i = 0; i < m; i++) {
				if (calculation[i] == 0) {
					union(ab[i][0], ab[i][1]);
				} else {
					if (find(ab[i][0]) == find(ab[i][1]))
						sb.append("1");
					else
						sb.append("0");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
