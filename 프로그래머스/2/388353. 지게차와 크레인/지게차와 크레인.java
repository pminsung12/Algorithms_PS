import java.util.*;

class Solution {
    
    static int N, M;
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        N= storage.length;
        M = storage[0].length();
        int container = N*M;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        
        int[][] map = new int[N+2][M+2];
        for(int[] arr: map){
            Arrays.fill(arr, -1);
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                char x = storage[i].charAt(j);
                map[i+1][j+1] = x-'A';
            }
        }
        
        for(String command: requests){
            int target = command.charAt(0)-'A';
            if(command.length()==2){
                for(int i=1; i<N+1; i++){
                    for(int j=1; j<M+1; j++){
                        if(map[i][j]==target){
                            map[i][j]=-1;
                            container--;
                        }
                    }
                }
            } else {
                boolean[][] visited = new boolean [N+2][M+2];
                ArrayDeque<int[]> q = new ArrayDeque<>();
                visited[0][0] = true;
                q.add(new int[]{0,0});
                while(!q.isEmpty()){
                    int[] cur = q.poll();
                    int x = cur[0];
                    int y = cur[1];
                    for(int i=0; i<4; i++){
                        int nx = x + dx[i];
                        int ny = y + dy[i];
                        if(canGo(nx, ny)&&!visited[nx][ny] && (map[nx][ny]==target||map[nx][ny]==-1)){
                            if(map[nx][ny]==target){
                                container--;
                                map[nx][ny] = -1;
                                visited[nx][ny] = true;
                                continue;
                            }
                            
                            q.add(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
        return container;
    }
    static boolean canGo(int x, int y){
        return x>=0 && y>=0 && x<N+2 && y<M+2;
    }
}