package com.ssafy.algo.BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P2493 {
	private static String input = "5\r\n" + "6 9 5 7 4\n";

//		for (int i = N - 1; i >= 0; i--) {
//			if (i == 0) {
//				arr[i] = 0;
//			}
//			for (int j = i - 1; j >= 0; j--) {
//				if (arr[i] < arr[j]) {
//					arr[i] = j + 1;
//					break;
//				} else if (arr[i] > arr[j]) {
//					if (j == 0)
//						arr[i] = 0;
//				}
//
//			}
//		}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(input));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		Stack<Integer> s = new Stack<Integer>();
		Stack<Integer> index = new Stack<Integer>();

		int first = Integer.parseInt(st.nextToken());// 6
		int num = 1;
		s.add(first);
		index.push(num++);
		sb.append("0").append(" ");

		for (int i = 1; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());

			while (!s.isEmpty()) {
				if (temp < s.peek()) {
					sb.append(index.peek()).append(" ");
					break;
				}
				s.pop();
				index.pop();
			}
			if (s.isEmpty()) {
				sb.append("0").append(" ");
			}
			s.push(temp);
			index.push(num++);
		}

		System.out.print(sb.toString());

	}

}
