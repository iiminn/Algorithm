package com.ssafy.algo.BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class P3040 {
	private static String input = "8\r\n" + "6\r\n" + "5\r\n" + "1\r\n" + "37\r\n" + "30\r\n" + "28\r\n" + "22\r\n"
			+ "36";

	private static int dwarf[] = new int[7];
	private static boolean visited[] = new boolean[9];
	private static int height[] = new int[9];

	public static void findDwarf(int start, int cnt, int sum) {
		if (cnt == 7) {
			if (sum == 100) {
				int temp = 0;
				for (int i = 0; i < 9; i++) {
					if (visited[i] == true) {
						dwarf[temp++] = height[i];
					}
				}
			}
			return;
		}
		for (int i = start; i < 9; i++) {
			if (!visited[i]) {
				// dwarf[cnt] = height[i];
				visited[i] = true;
				findDwarf(i + 1, cnt + 1, sum + height[i]);
				// dwarf[cnt] = 0;
				visited[i] = false;
				// findDwarf(i + 1, cnt, sum);
				if (dwarf[0] > 0) {
					return;
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(input));

		for (int i = 0; i < 9; i++) {
			height[i] = Integer.parseInt(in.readLine());
		}

		findDwarf(0, 0, 0);
		for (int i = 0; i < 7; i++) {
			System.out.println(dwarf[i]);
		}
	}

}
