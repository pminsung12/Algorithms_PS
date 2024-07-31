import java.io.*;
import java.util.*;

public class Main {

	static int N, M, K;
	static long[] nums;
	static long[] tree;
	static int S;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		nums = new long[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Long.parseLong(br.readLine());
		}
		
		S = 1;
		while (S < N) {
			S *= 2;
		}

		tree = new long[S * 2]; // 원래 노드 개수는 S*2 -1 이지만 우리는 0번을 안써서 하나 더 필요하다.
		init();

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if(a==1) { // update
				update(1, S, 1, b, c-tree[S+b-1]);
			} else { // 구간합
				long res = query(1, S, 1, b, c);
				System.out.println(res); 
			}
		}

		
	}

//	static void init() {
//		// leaf 채우기
//		for (int i = 0; i < N; i++) {
//			tree[S + i] = nums[i];
//		}
//		// 내부 노드 채우기
//		for (int i = S - 1; i > 0; i--) {
//			tree[i] = tree[i * 2] + tree[i * 2 + 1];
//		}
//	}
//
//	static long query(int left, int right, int node, int queryLeft, int queryRight) {
//		if (right < queryLeft || left > queryRight) { // 범위를 벗어났을 때
//			return 0;
//		} else if (queryLeft <= left && queryRight >= right) { // 범위 안에 있을 때
//			return tree[node];
//		} else { // 범위를 포함하는데 left, right가 더 클 때
//			int mid = (left + right) / 2;
//			return query(left, mid, node * 2, queryLeft, queryRight)
//					+ query(mid + 1, right, node * 2 + 1, queryLeft, queryRight);
//		}
//	}
//
//	static void update(int left, int right, int node, int target, long diff) {
//		if (right < target || left > target) { // 범위를 벗어난 경우
//			return;
//		} else {
//			tree[node] += diff;
//			if (left != right) { // 리프 노드가 아니라면
//				int mid = (left + right) / 2;
//				update(left, mid, node * 2, target, diff);
//				update(mid + 1, right, node * 2 + 1, target, diff);
//			}
//		}
//	}

	static void init() {
		// bottom-up 방식
		for (int i = 0; i < N; i++) {
			// leaf 채우기
			tree[S + i] = nums[i];
		}

		for (int i = S - 1; i > 0; i--) {
			tree[i] = tree[i * 2] + tree[i * 2 + 1];
		}
	}

	static long query(int left, int right, int node, long queryLeft, long queryRight) {
		// top-down 방식
		// "그 그림"대로 구간 나누기
		if (queryRight < left || right < queryLeft) { // 완전 벗어난 경우
			return 0;
		} else if (queryLeft <= left && right <= queryRight) { // 걸칠 때, 또는 포함되는 경우
			return tree[node];
		} else {
			int mid = (left + right) / 2;
			return query(left, mid, node * 2, queryLeft, queryRight)
					+ query(mid + 1, right, node * 2 + 1, queryLeft, queryRight);
		}
	}

	static void update(int left, int right, int node, long target, long diff) {
		if (target < left || right < target) { // 완전 벗어난 경우
			return;
		} else {
			tree[node] += diff;
			if (left != right) { // 리프 노드가 아닐 때
				int mid = (left + right) / 2;
				update(left, mid, node * 2, target, diff);
				update(mid + 1, right, node * 2 + 1, target, diff);
			}
		}
	}

	static long queryBU(int queryLeft, int queryRight) {
		// Bottom-Up query
		// 리프 노드부터 시작
		int left = S + queryLeft - 1;
		int right = S + queryRight - 1;
		long sum = 0;
		while (left <= right) {
			if (left % 2 == 1) { // 왼쪽 경계가 오른쪽 자식에 걸렸을 때 써야함!
				sum += tree[left++]; // 왼쪽 경계 +1
			}
			if (right % 2 == 0) { // 오른쪽 경계가 왼쪽 자식에 걸렸을 때 부모걸 쓰는게 아니라 자신을 써야함
				sum += tree[right--];
			}
			// 부모로 올라가기
			left /= 2;
			right /= 2;
		}
		return sum;
	}

	static void updateBU(int target, long value) {
		int node = S + target - 1;
		tree[node] = value;
		node /= 2;
		while (node > 0) { // 루트까지 쭉 올라가서
			tree[node] = tree[node * 2] + tree[node * 2 + 1];
			node /= 2;
		}
	}

}
