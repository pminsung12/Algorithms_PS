import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static Edge[] edges;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());

		edges = new Edge[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(from, to, cost);
		}
		initUnionFind();
		System.out.printf("%d", kruskal());

	}

	static int kruskal() {
		// 간선을 오름차순 정렬
		Arrays.sort(edges);
		
		// 선택된 edge 개수
		int selectedEdgeCount = 0;
		
		// 최소 비용
		int mst = 0;

		for (int i = 0; i < M; i++) {
			// 서로 다른 set일 때 연결
			if(find(edges[i].from)!=find(edges[i].to)) {
				mst+=edges[i].cost;
				selectedEdgeCount++;
			} 
				
			union(edges[i].from, edges[i].to);

			
			if(selectedEdgeCount==N-1) {
				return mst;
			}
		}

		// 모든 컴퓨터를 연결할 수 없는 경우(이 문제에서는 없어도 됨.)
		return -1;
	}

	static void initUnionFind() {
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}

	static int find(int a) {
		if (parent[a] == a)
			return a;

		return parent[a] = find(parent[a]);
	}

	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot != bRoot)
			parent[aRoot] = bRoot;
	}

}

class Edge implements Comparable<Edge> {
	int from;
	int to;
	int cost;

	public Edge(int from, int to, int cost) {
		super();
		this.from = from;
		this.to = to;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}

}