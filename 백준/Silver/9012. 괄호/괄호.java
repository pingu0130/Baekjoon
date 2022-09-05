import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			Stack<Character> s = new Stack<>();
			String string = br.readLine();
			for (int k = 0; k < string.length(); k++) {
				char c = string.charAt(k);
				if (c == '(') {
					s.push(c);
				} else {
					if (s.isEmpty()) {
						s.push('a');
						break;
					} else {
						s.pop();
					}
				}
			}
			if (s.isEmpty()) { // 두 괄호의 개수가 같으면 짝이 다 맞는다.
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		} // 테케
	}
}
