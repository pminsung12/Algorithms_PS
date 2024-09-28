import java.util.*;
import java.io.*;

class Main {
  
  static int N, M, from, to;
  static int[] indegree;
  static StringBuilder sb;
  static List<Integer>[] adjList;
  static Queue<Integer> q;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    sb = new StringBuilder();

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    adjList = new ArrayList[N+1];
    indegree = new int[N+1];
    q = new LinkedList<>();

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

    for(int n=1; n<=N; n++){
      if(indegree[n]==0){
        q.offer(n);
      }
    }
    topologySort();
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }

  static void topologySort(){
    while(!q.isEmpty()){
      int cur = q.poll();
      sb.append(cur+" ");

      for(int next: adjList[cur]){
        indegree[next]--;
        if(indegree[next]==0){
          q.offer(next);
        }
      }
    }
  }
}