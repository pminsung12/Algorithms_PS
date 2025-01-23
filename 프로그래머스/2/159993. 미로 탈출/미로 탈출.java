import java.util.*;

class Solution {
    static class Node{
        int x;
        int y;
        
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static ArrayDeque<Node> q;
    static Node S, E, L;
    static int len, len2;
    static int[][] visited;
    
    public int solution(String[] maps) {
        int answer = 0;
        len = maps.length;
        len2 = maps[0].length();
        for(int i=0; i<len; i++){
            for(int j=0; j<len2; j++){
                if(maps[i].charAt(j) == 'S'){
                    S = new Node(i, j);
                } else if(maps[i].charAt(j) == 'L'){
                    L = new Node(i, j);
                } else if(maps[i].charAt(j) == 'E'){
                    E = new Node(i, j);
                }
            }
        }
        visited = new int[len][len2];
        for(int i=0; i<len; i++){
            for(int j=0; j<len2; j++){
                visited[i][j]=0;
            }
        }
        int res = bfs(S,L,maps);
        if(res == 0){
            return -1;
        } else {
            answer+= res;
        }
        for(int i=0; i<len; i++){
            for(int j=0; j<len2; j++){
                visited[i][j]=0;
            }
        }
        res = bfs(L,E,maps);
        if(res == 0){
            return -1;
        } else {
            answer+= res;
        }
        
        return answer;
    }
    
    static int bfs(Node start, Node end, String[] maps){
        q = new ArrayDeque<>();
        q.add(start);
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            if((cur.x == end.x) && (cur.y == end.y)){
                return visited[end.x][end.y];
            }
            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if(nx<0 || nx>=len || ny<0 || ny>=len2){
                    continue;
                }
                
                if(maps[nx].charAt(ny)!='X' && visited[nx][ny]==0){
                    q.add(new Node(nx, ny));
                    visited[nx][ny] = visited[cur.x][cur.y]+1;
                }
            }
        }
        return 0;
    }
}