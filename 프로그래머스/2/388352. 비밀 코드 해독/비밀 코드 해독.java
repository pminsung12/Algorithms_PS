import java.util.*;

class Solution {
    
    int N;
    int[][] Q;
    int[] ANS;
    List<Integer> lst = new ArrayList<>();
    int answer=0;
    
    public int solution(int n, int[][] q, int[] ans) {
        N = n;
        ANS = ans;
        Q = q;
        
        dfs(1,0);
        
        return answer;
    }
    
    public void dfs(int cur, int depth){
        if(depth == 5){
            int sum=0;
            if(check()) answer++;
            return;
        }
        
        for(int i=cur; i<=N; i++){
            lst.add(i);
            dfs(i+1, depth+1);
            lst.remove(lst.size()-1);
        }
        
    }
    
    public boolean check(){
        for(int i=0; i<Q.length; i++){
            int cnt=0;
            for(int j=0; j<5; j++){
                for(int num: lst){
                    if(num==Q[i][j]) cnt++;
                }
            }
            if(cnt!=ANS[i]) return false;
        }
        
        return true;
    }
}