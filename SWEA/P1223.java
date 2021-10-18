package com.ssafy.algo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;

public class P1223 {
	private static String input = "101\r\n"
			+ "9+5*2+1+3*3*7*6*9*1*7+1+8*6+6*1*1*5*2*4*7+4*3*8*2*6+7*8*4*5+3+7+2+6+5+1+7+6+7*3*6+2+6+6*2+4+2*2+4*9*3\r\n"
			+ "79\r\n" + "4+4*3*4*9+2+7*4*7+7*7*9*5*2+8*8+2*6*7*3*7*9*3*4+8+8*9+3+9+6+9+4*1+6*3+5+1+7+5*1\r\n"
			+ "113\r\n"
			+ "2+3+9*9+8+2*1+3*2*3*1+3*3+1+2+3*6*2*7*4+9+1+4+6+9*9*5+7+8+6+3+9*2+1+7+4+3+9*3*1+4*4+4*3*1+9*3+9*5*1*7*8+2+8+8*7+9\r\n"
			+ "89\r\n" + "4*9+1+1*8+8*9*7+1*4*5*2*5+8*3*5+5+2*4+2+8+6*2*2+9+3*1*2+2*5+9*2*3*9+6+7*9+9*4+7+6+6*6+3+8\r\n"
			+ "77\r\n" + "5+4+9+9*9*2+6*6*5+9+3*5+5*7*8*3*7*1*9*9+8+3+8*9*6+2*9*3+6*5+6*7*2+5+5*3+4*6+7\r\n" + "119\r\n"
			+ "5+7+1+6+3+6*7+7+5*5*3*5*6*9+5*9*5*9+8+8+5*1*6*2+3+2+8+6+2+2*3*4+5*8*3*6*2*9+1*7*7*4*2+2*5+6+7+2*7*4+9*6*4*3*1*3*5+3*7+8\r\n"
			+ "115\r\n"
			+ "8*6+3*9*8*7*6*3+5*7*6*6+3*5+2*4*9*3+5+2+1*4*1*7+6*8+9+3+2+8*3+8*2+6*9+2*2*7+8*1*2+9*3+1+5*5*8+4*1*2*4*2*6*3*8*8+4+1\r\n"
			+ "91\r\n"
			+ "5*8*4+5*7+9*2+6+5*7+1*7*9+8+6*1*2+7+5*9*6*3+4*8*9*6*1*3+7*1+2+5+1*4*9+6*4+7*1*2*4*2+3+3*4+9\r\n"
			+ "107\r\n"
			+ "7*1+7+5+3*7*1*7+8*3*8+7+3*2*6*2+3+6*4+3+8+9*4+1+5*7*8+9+1+2+5+6*7+4*5*2+4+8*4+7+9*1*3*1+1*2*8+3+2+9*1*5*9+7\r\n"
			+ "109\r\n"
			+ "1+1+7+3*2+1+3*7*8+9*6+1+8*3*7+8*5*7*7+4*3*7*4+7+3+2*2+7+8*8*6+6*6*7+7*1*5*7+3+1*5+1*8*4+9+6+7*5+3+1*8*8*9+4+7\r\n";

	private static String str;
	private static Stack<Integer> sint;
	// private static Stack<Character> sch;
	private static boolean mul;

	public static boolean checkPlus(String temp) {
		if (temp.equals("+"))
			return true;
		return false;

	}

	public static int calculate(int len) {
		sint = new Stack<Integer>();
		// sch = new Stack<Character>();
		int pluscnt = 0;
		int result = 0;
		for (int i = 0; i < len; i++) {
			char temp = str.charAt(i);
			if (mul == true) {
				int a = sint.pop();
				sint.add(a * (temp - '0'));
				mul = false;
				continue;

			}
			if (temp >= 48 && temp <= 57) {
				sint.add(temp - '0');
			} else {
				if (checkPlus(Character.toString(temp))) {
					// sch.add(temp);
					pluscnt++;
				} else {
					mul = true;
					continue;
				}

			}
		}

		// while (sch.isEmpty()) {
		while (pluscnt > 0) {
			int a = sint.pop();
			int b = sint.pop();
			// sch.pop();
			pluscnt--;
			sint.add(a + b);
		}
		return result = sint.pop();
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(input));
		StringBuilder sb = new StringBuilder();

		for (int tc = 0; tc < 10; tc++) {
			sb.append("#").append(tc + 1).append(" ");
			int len = Integer.parseInt(in.readLine());

			str = in.readLine();
			sb.append(calculate(len)).append("\n");
		}
		System.out.println(sb.toString());
	}

}
