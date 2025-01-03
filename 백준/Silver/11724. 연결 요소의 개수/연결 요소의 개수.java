import java.io.*;
import java.util.*;

class Main{

  static int N,M;
  static int[] input;
  static List<Integer>[] adjList;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    adjList = new ArrayList[N+1];
    visited = new boolean[N+1];
    for(int n=0; n<=N; n++){
      adjList[n]=new ArrayList<>();
    }

    int u,v;
    for(int m=0; m<M; m++){
      st = new StringTokenizer(br.readLine());
      u = Integer.parseInt(st.nextToken());
      v = Integer.parseInt(st.nextToken());  
      adjList[u].add(v);
      adjList[v].add(u);
    }

    int answer=0;
    for(int n=1; n<=N; n++){
      if(!visited[n]){
        dfs(n);
        answer++;
      }
    }
    
    System.out.println(answer);
  }

  static void dfs(int start){
    visited[start]=true;
    
    for(int next: adjList[start]){
      if(!visited[next]){
        dfs(next);
      }
    }
  }
}