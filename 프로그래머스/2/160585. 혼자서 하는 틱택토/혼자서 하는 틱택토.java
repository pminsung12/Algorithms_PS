class Solution {
    public int solution(String[] board) {
        // 1. OX 개수가 2개 이상 차이날 때
        int ocount=0;
        int xcount=0;
        for(String s: board){
            ocount += countChar(s, 'O');
            xcount += countChar(s, 'X');
            
        }
        
        if(xcount > ocount){
            return 0;
        }
        if(ocount > xcount+1){
            return 0;
        }
        if(hasWin(board, 'O') && ocount == xcount){
            return 0;
        }
        if(hasWin(board, 'X') && ocount==xcount+1){
            return 0;
        }
        return 1;
    }
    
    static int countChar(String str, char c){
        return str.length() - str.replace(String.valueOf(c), "").length();
    }
    
    // 2. 이미 줄이 만들어졌을 때
    static boolean hasWin(String[] board, char ch){
        //가로 검사
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == ch
                    && board[i].charAt(1) == ch
                    && board[i].charAt(2) == ch) {
                return true;
            }
        }
        //세로 검사
        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(i) == ch
                    && board[1].charAt(i) == ch
                    && board[2].charAt(i) == ch) {
                return true;
            }
        }
        //대각선 검사
        if (board[0].charAt(0) == ch
                && board[1].charAt(1) == ch
                && board[2].charAt(2) == ch) {
            return true;
        }
        if (board[0].charAt(2) == ch
                && board[1].charAt(1) == ch
                && board[2].charAt(0) == ch) {
            return true;
        }
        return false;
    }
}