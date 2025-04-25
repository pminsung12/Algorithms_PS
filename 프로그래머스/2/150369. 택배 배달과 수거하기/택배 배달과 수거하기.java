import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int len = deliveries.length;
        
        int cntDelivery = 0;
        int cntPickups=0;
        for(int i= len-1; i>=0; i--){
            cntDelivery += deliveries[i];
            cntPickups += pickups[i];
            
            while(cntDelivery > 0 || cntPickups > 0){
                cntDelivery -= cap;
                cntPickups -= cap;
                
                answer += (i+1)*2;
            }
        }
        return answer;
    }
}