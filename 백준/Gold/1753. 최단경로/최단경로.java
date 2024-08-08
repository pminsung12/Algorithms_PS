import java.io.*;
import java.util.*;

public class Main {
	static class Edge implements Comparable<Edge> {
		int dest;
		int cost;

		public Edge(int dest, int cost) {
			super();
			this.dest = dest;
			this.cost = cost;
		}

		// asc
		@Override
		public int compareTo(Edge o) {
			// return this.cost-o.cost
			return Integer.compare(this.cost, o.cost);
		}
	}

	static int V, E, K;
	static ArrayList<Edge>[] adjList;
	static int[] dist;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());

		adjList = new ArrayList[V + 1];
		visited = new boolean[V + 1];
		dist = new int[V + 1];

		for (int i = 1; i < V + 1; i++) {
			adjList[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adjList[from].add(new Edge(to, cost));
		}

		dijkstra(K);

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < V + 1; i++) {
			if(i==K) {
				sb.append("0").append("\n");
			} else if (dist[i] == Integer.MAX_VALUE) {
				sb.append("INF").append("\n");
			} else {
				sb.append(dist[i]).append("\n");
			}
		}
		System.out.println(sb);
	}

	static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.offer(new Edge(start, 0));

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			// 이미 방문했으면 다시 방문하지 않는다.
			// 첫번째 방문에서 최단거리가 결정되기 때문
			if (visited[cur.dest]) {
				continue;
			}
			// 방문처리
			visited[cur.dest] = true;

			for (Edge next : adjList[cur.dest]) {
				if (dist[next.dest] > next.cost + cur.cost) {
					dist[next.dest] = next.cost + cur.cost;
					pq.offer(new Edge(next.dest, dist[next.dest]));
				}
			}
		}
	}
}