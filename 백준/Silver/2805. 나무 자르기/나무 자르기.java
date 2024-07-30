import java.io.*;
import java.util.*;

public class Main {

	static int[] input;
	static int N, M, start = 0, mid, end = 0, res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		input = new int[N + 1];

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			input[i] = num;
			end = Math.max(end, num);
		}

		while (start <= end) {
			mid = (start + end) / 2;
			Long sum = calculateSum(mid);
			if (sum > M) {
				start = mid + 1;
				res = mid;
			} else if (sum == M) {
				res = mid;
				break;
			} else { // sum < M
				end = mid - 1;
			}
		}

		System.out.println(res);

	}
	
	static Long calculateSum(int height) {
		Long sum=0L;
		for(int i: input) {
			if(i-height>0) sum+=(i-height);
		}
		
		return sum;
	}

}
