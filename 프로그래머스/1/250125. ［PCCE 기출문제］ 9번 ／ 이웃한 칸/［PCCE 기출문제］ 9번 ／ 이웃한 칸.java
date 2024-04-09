class Solution {
    public int solution(String[][] board, int x, int y) {
        int answer = 0;
        
        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        
        for(int i=0; i<4; i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            
            if(isAvailable(nx,ny, board.length)){
                // System.out.printf("%s %s ", board[nx][ny], board[x][y]);
                if(board[nx][ny].equals(board[x][y])){
                    // System.out.printf("[%d %d]", nx, ny);
                    answer+=1; 
                }
                
            }
        }
        
        return answer;
    }
    
    public boolean isAvailable(int x, int y, int len){
        if(x<0 || x >= len || y<0 || y>=len){
            return false;
        }
        return true;
    }
}