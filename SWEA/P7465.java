package com.ssafy.algo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P7465 {
	private static String input = "2\r\n" + "6 5\r\n" + "1 2\r\n" + "2 5\r\n" + "5 1\r\n" + "3 4\r\n" + "4 6\r\n"
			+ "6 8\r\n" + "1 2\r\n" + "2 5\r\n" + "5 1\r\n" + "3 4\r\n" + "4 6\r\n" + "5 4\r\n" + "2 4\r\n" + "2 3";

	private static int neighbor[];

	public static void make(int N) {
		for (int i = 1; i <= N; i++) {
			neighbor[i] = i;
		}
	}

	public static int Find(int a) {
		if (neighbor[a] == a)
			return a;
		return neighbor[a] = Find(neighbor[a]);
	}

	public static void UnionFind(int a, int b, int N) {
		int aRoot = Find(a);
		int bRoot = Find(b);

		if (aRoot == bRoot)
			return;
		neighbor[bRoot] = aRoot;

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(input));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());

		for (int tc = 0; tc < T; tc++) {
			sb.append("#").append(tc + 1).append(" ");

			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			neighbor = new int[N + 1];
			make(N);

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int temp1 = Integer.parseInt(st.nextToken());
				int temp2 = Integer.parseInt(st.nextToken());
				UnionFind(temp1, temp2, N);
			}

			List<Integer> group = new ArrayList<Integer>();
			for (int i = 1; i <= N; i++) {
				int temp = Find(i);
				if (group.isEmpty())
					group.add(temp);
				else {
					if (!group.contains(temp)) {
						group.add(temp);
					}
				}
			}

//			for (int i = 2; i <= N; i++) {
//				if (!group.contains(neighbor[i]))
//					group.add(neighbor[i]);
//			}

			sb.append(group.size()).append("\n");

		}

		System.out.println(sb.toString());

	}

}
