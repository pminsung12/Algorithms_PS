import java.io.*;
import java.util.*;

public class Main {

	static int N, M, sum, low, high, res = 100001;
	static int[] input;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		input = new int[N + 1];

		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		input[N] = 0;
		sum = input[0];
		low = 0;
		high = 0;
		while (high <= N - 1 && low <= N - 1) {
			if (sum < M) {
				high++;
				sum += input[high];
			} else if (sum >= M) {
				res = Math.min(res, high - low + 1);
				sum -= input[low];
				low++;
			}
		}
		if (res == 100001) {
			System.out.println(0);
			return;
		}
		System.out.println(res);

	}

}
