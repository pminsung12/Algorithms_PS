import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int[][] dp = new int[info.length+1][m];
        for(int i=1; i<=info.length; i++){
            Arrays.fill(dp[i], n);
        }
        dp[0][0]=0;
        
        for(int i=1; i<=info.length; i++){
            int a = info[i-1][0];
            int b = info[i-1][1];
            for(int j=0; j<m; j++){
                // a가 훔침
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j]+a);
                // b가 훔침
                if(j+b<m){
                    dp[i][j+b] = Math.min(dp[i][j+b], dp[i-1][j]);
                }
            }
        }
        
        int answer=n;
        for(int i=0; i<m; i++){
            answer = Math.min(answer, dp[info.length][i]);
        }
        return answer>=n ? -1 : answer;
    }
}