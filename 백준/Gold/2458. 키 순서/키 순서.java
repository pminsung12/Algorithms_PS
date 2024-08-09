import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[][] dist;
	static List<Integer>[] adjList;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 인접 행렬 초기화 -> 500 * 500 최대 2500
		dist = new int[N + 1][N + 1];
		for (int[] d : dist) {
			Arrays.fill(d, 5000);
		}

		int a, b;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			// 인접행렬 간선정보 입력
			// cost는 임의로 1
			dist[a][b] = 1;
		}

		// 플로이드-와샬 알고리즘
		floydWarshall();
		
		// 자신의 키가 몇 번째인지 알 수 있는 학생이 모두 몇 명인지를 출력
		int[] cnt = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (dist[i][j] != 5000 || dist[j][i] != 5000) {
					cnt[i]++;
				}
			}
		}
		
		int res=0;
		for(int i: cnt) {
			// 자신을 제외한 N-1명
			if(i==N-1) {
				res++;
			}
		}
		

		System.out.println(res);
	}

	static void floydWarshall() {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
				}
			}
		}
	}
}
