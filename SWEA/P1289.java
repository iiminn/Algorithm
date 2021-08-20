package com.ssafy.algo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class P1289 {
	private static String input = "10\n" + "01010101010101010101010101010101010101010101010101\n" + "01\n"
			+ "1000110010011111010110000100100000000001001\n" + "10011010001110111010111010001100101101\n"
			+ "00110101100001010000110010111\n" + "101111110101010100111100101111001\n" + "01110011110001110\n"
			+ "1010101001010101010101010100111111\n" + "01010100010100101100111010100010111111011001011000\n"
			+ "1111100101101110000\n";

	public static int solution(String str) {
		int answer = 0;
		// 맨뒤가 1일때만 추가로 +1
		if (str.charAt(0) == '1') {
			answer++;
		}

		for (int i = str.length() - 1; i >= 0; i--) {
			if (i != 0 && str.charAt(i) != str.charAt(i - 1)) {
				answer++;
			}
		}
		return answer;

		// 길이 및 0으로 초기화
//		StringBuilder origin = new StringBuilder();
//		for (int i = 0; i < str.length(); i++) {
//			origin.append("0");
//		}

//		int i = str.indexOf("1");
//		while (i < str.length()) {// 1
//			String temp = origin.toString();// 111
//			if (temp.equals(str)) {
//				return answer;
//			}
//
//			if (str.charAt(i) == '1') {
//				for (int j = i; j < str.length(); j++) {
//
//					origin.replace(j, j + 1, "1");
//				}
//			} else if (str.charAt(i) == '0') {
//				for (int j = i; j < str.length(); j++) {
//					origin.replace(j, j + 1, "0");
//				}
//			}
//			answer++;
//
//			i++;
//		}

		// return answer;

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(input));
		int testCase = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= testCase; tc++) {
			sb.append("#").append(tc).append(" ");

			String str = in.readLine();
			int answer = solution(str);

			sb.append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}

}
