package com.ssafy.algo.JO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1828 {

	private static String input = "5\n3 5\r\n" + "12 37\r\n" + "16 23\r\n" + "140 143\r\n" + "437 522\n";

	static class Temparature implements Comparable<Temparature> {
		int start, end;

		Temparature(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Temparature o) {
			int value = this.end - o.end;
			if (value != 0)
				return value;

			return this.start - o.start;
		}

	}

	public static int RefrigeNum(Temparature tem[]) {
		int num = 1;
		Arrays.sort(tem);
		int temp = tem[0].end;

//		for (int i = 0; i < tem.length; i++) {
//			System.out.println(tem[i].start + ", " + tem[i].end);
//		}

//		for (int i = 1; i < tem.length; i++) {
//			if (startnum <= tem[i].start || startnum < tem[i].end && endnum > tem[i].start) {
//				startnum = tem[i].start;
//				continue;
//			}
//			num++;
//			startnum = tem[i].start;
//			endnum = tem[i].end;
//		}

		for (int i = 1; i < tem.length; i++) {
			if (tem[i].start > temp) {
				num++;
				temp = tem[i].end;
			}

		}
		return num;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(input));

		int N = Integer.parseInt(in.readLine());
		// temparature = new int[N][2];
		Temparature tem[] = new Temparature[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			tem[i] = new Temparature(s, e);
		}

		System.out.println(RefrigeNum(tem));

	}

//	private static int N;
//
//	static class Chemical implements Comparable<Chemical> {
//		int start, end;
//
//		public Chemical(int start, int end) {
//			super();
//			this.start = start;
//			this.end = end;
//		}
//
//		@Override
//		public int compareTo(Chemical o) {
//
//			int value = this.end - o.end;
//			if (value != 0)
//				return value;
//
//			return this.start - o.start;
//		}
//	}
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		// TODO Auto-generated method stub
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(input));
//		N = Integer.parseInt(in.readLine());
//
//		Chemical[] chemicals = new Chemical[N];
//		for (int i = 0; i < N; i++) {
//			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
//			int s = Integer.parseInt(st.nextToken());
//			int e = Integer.parseInt(st.nextToken());
//			Chemical C = new Chemical(s, e);
//			chemicals[i] = C;
//		}
//
//		System.out.println(getRefrigNum(chemicals));
//
//	}
//
//	static int getRefrigNum(Chemical[] chemicals) {
//		int cnt = 1;
//		Arrays.sort(chemicals);
//		int temp = chemicals[0].end;
//		for (int i = 1; i < N; i++) {
//			if (chemicals[i].start > temp) {
//				temp = chemicals[i].end;
//				cnt++;
//			}
//
//		}
//		return cnt;
//
//	}

}
