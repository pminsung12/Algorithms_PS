class Solution {

    static int n, m;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public int numIslands(char[][] grid) {
        int answer=0;
        n = grid.length;
        m = grid[0].length;

        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    dfs(i,j, grid);
                    answer++;
                }
            }
        }

        return answer;
    }

    static void dfs(int x, int y, char[][] grid){
        // 1. 체크인
        visited[x][y] = true;
        
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || nx >= n || ny<0 || ny>=m){
                continue;
            }
            if(!visited[nx][ny] && grid[nx][ny]=='1'){
                dfs(nx,ny, grid);
            }
        }
    }
}