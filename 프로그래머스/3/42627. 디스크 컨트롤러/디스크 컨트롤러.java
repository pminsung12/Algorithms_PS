import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a,b)->a[0]-b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]); 
        
        int now=0, answer=0, jobIdx=0, cnt=0;
        
        while(cnt<jobs.length){
            while(jobIdx<jobs.length && jobs[jobIdx][0] <= now){
                pq.offer(jobs[jobIdx++]);
            }
            
            if(pq.isEmpty()){
                now = jobs[jobIdx][0];
            } else{
                int[] job=pq.poll();
                answer+= now+job[1]-job[0];
                now+=job[1];
                cnt++;
            }
             
        }
        
        int res = answer/jobs.length;
        return (int) answer/jobs.length ;
    }
}