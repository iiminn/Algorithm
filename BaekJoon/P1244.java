package com.ssafy.algo.BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class P1244 {
	private static String input = "8\n" + "0 1 1 0 0 1 0 0\n" + "2\n" + "2 2\n" + "2 6\n";
	private static int lights[];
	private static int studentCnt;
	private static int stuSwitch[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(input));

		int cnt = Integer.parseInt(in.readLine());
		lights = new int[cnt];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < cnt; i++) {
			lights[i] = Integer.parseInt(st.nextToken());
		}

		studentCnt = Integer.parseInt(in.readLine());
		stuSwitch = new int[studentCnt][2];
		for (int i = 0; i < studentCnt; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 2; j++) {
				stuSwitch[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < studentCnt; i++) {
			if (stuSwitch[i][0] == 1) {
				for (int t = 0; t < lights.length; t++) {
					if ((t + 1) % stuSwitch[i][1] == 0) {
						if (lights[t] == 0) {
							lights[t] = 1;
						} else if (lights[t] == 1) {
							lights[t] = 0;
						}
					}
				}
			} else if (stuSwitch[i][0] == 2) {
				int temp = 0;
				if (lights[stuSwitch[i][1] - 1] == 0) {
					lights[stuSwitch[i][1] - 1] = 1;
				} else {
					lights[stuSwitch[i][1] - 1] = 0;
				}

				for (int s = stuSwitch[i][1] - 1, f = stuSwitch[i][1] + 1; s > 0 && f <= lights.length; s--, f++) {
					// System.out.println();
					if (lights[s - 1] == lights[f - 1]) {
						temp++;
						continue;
					} else
						break;
				}
				for (int c = 1; c <= temp; c++) {
					if (lights[stuSwitch[i][1] - 1 - c] == 0) {
						lights[stuSwitch[i][1] - 1 - c] = 1;
						lights[stuSwitch[i][1] - 1 + c] = 1;
					} else {
						lights[stuSwitch[i][1] - 1 - c] = 0;
						lights[stuSwitch[i][1] - 1 + c] = 0;
					}

				}

			}

			// }
		}
		for (int i = 0; i < lights.length; i++) {

			System.out.print(lights[i]);
			if (i == lights.length - 1) {
				break;
			} else if ((i + 1) % 20 == 0) {
				System.out.println();
				continue;
			}
			System.out.print(" ");
		}

	}

}
