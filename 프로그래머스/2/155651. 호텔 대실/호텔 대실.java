import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int len = book_time.length;
        int[][] time = new int[len][2];
        
        for(int i=0; i<len; i++){
            int start = Integer.parseInt(book_time[i][0].replace(":", ""));
            int end = Integer.parseInt(book_time[i][1].replace(":", ""));
            
            end += 10;
        
            if(end%100 >= 60){
                end += 40;
            }
            
            time[i][0] = start;
            time[i][1] = end;
        }
        
        Arrays.sort(time, (a,b) -> {
            return a[0]-b[0];
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] arr: time){
            if(pq.isEmpty()){
                pq.add(arr[1]);
            } else {
                if(arr[0]>= pq.peek()){
                    pq.poll();
                }
                pq.add(arr[1]);
            }
        }
        
        return pq.size();
    }
}
