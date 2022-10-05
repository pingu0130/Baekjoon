import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double A = sc.nextInt();
		double B = sc.nextInt();
		double V = sc.nextInt();
		// 작동순서: 올라가기A>>올라간 높이가 V인지 확인
		// 아니다>> 밤이옵니다 내려가기B
		// 맞다>> 도착
		// break가 A와 B에 사이에 있기 때문에 총 올라가야 하는 거리는 V-B이다.
		double cnt = Math.ceil((V - B) / (A - B));
		System.out.println(Math.round(cnt));
		sc.close();
	}
}