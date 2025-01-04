import java.io.*;
import java.util.*;

class Node{
  int x;
  int y;

  public Node(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

class Main{

  static int N,M;
  static int[] dx = {-1,0,1,0};
  static int[] dy = {0,1,0,-1};
  static int[][] map;
  static int[][] visited;
  static ArrayDeque<Node> q;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    visited = new int[N][M];
    q = new ArrayDeque<>();

    visited[0][0]=1;
    q.add(new Node(0,0));

    for(int n=0; n<N; n++){
      String s = br.readLine();
      for(int i=0; i<s.length(); i++){
        map[n][i] = Integer.parseInt(s.substring(i, i+1));
      }
    }

    bfs();
    
    System.out.println(visited[N-1][M-1]);
  }

  static void bfs(){
    while(!q.isEmpty()){
      Node cur = q.poll();
      for(int i=0; i<4; i++){
        int nx = cur.x+dx[i];
        int ny = cur.y+dy[i];
        if(nx<0 || ny<0 || nx>=N || ny>=M){
          continue;
        }
        if(visited[nx][ny]==0 && map[nx][ny]!=0){
          q.add(new Node(nx, ny));
          visited[nx][ny]=visited[cur.x][cur.y]+1;
        }
      }
    }
  }
}