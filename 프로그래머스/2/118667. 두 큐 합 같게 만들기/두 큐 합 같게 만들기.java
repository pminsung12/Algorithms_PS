import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        long sum1=0, sum2=0;
        
        ArrayDeque<Integer> q1 = new ArrayDeque<>();
        ArrayDeque<Integer> q2 = new ArrayDeque<>();
        
        for(int i=0; i<queue1.length; i++){
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            
            sum1 += (long) queue1[i];
            sum2 += (long) queue2[i];
        }
        
        int cnt=0;
        while(cnt <= queue1.length*4){
            if(sum1<sum2){
                int tmp = q2.poll();
                q1.add(tmp);
                sum1 += (long) tmp;
                sum2 -= (long) tmp;
            } else if(sum1>sum2){
                int tmp = q1.poll();
                q2.add(tmp);
                sum2 += (long) tmp;
                sum1 -= (long) tmp;
            } else {
                return answer = cnt;
            }
            cnt++;
        }
        
        
        return answer;
    }
}