import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char c = s.charAt(0);
		int num = (byte) c;
		System.out.println(num);
		sc.close();
	}
}