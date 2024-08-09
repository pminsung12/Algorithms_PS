import java.io.*;
import java.util.*;

public class Main {

	static class App {
		int memory;
		int cost;

		@Override
		public String toString() {
			return "App [memory=" + memory + ", cost=" + cost + "]";
		}
	}

	static int N, K;
	static App[] apps;
	static int[][] dp;
	static int MAX_COST = 100 * 100;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		apps = new App[N + 1];
		dp = new int[N + 1][MAX_COST + 1];

		for (int i = 0; i <= N; i++) {
			apps[i] = new App();
			Arrays.fill(dp[i], 0);
		}

		int m, c;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			m = Integer.parseInt(st.nextToken());
			apps[i].memory = m;
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			c = Integer.parseInt(st.nextToken());
			apps[i].cost = c;
		}
//		System.out.println(Arrays.deepToString(apps));

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= MAX_COST; j++) {
				if (j >= apps[i].cost) {
					// i번째 app까지 실행시켰을 때 j 비용에서 드는 메모리의 최대값
					dp[i][j] = Math.max(dp[i - 1][j], apps[i].memory + dp[i - 1][j - apps[i].cost]);
					continue;
				}
				dp[i][j] = dp[i - 1][j];
			}
		}

		for (int j = 0; j <= MAX_COST; j++) {
			if (dp[N][j] >= K) {
				System.out.println(j);
				break;
			}
		}

	}

}
