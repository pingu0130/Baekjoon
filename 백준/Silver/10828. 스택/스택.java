import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int num = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push":
				int n = Integer.parseInt(st.nextToken());
				stack.push(n);
				break;
			case "top":
				if (stack.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(stack.peek() + "\n");
				}
				break;
			case "size":
				sb.append(stack.size() + "\n");
				break;
			case "pop":
				if (stack.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(stack.pop() + "\n");
				}
				break;
			case "empty":
				if (stack.isEmpty()) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
				break;
			}
		}
		System.out.println(sb);
		sb.setLength(0);
	}
}