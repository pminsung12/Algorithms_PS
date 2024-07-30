import java.util.*;

public class Main {
	static int L, C;
	static char[] data;
	static List<String> result;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		L = sc.nextInt();
		C = sc.nextInt();

		data = new char[C];
		sb= new StringBuilder();
		result = new ArrayList<>();

		for (int i = 0; i < C; i++) {
			data[i] = sc.next().charAt(0);
		}

		Arrays.sort(data);

		dfs(-1, 0, 0);

		for (String s : result) {
			System.out.println(s);
		}

	}

	static void dfs(int current, int con, int vow) {
		// 1. 체크인: 현재까지 만들어진 암호
		if (current >= 0) {
			sb.append(data[current]);
		}

		// 2. 목적지인가: length == L, 자음, 모음 조건 -> 암호출력
		if (sb.length() == L) {
			if (con >= 2 && vow >= 1) {
				result.add(sb.toString());
			}
		} else {
			// 3. 연결된 곳을 순회: current+1 ~ C
			for (int i = current + 1; i < C; i++) {
				// 4. 갈 수 있는가?(생략-> 목적지에서 정의)
				// 5. 간다: 자음, 모음
				if (isVow(data[i]))
					dfs(i, con, vow + 1);
				else
					dfs(i, con + 1, vow);
			}

		}

		// 6. 체크아웃: 현재까지 만들어진 암호
		if (current >= 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	static boolean isVow(char c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
			return true;
		return false;
	}

}
