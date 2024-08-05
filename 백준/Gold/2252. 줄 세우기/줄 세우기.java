import java.io.*;
import java.util.*;

public class Main {

	static int N, M, cnt;
	static StringTokenizer st;

	static int[] indegree;
	static List<List<Integer>> adjLst;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		indegree = new int[N + 1];
		adjLst = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			adjLst.add(new ArrayList<>());
		}

		for (int m = 1; m <= M; m++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			indegree[to] += 1;
			adjLst.get(from).add(to);
		}
		
		topologySort();

	}

	static void topologySort() {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
//		Queue<Integer> res = new LinkedList<>();

		for (int i = 1; i < N + 1; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int node = q.poll();
			sb.append(node+" ");

			for (Integer to : adjLst.get(node)) {
				indegree[to] -= 1;

				if (indegree[to] == 0) {
					q.offer(to);
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}
