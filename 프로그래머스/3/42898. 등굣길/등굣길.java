import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) { 
        int answer = 0, mod = 1000000007;
        int[][] dp = new int[n][m];
        dp[0][0]=1;
        
        for(int[] puddle: puddles){
            dp[puddle[1]-1][puddle[0]-1]=-1;
        }
        // System.out.println(Arrays.deepToString(puddles));
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                // 물웅덩이 있으면 0으로 바꾸고 패스
                if(dp[i][j]==-1){
                    dp[i][j]=0;
                    continue;
                }
                
                // 오른쪽
                if(j!=0) dp[i][j]+=dp[i][j-1]% mod;
                
                // 아래쪽
                if(i!=0) dp[i][j]+=dp[i-1][j]% mod;
    
            }
        }
        
        // System.out.println(Arrays.deepToString(dp));
        return dp[n-1][m-1]% mod;
    }
}