import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			int a = 1;
			int b = 1;
			String s = br.readLine();
			for (int i = 0; i < s.length(); i++) {
				char node = s.charAt(i);
				switch (node) {
				case 'L':
					b = a + b;
					break;

				case 'R':
					a = a + b;
					break;

				}
			}
			sb.append(a + " " + b);
			System.out.println(sb);
            sb.setLength(0);
		} // 테케
	}
}