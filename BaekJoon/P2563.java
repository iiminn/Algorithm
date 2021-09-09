package com.ssafy.algo.BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class P2563 {
	private static String input = "3\r\n" + "3 7\r\n" + "15 7\r\n" + "5 2\n";
	// private static int arr[][];
	private static boolean paper[][] = new boolean[100][100];
	private static int sum = 0;

	public static void area_check(int x, int y) {
		for (int i = x; i < x + 10; i++) {
			for (int j = y; j < y + 10; j++) {
				if (paper[i][j] == true)
					continue;
				paper[i][j] = true;
				sum++;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(input));
		int N = Integer.parseInt(in.readLine());

		// arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			int arr[] = new int[2];
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 2; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			area_check(arr[0], arr[1]);
		}

		System.out.println(sum);

//		Arrays.sort(arr, new Comparator<int[]>() {
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				if (o1[0] == o2[0])
//					return o1[1] - o2[1];
//				else
//					return o1[0] - o2[0];
//			}
//		});

	}

}
