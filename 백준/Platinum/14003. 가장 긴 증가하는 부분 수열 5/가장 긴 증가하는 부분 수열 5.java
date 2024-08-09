import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] input;
	static int[] lis, trace;
	static int lastIdx = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		input = new int[N];
		// 길이만 사용, 여기 저장된 순서는 진짜 lis와 다를 수 있음
		lis = new int[N];
		// trace[i]는 input[i]가 lis에서 사용된 인덱스 저장 
		trace = new int[N];

		int num;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num = Integer.parseInt(st.nextToken());
			input[i] = num;
		}

		// 처음에 lis 0번째 인덱스에 수열 첫번째 값 넣기
		lis[0] = input[0];

		// input 순회하면서 lis 만들기
		for (int i = 1; i < N; i++) {
			// 만약 input 값이 lis 배열의 마지막 값보다 크다면 뒤에 추가
			if (input[i] > lis[lastIdx]) {
				lis[++lastIdx] = input[i];
				trace[i] = lastIdx;
				continue;
			}
			// 작거나 같다면 lowerbound 찾아서 교체
			int idx = lowerbound(input[i]);
			lis[idx] = input[i];
			trace[i] = idx;
		}

//		System.out.println(Arrays.toString(lis));
//		System.out.println(Arrays.toString(trace));

		System.out.println(lastIdx + 1);
		printLsa();
	}

	static int lowerbound(int target) {
		int left = 0;
		int right = lastIdx;
		int mid;
		while (left < right) {
			mid = (left + right) / 2;
			if (target <= lis[mid]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return right;
	}

	// trace를 뒤에서 거슬러 올라가며 stack을 사용해 진짜 lis 출력
	static void printLsa() {
		int traceIdx = lastIdx;
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stk = new Stack<>();
		for (int i = N - 1; i >= 0; i--) {
			if (traceIdx < 0)
				break;
			if (trace[i] == traceIdx) {
				stk.push(input[i]);
				
				traceIdx--;
			}
		}
		while(!stk.isEmpty()) {
			sb.append(stk.pop()).append(" ");
		}
		System.out.println(sb);
	}

}
