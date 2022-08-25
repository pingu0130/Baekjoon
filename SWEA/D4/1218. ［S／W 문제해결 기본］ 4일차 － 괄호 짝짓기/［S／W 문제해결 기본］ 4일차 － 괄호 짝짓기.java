import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			String s = sc.next(); // 왜 nextline은 안되나요
			char[] arr = s.toCharArray();

			Stack<Character> stack = new Stack<>();
			Stack<Character> tmp = new Stack<>();
			loop: for (int i = 0; i < N; i++) {
				stack.add(arr[i]);
				if (stack.peek() == ')') { // 괄호나오면
					stack.pop(); // 제거해주고
					while (stack.peek() != '(') { // 반대쪽찾기.. 찾을 수 없을수도 있구나..
						char a = stack.pop();
						tmp.add(a); // 받아주고
						if (stack.isEmpty()) { // 스택을 다 뒤졌는데 얘 짝꿍이없어..
							stack.add(tmp.peek()); // ans를 지키기 위해 아무거나 추가해
							break loop;
						}
					}
					stack.pop(); // 괄호제거
					while (!tmp.isEmpty()) { // 다시 스택에 옮겨
						stack.add(tmp.pop());
					}

				} else if (stack.peek() == ']') {
					stack.pop();
					while (stack.peek() != '[') {
						char a = stack.pop();
						tmp.add(a);
						if (stack.isEmpty()) {
							stack.add(tmp.peek());
							break loop;
						}
					}
					stack.pop();
					while (!tmp.isEmpty()) {
						stack.add(tmp.pop());
					}

				} else if (stack.peek() == '}') {
					stack.pop();
					while (stack.peek() != '{') {
						char a = stack.pop();
						tmp.add(a);
						if (stack.isEmpty()) {
							stack.add(tmp.peek());
							break loop;
						}
					}
					stack.pop();
					while (!tmp.isEmpty()) {
						stack.add(tmp.pop());
					}

				} else if (stack.peek() == '>') {
					stack.pop();
					while (stack.peek() != '<') {
						char a = stack.pop();
						tmp.add(a);
						if (stack.isEmpty()) {
							stack.add(tmp.peek());
							break loop;
						}
					}
					stack.pop();
					while (!tmp.isEmpty()) {
						stack.add(tmp.pop());
					}

				}

			}
			int ans = 0;
			if (stack.isEmpty()) {
				ans = 1;
			}
			System.out.printf("#%d %d\n", tc, ans);
		} // 테케
		sc.close();
	}
}
