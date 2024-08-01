import java.io.*;
import java.util.*;

public class Main {

	static int N, S;
	static int[] tree;
	static int MAX=1000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		S = 1;
		while (S < MAX) {
			S *= 2;
		}

		tree = new int[S * 2];
		init();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a==2) {
				int c = Integer.parseInt(st.nextToken());
				update(1, S, 1, b, c);
				continue;
			}

			// 조회
			int flavorLevel = queryFind(1,S,1,b);
			// 삭제
			update(1, S, 1, flavorLevel, -1);
			
			System.out.println(flavorLevel);
			
		}

	}

	

	static void init() {
		// 여기서는 0으로 초기화
		for(int i=0; i<S*2; i++) {
			tree[i]=0;
		}

	}

	static int queryFind(int left, int right, int node, int target) {
		// target은 개수
		// left, right은 flavor
		// 리프까지 가면 찾은거임(입력에 대한 검증 필요없는 문제기 때문에)
		if(left==right) {
			return left;
		}
		
		// 루트노드부터 개수를 본다.
		// 왼쪽 자식의 개수가 target 보다 크거나 작다면 왼쪽으로 이동
		int mid = (left+right)/2;
		if(tree[node*2]>=target) {
			return queryFind(left, mid, node*2, target);
		} else {
			// 반대 경우는 오른쪽으로 이동(근데 오른쪽으로 이동할 때 왼쪽 자식의 개수만큼 target을 빼준다.)
			return  queryFind(mid+1, right, node*2+1, target-tree[node*2]);
		}
		
		
		
		
		
	}

	static void update(int left, int right, int node, int target, int diff) {
		// target은 개수
		// left, right은 flavor
		// target쪽으로 이동하면서 루트부터 개수를 diff 만큼 빼준다. target에 도착할 때까지!
		if (target < left || target > right) {
			return;
		}

		tree[node] += diff;
		if (left != right) { // 리프 노드가 아닐 때
			int mid = (left + right) / 2;
			update(left, mid, node * 2, target, diff);
			update(mid + 1, right, node * 2 + 1, target, diff);
		}
	}

}
