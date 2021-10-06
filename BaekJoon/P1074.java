package com.ssafy.algo.BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class P1074 {
	private static String input = "15 32767 32767";
	private static int num = 0;
	private static int start;

	public static void where(int n, int r, int c) {
		while (n > 1) {
			if (r < n / 2 && c < n / 2) {
				start += 0;

			} else if (r < n / 2 && c >= n / 2) {
				start += n * n / 4;
				c -= n / 2;
			} else if (r >= n / 2 && c < n / 2) {
				start += n * n / 4 * 2;
				r -= n / 2;
			} else if (r >= n / 2 && c >= n / 2) {
				start += n * n / 4 * 3;
				r -= n / 2;
				c -= n / 2;
			}

			n /= 2;
		}
	}

//	 static void solution(int size, int startX, int startY) {
//
//	      if (startX == r && startY == c) {
//	         System.out.println(answer);
//	         System.exit(0);
//	      }
//
//	      if (startX <= r && r < (startX + size) && startY <= c && c < (startY + size)) {
//	         solution(size / 2, startX, startY);
//	         solution(size / 2, startX, startY + size / 2);
//	         solution(size / 2, startX + size / 2, startY);
//	         solution(size / 2, startX + size / 2, startY + size / 2);
//	      } else {
//	         answer += size * size;
//	      }
//	   }

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(input));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int n = (int) Math.pow(2, N);
		where(n, r, c);

		System.out.println(start);
	}

}
