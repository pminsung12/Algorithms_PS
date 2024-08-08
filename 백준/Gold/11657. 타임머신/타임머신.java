import java.util.*;
import java.io.*;

public class Main {
	static class Edge {
		int from;
		int to;
		int cost;

		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}

	static int V, E, S, D;
	static ArrayList<Edge> adjList;
	static long[] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		adjList = new ArrayList<>();
		dist = new long[V + 1];

		int A, B, C;
		for (int m = 0; m < E; m++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			adjList.add(new Edge(A, B, C));
		}

		boolean isMinusCycle = bellmanFordMoore(1);
		if (isMinusCycle) {
			sb.append("-1\n");

		} else {
			for (int i = 2; i < V + 1; i++) {
				sb.append(dist[i] == Long.MAX_VALUE ? "-1" : dist[i]).append("\n");
			}
		}
		System.out.println(sb.toString());

	}

	// true인 경우 음의 사이클 발생
	// O(V*E) -> 500 * 6000 * -10000 -> dist 배열 long 타입 변환 필요
	static boolean bellmanFordMoore(int start) {
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[start] = 0;

		// V-1번 E개의 모든 간선 확인
		for (int i = 0; i < V - 1; i++) {
			for (Edge edge : adjList) {
				// 간선의 시작점이 아직 탐색 불가면 continue
				if (dist[edge.from] == Long.MAX_VALUE) {
					continue;
				}

				// 최단거리 갱신
				if (dist[edge.to] > dist[edge.from] + edge.cost) {
					dist[edge.to] = dist[edge.from] + edge.cost;
				}
			}
		}
		boolean isMinusCycle = false;
		// V번째 E개의 모든 간선을 확인해서 갱신되는 구간이 있으면 음의 사이클 존재
		for (Edge edge : adjList) {
			if (dist[edge.from] == Long.MAX_VALUE) {
				continue;
			}

			// 최단거리 갱신
			if (dist[edge.to] > dist[edge.from] + edge.cost) {
				isMinusCycle = true;
				break;
			}
		}

		return isMinusCycle;
	}

}
