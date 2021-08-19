package com.ssafy.algo.BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class P17478 {
	private static String input = "2";// 입력값은 항상 스트링으로 들어옴
	private final static String ask = "\"재귀함수가 뭔가요?\"\n";// static 안하면 recul r=new recul; r.ask이런 식으로 사용해야해서
	private final static String answer1 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
	private final static String answer2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
	private final static String answer3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
	private final static String lastanswer = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
	private final static String end = "라고 답변하였지.\n";

	public static void reculsive(int cnt, int temp) {
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		for (int j = 0; j <= temp; j++) {
			sb2.append("____");
		}
		sb.append(sb2).append(ask);

		if (cnt == 1) {
			sb.append(sb2).append(lastanswer);
			sb.append(sb2).append(end);
			System.out.print(sb);
			return;
		}

		sb.append(sb2).append(answer1);
		sb.append(sb2).append(answer2);
		sb.append(sb2).append(answer3);
		System.out.print(sb.toString());
		reculsive(cnt - 1, temp + 1);//
		// sb.append(sb2).append(end);
		System.out.print(sb2.toString() + end);

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));// 입력받기로 선언. 내가테스트 해볼때
		in = new BufferedReader(new StringReader(input));// 입력받기 안하고 불러올꺼다 . 이미 주어진 값으로 테스트 해볼때

		int cnt = Integer.parseInt(in.readLine());// ctrl+1 -> 첫번째 엔터: throws 익셉션
		// string을 계속 변경 출력할 경우 계속 메모리가 생성되서 stringBuilder를 사용.이거 사용하면 메모리 추가 사용하지 않음
		StringBuilder sb = new StringBuilder();
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n").append(ask).append(answer1).append(answer2).append(answer3);
		System.out.print(sb.toString());
		reculsive(cnt, 0);
		// sb.append(end);

		System.out.println(end);
	}
}
