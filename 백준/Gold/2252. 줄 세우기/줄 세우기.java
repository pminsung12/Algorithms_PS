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
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			indegree[y] += 1;
			adjLst.get(x).add(y);
		}
		
		topologySort();

	}

	static void topologySort() {
		Queue<Integer> q = new LinkedList<>();
//		Queue<Integer> res = new LinkedList<>();

		for (int i = 1; i < N + 1; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int node = q.poll();
			System.out.printf("%d ", node);
//			res.offer(node);

			for (int i : adjLst.get(node)) {
				indegree[i] -= 1;

				if (indegree[i] == 0) {
					q.offer(i);
				}
			}
		}
		
//		printQueue(res);
	}
	
//	static void printQueue(Queue<Integer> q) {
//		while(q.size()>1) {
//			System.out.printf("%d ", q.poll());
//		}
//		System.out.println(q.poll());
//	}

}
