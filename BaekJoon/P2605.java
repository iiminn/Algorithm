package com.ssafy.algo.BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P2605 {
	private static String input = "5\r\n" + "0 1 1 3 2";
	private static int number[];
	private static List<Integer> order = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(input));

		int n = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		number = new int[n];

		for (int i = 0; i < n; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}

		order.add(1);
		for (int i = 1; i < n; i++) {
			if (number[i] > 0) {
				order.add(i - number[i], i + 1);
			} else {
				order.add(i + 1);
			}

		}

		for (int i = 0; i < n; i++) {
			System.out.print(order.get(i) + " ");
		}
	}

}
