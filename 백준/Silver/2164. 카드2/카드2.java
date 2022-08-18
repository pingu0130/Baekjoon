import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = N;
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i < N + 1; i++) {
			queue.add(i);
		}
		while (cnt != 1) { // 1장만 남을때까지
			queue.remove(); // 맨 첫장 제거
			int lastnum = queue.poll(); // 그 다음장 반환하고 제거
			queue.add(lastnum); // 다시 맨 밑으로 추가
			cnt--;
		}
		System.out.println(queue.peek()); // 첫번째값출력
	}
}
