import java.io.*;
import java.util.*;

public class Main {

	static int N, cnt;
	static StringTokenizer st;

	static int[] indegree;
	static int[] preBuildTime;
	static int[] buildTime;
	static List<List<Integer>> adjLst;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		indegree = new int[N + 1];
		preBuildTime = new int[N + 1];
		buildTime = new int[N + 1];

		adjLst = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			adjLst.add(new ArrayList<>());
		}

		for (int to = 1; to <= N; to++) {
			st = new StringTokenizer(br.readLine());
			buildTime[to] = Integer.parseInt(st.nextToken());

			while (true) {
				int from = Integer.parseInt(st.nextToken());

				if (from == -1)
					break;

				indegree[to]++;
				adjLst.get(from).add(to);
			}
		}

		topologySort();
		
        // print result
        for(int i=1; i<=N; i++){
            System.out.println(buildTime[i]);
        }

	}

	static void topologySort() {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();

        // 시작점:차수가 0인 노드 queue에 넣기
		for (int i = 1; i < N + 1; i++) {
			int maxTime = 0;
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int node = q.poll();
//			sb.append(n + " ");

			for (Integer to : adjLst.get(node)) {
				indegree[to] -= 1;

				// to 정점으로 오는 시작정점의 buildTime 중 max 깞이 to 정점의 preBuildTime
				preBuildTime[to] = Math.max(preBuildTime[to], buildTime[node]);

				// 다음 시작점: 차수가 0인 노드 queue에 넣기
				if (indegree[to] == 0) {
					buildTime[to] += preBuildTime[to];
					q.offer(to);
				}
			}
		}
//		System.out.println(sb.toString());
	}
}
