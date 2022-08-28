import java.util.Scanner;
import java.util.Stack;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            int sum = 0;
            int k = sc.nextInt();
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < k; j++) {
                int num = sc.nextInt();
                if (num == 0) {
                    sum -= stack.pop(); // 0이면 top꺼내기
                } else {
                    sum += stack.push(num); // 아니면 저장
                }
            }
            System.out.printf("%d\n", sum);
        sc.close();
    }
}