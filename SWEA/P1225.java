import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 1225 {
	private static String input = "1\r\n" + "9550 9556 9550 9553 9558 9551 9551 9551 \r\n" + "2\r\n"
			+ "2419 2418 2423 2415 2422 2419 2420 2415 \r\n" + "3\r\n" + "7834 7840 7840 7835 7841 7835 7835 7838 \r\n"
			+ "4\r\n" + "4088 4087 4090 4089 4093 4085 4090 4084 \r\n" + "5\r\n"
			+ "2945 2946 2950 2948 2942 2943 2948 2947 \r\n" + "6\r\n" + "670 667 669 671 670 670 668 671 \r\n"
			+ "7\r\n" + "8869 8869 8873 8875 8870 8872 8871 8873 \r\n" + "8\r\n"
			+ "1709 1707 1712 1712 1714 1710 1706 1712 \r\n" + "9\r\n"
			+ "10239 10248 10242 10240 10242 10242 10245 10235 \r\n" + "10\r\n"
			+ "6580 6579 6574 6580 6583 6580 6577 6581\n";

	private static List<Integer> arr;

	public static void MakePassword() {
		int cycle = 1;
		while (!arr.contains(0)) {
			int temp = arr.get(0) - cycle;
			if (temp <= 0) {
				temp = 0;
			}
			arr.remove(0);
			arr.add(temp);
			if (cycle == 5) {
				cycle = 1;
				continue;
			}
			cycle++;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(input));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(in.readLine());
			sb.append("#").append(tc).append(" ");
			arr = new ArrayList<Integer>();
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < 8; i++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			MakePassword();
			for (int i = 0; i < 8; i++) {
				sb.append(arr.get(i)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
