import java.util.*;
import java.io.*;

class Main {
  
  static int N, M, from, to;
  static int[] indegree;
  static StringBuilder sb;
  static List<Integer>[] adjList;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    sb = new StringBuilder();

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    adjList = new ArrayList[N+1];
    indegree = new int[N+1];

    for(int n=1; n<=N; n++){
      adjList[n]=new ArrayList<>();
    }

    for(int m=0; m<M; m++){
      st = new StringTokenizer(br.readLine());
      from = Integer.parseInt(st.nextToken());
      to = Integer.parseInt(st.nextToken());
      indegree[to]++;
      adjList[from].add(to);
    }
    
    topologySort();
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }

  static void topologySort(){
    ArrayDeque<Integer> q = new ArrayDeque<>();

    // 시작점:차수가 0인 노드 queue에 넣기
    for(int n=1; n<=N; n++){
      if(indegree[n]==0){
        q.offer(n);
      }
    }

    while(!q.isEmpty()){
      int cur = q.poll();
      sb.append(cur+" ");

      for(int next: adjList[cur]){
        // cur -> next 차수 줄이기
        indegree[next]--;
        // 다음 시작점:차수가 0인 노드 queue에 넣기
        if(indegree[next]==0){
          q.offer(next);
        }
      }
    }
  }
}