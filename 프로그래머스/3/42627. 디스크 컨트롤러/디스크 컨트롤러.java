import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a,b)->a[0]-b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]); 
        
        int now=0, answer=0, jobIdx=0, cnt=0;
        
        while(cnt<jobs.length){ // 모든 jobs 처리할 때까지
            // 지금 시점에서 들어온 job들만 힙에 넣기
            while(jobIdx<jobs.length && jobs[jobIdx][0] <= now){
                pq.offer(jobs[jobIdx++]);
            }
            
            // 큐가 비어있으면 아직 요청을 기다리는 거니까 다음 요청 시작점으로 슉 옮기기
            if(pq.isEmpty()){
                now = jobs[jobIdx][0];
            } else{
                // 힙에 넣었으니 가장 수행시간이 짧은 요청부터 끝내기!
                int[] job=pq.poll();
                answer+= now+job[1]-job[0];
                now+=job[1];
                cnt++;
            }
             
        }
        
        return (int) answer/jobs.length ;
    }
}