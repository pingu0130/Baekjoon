import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
			System.out.print("#" + tc + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s1 = st.nextToken();
			String s2 = st.nextToken();
			String ans = "SAME";
			char[] arr1 = s1.toCharArray();
			char[] arr2 = s2.toCharArray();
			if (s1.length() != s2.length()) {// 일단 길이가 같아야함
				ans = "DIFF";
			} else {

				for (int i = 0; i < arr1.length; i++) { // 치환
					if (arr1[i] == 'A' || arr1[i] == 'D' || arr1[i] == 'O' || arr1[i] == 'P' || arr1[i] == 'Q'
							|| arr1[i] == 'R') {
						arr1[i] = '1';
					} else if (arr1[i] == 'B') {
						arr1[i] = '2';
					} else {
						arr1[i] = '0';
					}
				}
				for (int i = 0; i < arr2.length; i++) {
					if (arr2[i] == 'A' || arr2[i] == 'D' || arr2[i] == 'O' || arr2[i] == 'P' || arr2[i] == 'Q'
							|| arr2[i] == 'R') {
						arr2[i] = '1';
					} else if (arr2[i] == 'B') {
						arr2[i] = '2';
					} else {
						arr2[i] = '0';
					}
				}
				// 비교
				for (int i = 0; i < arr2.length; i++) {
					if (arr1[i] != arr2[i]) {
						ans = "DIFF";
						break;
					}
				}
			}
			System.out.print(ans);
			System.out.println();
		} // 테케
	}
}
