import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		s = s.replace("c=", "1");
		s = s.replace("c-", "2");
		s = s.replace("dz=", "3");
		s = s.replace("d-", "4");
		s = s.replace("lj", "5");
		s = s.replace("nj", "6");
		s = s.replace("s=", "7");
		s = s.replace("z=", "8");
		List<Character> list = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			list.add(s.charAt(i));
		}
		System.out.println(list.size());
	}
}
