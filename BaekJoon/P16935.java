package com.ssafy.algo.BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class P16935 {
	private static String input = "6 8 6\r\n" + "3 2 6 3 1 2 9 7\r\n" + "9 7 8 2 1 4 5 3\r\n" + "5 9 2 1 9 6 1 8\r\n"
			+ "2 1 3 8 6 3 9 2\r\n" + "1 3 2 8 7 9 2 1\r\n" + "4 5 1 9 8 2 1 3\r\n" + "1 2 3 4 5 6\n";
	private static int arr[][];
	private static int transArr[][];
	private static int N, M;

	public static void Calc1() {
		for (int i = 0; i < N / 2; i++) {
			int temp[] = arr[i];
			arr[i] = arr[N - 1 - i];
			arr[N - 1 - i] = temp;
		}
	}

	public static void Calc2() {
		for (int j = 0; j < M / 2; j++) {
			for (int i = 0; i < N; i++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][M - 1 - j];
				arr[i][M - 1 - j] = temp;
			}
		}

	}

	public static void Calc3() {
		transArr = new int[M][N];
		for (int j = 0; j < M; j++) {// M
			for (int i = 0; i < N; i++) {// N
				transArr[j][N - 1 - i] = arr[i][j];
			}
		}

		int temp = N;
		N = M;
		M = temp;

		arr = transArr;

//		// List<Integer> ch[] = new ArrayList[M];
//		ch2 = new int[M][N];
//		for (int r = 0; r < (R % 4); r++) {
//			if (N != M) {
//				if (r % 2 == 1) {
//					for (int j = 0; j < M; j++) {// M
//						for (int i = 0; i < N; i++) {// N
//							// ch[j].add(arr[i][j]);
//							ch2[j][N - 1 - i] = arr[i][j];
//						}
//					}
//				} else {
//					for (int j = 0; j < M; j++) {// M
//						for (int i = 0; i < N; i++) {// N
//							// ch[j].add(arr[i][j]);
//							arr[N-1-i][M-1-j]=ch2[i][j];
//						}
//					}
//				}
//			} else {
//
//			}
////			if (R % 2 == 1)
////				return ch2;
////
////			return arr;
//		}
//
////		if (N != M && (R % 2 == 1)) {
////			int arrRot[][] = new int[M][N];
////			R = R % 4;
////			for (int r = 0; r < R; r++) {
////
////			}
////
////			return arrRot;
////		} else {
////			return arr;
////		}
	}

	public static void Calc4() {
		transArr = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				transArr[M - 1 - j][i] = arr[i][j];
			}
		}
		int temp = N;
		N = M;
		M = temp;

		arr = transArr;
	}

	public static void Calc5() {
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				int temp[] = new int[M / 2];
				temp[j] = arr[i][j];
				arr[i][j] = arr[i][M / 2 + j];
				arr[i][M / 2 + j] = temp[j];
			}
			for (int j = 0; j < M / 2; j++) {
				int temp[] = new int[M / 2];
				temp[j] = arr[N / 2 + i][M / 2 + j];
				arr[N / 2 + i][M / 2 + j] = arr[i][j];
				arr[i][j] = temp[j];
			}
			for (int j = 0; j < M / 2; j++) {
				int temp[] = new int[M / 2];
				temp[j] = arr[N / 2 + i][j];
				arr[N / 2 + i][j] = arr[i][j];
				arr[i][j] = temp[j];
			}
		}

	}

	public static void Calc6() {
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				int temp[] = new int[M / 2];
				temp[j] = arr[N / 2 + i][j];
				arr[N / 2 + i][j] = arr[i][j];
				arr[i][j] = temp[j];
			}
			for (int j = 0; j < M / 2; j++) {
				int temp[] = new int[M / 2];
				temp[j] = arr[N / 2 + i][M / 2 + j];
				arr[N / 2 + i][M / 2 + j] = arr[i][j];
				arr[i][j] = temp[j];
			}
			for (int j = 0; j < M / 2; j++) {
				int temp[] = new int[M / 2];
				temp[j] = arr[i][j];
				arr[i][j] = arr[i][M / 2 + j];
				arr[i][M / 2 + j] = temp[j];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(input));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// int flag = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine(), " ");
		int r = 0;
		while (r < R) {
			switch (Integer.parseInt(st.nextToken())) {
			case 1: {
				Calc1();
				break;
			}
			case 2: {
				Calc2();
				break;
			}
			case 3: {
				Calc3();
				break;
			}
			case 4: {
				Calc4();
				break;
			}
			case 5: {
				Calc5();
				break;
			}
			case 6: {
				Calc6();
				break;

			}

			}
			r++;
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

}
