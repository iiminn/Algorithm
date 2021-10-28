package com.ssafy.algo.BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class P10026 {
	private static String input = "5\r\n" + "RRRBB\r\n" + "GGBBB\r\n" + "BBBRR\r\n" + "BBRRR\r\n" + "RRRRR";
	private static char rgb[][];
	private static int dx[] = { -1, 1, 0, 0 };
	private static int dy[] = { 0, 0, -1, 1 };

//	public static class Node {
//		int x, y;
//		char ch;
//
//		public Node(int x, int y, char ch) {
//			this.x = x;
//			this.y = y;
//			this.ch = ch;
//		}
//	}
//
//	public static void rgbBFS(int N) {
//		Queue<Node> q = new LinkedList<Node>();
//		Node node = new Node(0, 0, 'R');
//		q.offer(node);
//		number[0][0] = cnt;
//		while (!q.isEmpty()) {
//			Node temp = q.poll();
//
//			if (temp.x - 1 >= 0 && rgb[temp.x - 1][temp.y] == temp.ch) {
//				number[temp.x - 1][temp.y] = cnt;
//				temp.x -= 1;
//				q.offer(temp);
//			}
//			if (temp.x + 1 < N && rgb[temp.x + 1][temp.y] == temp.ch) {
//				number[temp.x + 1][temp.y] = cnt;
//				temp.x += 1;
//				q.offer(temp);
//			}
//			if (temp.y - 1 >= 0 && rgb[temp.x][temp.y - 1] == temp.ch) {
//				number[temp.x][temp.y - 1] = cnt;
//				temp.y -= 1;
//				q.offer(temp);
//			}
//			if (temp.y + 1 < N && rgb[temp.x][temp.y + 1] == temp.ch) {
//				number[temp.x][temp.y + 1] = cnt;
//				temp.y += 1;
//				q.offer(temp);
//
//			}
//
//		}
//
//	}

	public static void rgbDFS(int x, int y, boolean visited[][], char ch, int N) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || rgb[nx][ny] != ch)
				continue;

			rgbDFS(nx, ny, visited, ch, N);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(input));

		int N = Integer.parseInt(in.readLine());
		rgb = new char[N][N];
		boolean visited[][][] = new boolean[2][N][N];

		for (int i = 0; i < N; i++) {
			String temp = in.readLine();
			for (int j = 0; j < N; j++) {
				rgb[i][j] = temp.charAt(j);
			}
		}

		int num[] = new int[2];

		for (int t = 0; t < 2; t++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[t][i][j]) {
						num[t]++;
						rgbDFS(i, j, visited[t], rgb[i][j], N);
					}

					if (rgb[i][j] == 'G') {
						rgb[i][j] = 'R';
					}
				}
			}
		}

		System.out.println(num[0] + " " + num[1]);

		// rgbBFS(0, 0, N);
		// number = new int[N][N];
//		initnumber(N);
//		rbBFS(N);
	}

}
