import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String s = br.readLine();
			char[] arr = s.toCharArray();
			char[] tmp = arr.clone(); // 클론배열
			int idx = 0;
			int ans = 0;
			boolean flag = false;
			for (int i = 1; i < arr.length - 1; i++) {
				if (tmp[idx] == arr[i]) { // 같은 글자 찾기
					for (int j = idx; j < i; j++) {
						if (tmp[j] == arr[j + i]) { // 다음 글자가 같은지
							flag = true;
						} else {
							flag = false;
						}
					}
					if (flag == true) {
						ans = i;
						break;
					}
				}

			}
			System.out.printf("#%d %d\n", tc, ans);
		} // 테케
		br.close();
	}
}
