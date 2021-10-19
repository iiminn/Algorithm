package com.ssafy.algo.BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1759 {

	private static String input = "3 15\r\n" + "a b c d e f g h i j k l m n o";
	private static char alpahbet[];

	private static char cryps[];
	private static StringBuilder sb = new StringBuilder();

	public static boolean check(int L) {
		boolean flag = false;
		int cnt = 0;
		for (int i = 0; i < L; i++) {
			if (cryps[i] == 'a' || cryps[i] == 'e' || cryps[i] == 'i' || cryps[i] == 'o' || cryps[i] == 'u') {
				flag = true;
				continue;
			}
			cnt++;
		}
		if (flag == true && cnt >= 2)
			return true;
		else
			return false;
	}

	public static void crypto(int start, int cnt, int L, int C) {
		if (cnt == L) {
			if (check(L)) {
				sb.append(cryps).append("\n");
				// return;
			}
			return;
		}

		for (int i = start; i < C; i++) {
			cryps[cnt] = alpahbet[i];
			crypto(i + 1, cnt + 1, L, C);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(input));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());

		alpahbet = new char[C];
		cryps = new char[L];
		for (int i = 0; i < C; i++) {
			alpahbet[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(alpahbet);

		crypto(0, 0, L, C);
		System.out.println(sb.toString());
	}

}
