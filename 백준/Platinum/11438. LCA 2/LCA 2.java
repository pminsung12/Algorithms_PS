import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static List<Integer>[] adjList;
	static boolean[] visited;
	static int[] depth;
	static int[][] parent;

	// 2^15 = 32768
	// 2^16 = 65536
	// 2^17 = 131072
	// 최대 노드(N) 수 보다 큰 가장 작은 2^n 값을 선택하면 된다.
	// c.f. 2^15 < N=50000 < 2^16
	// c.f. 2^16 < N=100000 < 2^17
	static final int LOG = 17;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		// 인접 리스트 초기화
		adjList = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		depth = new int[N + 1];
		parent = new int[LOG + 1][N + 1];

		for (int n = 1; n < N + 1; n++) {
			adjList[n] = new ArrayList<>();
		}

		for (int n = 0; n < N-1; n++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			// 양방향 처리
			adjList[from].add(to);
			adjList[to].add(from);
		}

		// bfs -> parent[0][v]과 depth 배열 채우기
		bfs(1);

		// 점화식으로 parent 배열 다 채우기
		findAncestors();
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			System.out.println(lca(from, to));
		}
	}

	static void bfs(int root) {
		ArrayDeque<Integer> q = new ArrayDeque<>();

		q.add(root);
		depth[root] = 0;
		visited[root] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int next : adjList[cur]) {
				if (!visited[next]) {
					visited[next] = true;
					parent[0][next] = cur;
					depth[next] = depth[cur] + 1;
					q.add(next);
				}
			}
		}
	}

	static void findAncestors() {
		for(int k=1; k<LOG+1; k++) {
			for(int v=1; v<N+1; v++) {
				parent[k][v]=parent[k-1][parent[k-1][v]];
			}
		}
	}

	static int lca(int a, int b) {
		// 항상 b가 depth가 더 큰 상태로 고정하기
		if (depth[a] > depth[b]) {
			int tmp = b;
			b = a;
			a = tmp;
		}
		
		 // 1. a, b의 depth 맞추기(0.에 의해 항상 b를 끌어올리게 된다)
        for(int k=LOG; k>=0; k--){
            // (1 << k) : 2^k
            // IF [(depth 차이) >= 2^16 ... 2^0] -> b 끌어올림
            // for loop의 마지막 수행 시 (depth 차이 = 1) > b = parent[0][b] 로 1 depth 끌어올려지므로 a, b의 depth가 동일해진다
            if(depth[b]-depth[a] >= (1 << k)){
                b = parent[k][b];
            }
        }
        
        // 만약 depth를 맞추었는데 같다면 찾은 것.
        if(a==b) return a;
		
        // 3. a와 b를 같이 끌어올리면서 처음으로 조상이 같지 않은 지점(parent[0][a] != parent[0][b]) 까지 이동
        // a와 b의 조상이 같으면 k--
        // a와 b의 조상이 같지 않으면 a와 b를 2^k 만큼 끌어올림
        for(int k=LOG; k>=0; k--) {
        	if(parent[k][a]!=parent[k][b]) {
        		a=parent[k][a];
        		b=parent[k][b];
        	}
        }
        
        // 4. 3.이 2^0=1 에서 끝났으므로 a, b의 바로 위 조상이 lca가 된다
        return parent[0][a];
	}

}
