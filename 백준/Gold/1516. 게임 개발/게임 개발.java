import java.util.*;
import java.io.*;

class Main {
  
  static int N, cost, from, to;
  static int[] buildTime;
  static int[] preBuildTime;
  static int[] indegree;
  static List<Integer>[] adjList;


  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    N = Integer.parseInt(st.nextToken());

    buildTime = new int[N+1];
    preBuildTime = new int[N+1];
    indegree = new int[N+1];
    adjList = new ArrayList[N+1];

    for(int i=0; i<=N; i++){
      adjList[i] = new ArrayList<>();
    }
    
    for(int to=1; to<=N; to++){
      st = new StringTokenizer(br.readLine());
      buildTime[to] = Integer.parseInt(st.nextToken());

      while(true){
        int from = Integer.parseInt(st.nextToken());

        if(from==-1) break;

        adjList[from].add(to);
        indegree[to]++;
      }
    }

    topologicalSort();

    for(int n=1; n<=N; n++){
      bw.write(String.valueOf(buildTime[n] + "\n"));
    }

    bw.flush();
    bw.close();
    br.close();
  }

  static void topologicalSort(){
    ArrayDeque<Integer> q = new ArrayDeque<>();

    // 진입 차수가 0인 노드를 모두 큐에 삽입
    for(int n=1; n<=N; n++){
      if(indegree[n]==0){
        q.add(n);
      }
    }

    while(!q.isEmpty()){
      int cur = q.poll();

      for(int to:adjList[cur]){
        // 간선 지워주고
        indegree[to]--;

        // 이전의 루트와 현재 루트 중 max 값이 to 정점의 preBuildTime
        preBuildTime[to] = Math.max(preBuildTime[to], buildTime[cur]);

        // 진입차수 0이면 큐에 추가
        if(indegree[to]==0){
          q.add(to);
          buildTime[to] += preBuildTime[to];
        }
      }
      cost-=buildTime[cur];
    }
  }
}