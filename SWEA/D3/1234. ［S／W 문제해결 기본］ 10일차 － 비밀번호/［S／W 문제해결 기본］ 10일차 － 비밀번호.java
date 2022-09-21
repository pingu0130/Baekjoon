import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc < 11; tc++) {
			sb.append("#" + tc + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < s.length(); i++) {
				stack.push(s.charAt(i));
			}
			Stack<Character> tmp = new Stack<>();
			// 스택검사: 두개를 검사해 같으면 지우고 다르면 tmp에 저장한다.
			while (!stack.isEmpty()) {
				char c = stack.pop();
				if (stack.isEmpty()) {
					tmp.push(c);
					break;
				}
				if (stack.peek() == c) {
					stack.pop();
					// 번호쌍이 등장하면 tmp배열에서 쌍을 찾는다
					int len = tmp.size();
					for (int i = 0; i < len && !stack.isEmpty() && !tmp.isEmpty(); i++) {
						if (stack.peek() == tmp.peek()) {
							stack.pop();
							tmp.pop();
						} else {
							break;
						}
					}
				} else {
					tmp.push(c);
				}
			}
			while (!tmp.isEmpty()) {
				sb.append(tmp.pop());
			}
			System.out.printf(sb + "\n");
			sb.setLength(0);
		}
	}
}