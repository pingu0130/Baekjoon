import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();

		char[] arr = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			stack.push(arr[i]); // 입력받다가
			if (stack.peek() == ' ') { // 공백이 나오면
				stack.pop(); // 앞의 공백 버리고
				while (!stack.isEmpty()) { // 스택 다꺼내
					System.out.print(stack.pop());
				}
				System.out.print(" "); // 공백을 뒤로넣어줘
			} else if (stack.peek() == '<') { // 입력받다가 괄호만나면
				stack.pop(); // <제거
				while (!stack.isEmpty()) { // 스택 다꺼내
					System.out.print(stack.pop());
				}
				while (arr[i] != '>') { // 닫을때까지
					System.out.print(arr[i]); // 내용물출력
					i++;
				}
				System.out.print(arr[i]); // >출력
			}
		} // for
		while (!stack.isEmpty()) { // 스택 다꺼내
			System.out.print(stack.pop());// 포문을 다 돌면 남은 스택 출력
		}
		sc.close();
	}
}
