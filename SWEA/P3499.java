package com.ssafy.algo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P3499 {
	private static String input = "3\r\n" + "6\r\n" + "A B C D E F\r\n" + "4\r\n" + "JACK QUEEN KING ACE\r\n" + "5\r\n"
			+ "ALAKIR ALEXSTRASZA DR-BOOM LORD-JARAXXUS AVIANA\n";
	private static List<String> arrT;
	private static List<String> arrD;
	private static List<String> answer;

	public static void PerfectShuffle(int N) {
		answer = new ArrayList<String>();
		for (int i = 0; i < N; i++) {
			if (i % 2 == 0) {
				answer.add(arrT.get(i / 2));
			} else {
				answer.add(arrD.get(i / 2));
			}
		}
//		for (int i = 0; i < N / 2; i++) {
//			if (N % 2 == 1 && i == N / 2 - 1)
//				break;
//			arrT.add(arrT.indexOf()+, arrD.get(i));
//		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(input));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			arrT = new ArrayList<String>();
			arrD = new ArrayList<String>();
			if (N % 2 == 0) {// N이 짝수
				for (int i = 0; i < N / 2; i++) {
					arrT.add(st.nextToken());
				}
				for (int i = N / 2; i < N; i++) {
					arrD.add(st.nextToken());
				}
			} else {// N이 홀수
				for (int i = 0; i < N / 2 + 1; i++) {
					arrT.add(st.nextToken());
				}
				for (int i = N / 2 + 1; i < N; i++) {
					arrD.add(st.nextToken());
				}
			}
			PerfectShuffle(N);

			for (int i = 0; i < answer.size(); i++) {
				sb.append(answer.get(i)).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

}
