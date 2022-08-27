import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
			System.out.print("#" + tc + " ");
			String s1 = br.readLine();
			String s2 = br.readLine();
			String s3 = br.readLine();
			String s4 = br.readLine();
			String s5 = br.readLine();
			for (int i = 0; i < 15; i++) {
				if (i < s1.length()) {
					System.out.print(s1.charAt(i));
				}
				if (i < s2.length()) {
					System.out.print(s2.charAt(i));
				}
				if (i < s3.length()) {
					System.out.print(s3.charAt(i));
				}
				if (i < s4.length()) {
					System.out.print(s4.charAt(i));
				}
				if (i < s5.length()) {
					System.out.print(s5.charAt(i));
				}
			}
			System.out.println();

		}
	}
}
