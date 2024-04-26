import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int N, answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
            graph.get(B).add(A);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int kevinBacon = bfs(i);
            if (kevinBacon < min) {
                min = kevinBacon;
                answer = i;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(int start) {
        int[] num = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int x = q.poll();
            for (int i : graph.get(x)) {
                if (!visited[i]) {
                    num[i] = num[x] + 1;
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }

        return Arrays.stream(num, 1, N + 1).sum();
    }
}