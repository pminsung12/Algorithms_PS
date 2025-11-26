import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<works.length; i++){
            pq.offer(works[i]);
        }
        
        while(n>0){
            int work = pq.poll();
            if(work ==0) break;
            work-=1;
            pq.offer(work);
            n-=1;
        }
        
        for(int work:pq){
            answer+= work*work;
        }        
        
        
        return answer;
    }
}