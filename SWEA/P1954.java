package com.ssafy.algo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class P1954 {

	private static String input = "10\r\n" + "1\r\n" + "2\r\n" + "3\r\n" + "4\r\n" + "5\r\n" + "6\r\n" + "7\r\n"
			+ "8\r\n" + "9\r\n" + "10\n";
	private static int snailarr[][];
	// private static int flag = 0;// 0:-> ,1: 아래로, 2: <-, 3: 위로

	public static void Snail(int N) {
		snailarr = new int[N][N];
		int num = 1;
		int j = -1, k = 0;
		for (int i = 0; i < 2 * N - 1; i++) {
			if (i % 4 == 0) {
				for (j = j + 1; j < N; j++) {
					if (num > N * N)
						break;
					if (j != 0 && snailarr[k][j] != 0) {
						// j--;
						break;
					}
					if (i > 0 && j == 0) {
						j++;
						// continue;
					}
					snailarr[k][j] = num;
					num++;
				}
			} else if (i % 4 == 1) {
				j--;

				for (k = k + 1; k < N; k++) {
					if (num > N * N)
						break;
					if (snailarr[k][j] != 0) {
						// k--;//
						break;//
					}
					snailarr[k][j] = num;
					num++;
				}
			} else if (i % 4 == 2) {
				k--;
				for (j = j - 1; j >= 0; j--) {//
					if (num > N * N)
						break;
					if (snailarr[k][j] != 0) {
						j++;
						break;
					}
					snailarr[k][j] = num++;
				}
				if (j == -1)
					j = 0;
			} else if (i % 4 == 3) {

				for (k = k - 1; k < N; k--) {
					if (num > N * N)
						break;
					if (snailarr[k][j] != 0) {
						k++;
						break;
					}
					snailarr[k][j] = num++;
				}
			}

		}

	}

	public static int[][] snail2(int size) {
		int[][] arr = new int[size][size];
		boolean[][] check = new boolean[size][size];

		int dir = 0; // 우 : 0 하 : 1 좌 : 2 상 : 3
		int key = 2; // 넣을 값
		int row = 0; // 행
		int col = 1; // 열

		arr[0][0] = 1;
		check[0][0] = true;

		while (key <= size * size) {
			if (dir == 0) {
				if (col + 1 <= size - 1 && check[row][col + 1] == false) {// if문에서 다음걸 미리 판단해보는것
					arr[row][col++] = key;
					check[row][col] = true;
				} else {
					dir = 1;
					arr[row++][col] = key;
					check[row][col] = true;
				}
			} else if (dir == 1) {
				if (row + 1 <= size - 1 && check[row + 1][col] == false) {
					arr[row++][col] = key;
					check[row][col] = true;
				} else {
					dir = 2;
					arr[row][col--] = key;
					check[row][col] = true;
				}
			} else if (dir == 2) {
				if (col - 1 >= 0 && check[row][col - 1] == false) {
					arr[row][col--] = key;
					check[row][col] = true;
				} else {
					dir = 3;
					arr[row--][col] = key;
					check[row][col] = true;
				}
			} else if (dir == 3) {
				if (row - 1 >= 0 && check[row - 1][col] == false) {
					arr[row--][col] = key;
					check[row][col] = true;
				} else {
					dir = 0;
					arr[row][col++] = key;
					check[row][col] = true;
				}
			}
			key++;
		}

		return arr;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(input));
		int T = Integer.parseInt(in.readLine());
		int[] testCases = new int[T];
		for (int i = 0; i < T; i++) {
			testCases[i] = Integer.parseInt(in.readLine());
		}

		for (int tc = 0; tc < T; tc++) {
			System.out.print("#" + (tc + 1) + "\n");
			Snail(testCases[tc]);
			for (int i = 0; i < testCases[tc]; i++) {
				for (int j = 0; j < testCases[tc]; j++) {
					System.out.print(snailarr[i][j] + " ");
				}
				System.out.println();
			}
		}

//		 int[][] arr = snail(size);
//		 for(int j=0; j<size; j++) {
//	            for(int k=0; k<size; k++) {
//	               sb.append(arr[j][k]).append(" ");
//	            }
//	            sb.append("\n");
//	         }         

	}

}
