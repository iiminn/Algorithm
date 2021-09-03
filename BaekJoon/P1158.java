package com.ssafy.algo.BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1158 {
	private static String input = "7 3\n";
	private static Queue<Integer> number = new LinkedList<Integer>();
	private static List<Integer> order = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(input));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// order = new int[N];
		for (int i = 0; i < N; i++) {
			number.offer(i + 1);
		}

		// int cycle = 0;
		int cnt = 1;
		sb.append("<");

		for (int i = 0; !number.isEmpty(); i++) {
//			if (i == number.size()) {
//				i = 0;
//			}
			if (number.size() == 1) {
				order.add(number.poll());
				break;
			}

			if (cnt == K) {
				order.add(number.poll());
				cnt = 1;
//				if (i == number.size())
//					i = 0;// i=-1;
			} else {
				cnt++;
				number.offer(number.poll());
			}
		}

		for (int i = 0; i < order.size(); i++) {
			if (i == order.size() - 1) {
				sb.append(order.get(i));
				break;
			}
			sb.append(order.get(i)).append(", ");
		}
		sb.append(">");
		System.out.println(sb.toString());
	}

}
