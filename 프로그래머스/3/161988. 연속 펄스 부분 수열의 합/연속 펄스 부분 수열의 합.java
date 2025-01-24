import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int len = sequence.length;
        
        int[] a = new int[len];
        int[] b = new int[len];
        int n=1;
        for(int i = 0; i<len; i++) {
            a[i] = sequence[i]*n;
            n *= -1;
            b[i] = sequence[i]*n;
        }
        

        long[] dp1 = new long[len];
        long[] dp2 = new long[len];
        dp1[0] = a[0];
        dp2[0] = b[0];
        answer = Math.max(dp1[0], dp2[0]);
        
        for(int i=1; i<len; i++){
            dp1[i] = Math.max(dp1[i-1]+a[i], a[i]);
            dp2[i] = Math.max(dp2[i-1]+b[i], b[i]);
            
            long max = Math.max(dp1[i], dp2[i]);
            answer = Math.max(answer, max);
        }
        
        return answer;
    }
}
