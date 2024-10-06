import java.util.*;

class Solution {
    public long solution(int n, int[] times) {        
        // 오름차순으로 정렬
        Arrays.sort(times);
        
        // 이분탐색 -> 시간을 축으로
        long left = 0;
        long right = times[times.length-1] * (long)n; // 최대 시간: 제일 오래걸리는 작업 시간 * 사람 수
        long mid=0L, minTime=0L;
        
        while(left<=right){
            mid = (left + right)/2;
            long maxPeople=0;
            for(int time: times){
                maxPeople += mid / time;
            }
            
            if(maxPeople < n){
                // 지금 시간의 최대 사람 수가 n보다 작으면 시간이 더 필요
                left = mid+1;
            } else {
                // 지금 시간의 최대 사람 수가 n보다 크면 최소 시간이 아님.
                right = mid-1;
                minTime = mid;
            }
        }
        
        return minTime;
    }
}