import java.io.*;
import java.util.*;

class Point {
  int x;
  int y;
  int type;

  public Point(int x, int y, int type) {
    this.x = x;
    this.y = y;
    this.type = type;
  }

  @Override
  public String toString() {
    return "Point [x=" + x + ", y=" + y + ", type=" + type + "]";
  }

}

class Main {
  static int R, C, N, M;
  static char[][] map;
  static final int[] dx = {1,-1,0,0};
  static final int[] dy = {0,0,1,-1};
  static int[][] visited;
  static Queue<Point> q;

  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      R = Integer.parseInt(st.nextToken());
      C = Integer.parseInt(st.nextToken());

      map = new char[R][C];
      visited = new int[R][C];
      q = new LinkedList<>();

      for(int r=0; r<R; r++){
        String str = br.readLine();
        for(int c=0; c<C; c++){
          map[r][c] = str.charAt(c);
          // 물 먼저
          if(map[r][c] == '*') {
            q.offer(new Point(r,c,'*'));
          } else if(map[r][c]=='S'){
            N=r;
            M=c;
          }
          visited[r][c]=0;
        }
      }
      // 그 다음 고슴도치 출발
      q.offer(new Point(N,M,'S'));

      int res = bfs();
      if(res == -1){
        System.out.println("KAKTUS");
      } else {
        System.out.println(res);
      }

  }  

  // S -> D
  static int bfs(){
    while(!q.isEmpty()){
      // 1. 큐에서 꺼내옴.
      Point p = q.poll();
      // 2. 목적지: S가 D에 도착했을 때 
      if(p.type=='S' && map[p.x][p.y]=='D'){
        return visited[p.x][p.y];
      }
      // 3. 연결된 곳은 상하좌우 4곳
      for(int i=0; i<4; i++){
        int nx = p.x + dx[i];
        int ny = p.y + dy[i];

        // 4. 갈 수 있는 곳 체크: 좌표는 맵 안에 있어야 함.
        if(!isInTheMap(nx, ny)) {
          continue;
        }
        
        // 물이면 주변 번지기
        if(p.type == '*'){
          if(map[nx][ny]=='.'){
            // 5. 체크인 방문 예정인 곳
            map[nx][ny]='*';
            // 6. 큐에 넣음.
            q.offer(new Point(nx,ny, '*'));
          }
        } else if (p.type =='S'){
          // 비버면 한 칸 씩 이동
          if(visited[nx][ny] == 0 && (map[nx][ny]=='.' || map[nx][ny]=='D')){
            // 5. 체크인 방문 예정인 곳
            visited[nx][ny]= visited[p.x][p.y]+1;
            // 6. 큐에 넣음.
            q.offer(new Point(nx,ny, 'S'));
          }
        }
      }
    }
    return -1;
  }

  static boolean isInTheMap(int x, int y){
    if(x>=0 && x<R && y>=0 && y<C){
      return true;
    }
    return false;
  }
}

