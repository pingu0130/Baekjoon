import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc < T + 1; tc++) {
			System.out.print("#" + tc + " ");
			int H = sc.nextInt();
			int W = sc.nextInt();
			char[][] arr = new char[H][W]; // 필드
			for (int i = 0; i < H; i++) {
				String s = sc.next();
				for (int j = 0; j < W; j++) {
					arr[i][j] = s.charAt(j);
				}
			}
			int N = sc.nextInt(); // 입력개수
			sc.nextLine();
			String com = sc.next();
			char[] comarr = com.toCharArray(); // 명령배열

			int x = 0;
			int y = 0;
			int d = 0;
			loop: for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (arr[i][j] == '>') { // 시작점찾기
						x = i;
						y = j;
						d = 1; // 방향
						break loop;
					} else if (arr[i][j] == '<') {
						x = i;
						y = j;
						d = 2;
						break loop;
					} else if (arr[i][j] == 'v') {
						x = i;
						y = j;
						d = 3;
						break loop;
					} else if (arr[i][j] == '^') {
						x = i;
						y = j;
						d = 4;
						break loop;
					}

				}
			} // 시작
			for (int c = 0; c < comarr.length; c++) {// 명령순회
				if (comarr[c] == 'S') {
					if (d == 1) { // 동쪽이면
						int cnt = 1;
						while (y + cnt < W) {
							if (arr[x][y + cnt] == '*') { // 벽돌만나면
								arr[x][y + cnt] = '.'; // 평지로바꿔
								break;// 포탄소멸
							} else if (arr[x][y + cnt] == '#') { // 강철만나면 끝남
								break;
							}
							cnt++;
						}
					}
					if (d == 2) { // 서쪽이면
						int cnt = 1;
						while (y - cnt >= 0) {
							if (arr[x][y - cnt] == '*') {
								arr[x][y - cnt] = '.';
								break;
							} else if (arr[x][y - cnt] == '#') {
								break;
							}
							cnt++;
						}
					}
					if (d == 3) {
						int cnt = 1;
						while (x + cnt < H) {
							if (arr[x + cnt][y] == '*') {
								arr[x + cnt][y] = '.';
								break;
							} else if (arr[x + cnt][y] == '#') {
								break;
							}
							cnt++;
						}
					}
					if (d == 4) {
						int cnt = 1;
						while (x - cnt >= 0) {
							if (arr[x - cnt][y] == '*') {
								arr[x - cnt][y] = '.';
								break;
							} else if (arr[x - cnt][y] == '#') {
								break;
							}
							cnt++;
						}
					}
				} else if (comarr[c] == 'U') {
					d = 4; // 방향 바꾸고
					arr[x][y] = '^'; // 일단 제자리에서 돌고
					if (x - 1 >= 0 && arr[x - 1][y] == '.') { // 한칸위가 평지면
						arr[x][y] = '.'; // 땅으로 바꾸고
						x -= 1; // 이동
						arr[x][y] = '^'; // 옮긴자리 바꾸고
					}
				} else if (comarr[c] == 'D') {
					d = 3;
					arr[x][y] = 'v';
					if (x + 1 < H && arr[x + 1][y] == '.') {
						arr[x][y] = '.';
						x += 1;
						arr[x][y] = 'v';
					}
				} else if (comarr[c] == 'L') {
					d = 2;
					arr[x][y] = '<';
					if (y - 1 >= 0 && arr[x][y - 1] == '.') {
						arr[x][y] = '.';
						y -= 1; // 이동
						arr[x][y] = '<';
					}
				} else if (comarr[c] == 'R') {
					d = 1; // 방향 바꾸고
					arr[x][y] = '>';
					if (y + 1 < W && arr[x][y + 1] == '.') {
						arr[x][y] = '.';
						y += 1; // 이동
						arr[x][y] = '>';
					}
				}

			} // 명령
				// 필드출력
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
		} // 테케
		sc.close();
	}
}
