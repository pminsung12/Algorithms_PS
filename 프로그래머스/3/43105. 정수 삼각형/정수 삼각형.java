import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        // triangle 배열에 바로 memoization
        for(int i=1; i<triangle.length; i++){
            // 왼쪽 끝과 오른쪽 끝은 루트가 1개 밖에 없음
            triangle[i][0]+=triangle[i-1][0];
            triangle[i][i]+=triangle[i-1][i-1];
            
            for(int j=1; j<i; j++){
                triangle[i][j]+=Math.max(triangle[i-1][j-1], triangle[i-1][j]);
            }
        }
        
        // System.out.println(Arrays.deepToString(triangle));
        
        return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
    }
}