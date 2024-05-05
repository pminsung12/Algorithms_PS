import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][];
        for (int i = 0; i < triangle.length; i++) {
            dp[i] = Arrays.copyOf(triangle[i], triangle[i].length);
        }
        
        for(int i=0; i<dp.length-1; i++){
            for(int j=0; j<dp[i].length; j++){
                // 다음줄의 j, j+1  인덱스자리에 현재 값을 더하면 된다.
                dp[i+1][j]=Math.max(dp[i][j]+triangle[i+1][j], dp[i+1][j]);
                dp[i+1][j+1]=Math.max(dp[i][j]+triangle[i+1][j+1], dp[i+1][j+1]);
                
                if(i==triangle.length-2){
                    answer = Math.max(Math.max(dp[i+1][j],dp[i+1][j+1]), answer);
                }
            }
        }
        
        // System.out.println(Arrays.deepToString(dp));
        
        return answer;
    }
}