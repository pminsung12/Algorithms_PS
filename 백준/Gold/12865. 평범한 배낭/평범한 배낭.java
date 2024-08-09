import java.io.*;
import java.util.*;

public class Main {

	static class Item {
		int weight;
		int value;

		public Item(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Item [weight=" + weight + ", value=" + value + "]";
		}

	}

	static int N, K;
	static Item[] items;
	static int[][] dp;
	static int MAX_WEIGHT = 100000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		items = new Item[N+1];
		dp=new int[N+1][K+1];
		
		for(int d[]: dp) {
			Arrays.fill(d, 0);
		}
		
		int w, v;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			items[i] = new Item(w, v);
//			System.out.println(items[i].toString());
		}
		
		for(int i=1; i<=N;i++) {
			for(int j=1; j<=K; j++) {
				if(j>=items[i].weight) {
					dp[i][j] = Math.max(dp[i-1][j], items[i].value+dp[i-1][j-items[i].weight]);
					continue;
				}
				
				// 현재 물건을 담을 수 없는 무게일 때는 이전 무게 그대로 내려오기
				dp[i][j]=dp[i-1][j];
			}
		}
//		System.out.println(Arrays.deepToString(dp));
		System.out.println(dp[N][K]);
		
	}

}
