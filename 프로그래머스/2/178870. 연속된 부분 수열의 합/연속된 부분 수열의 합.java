class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        // 투포인터
        int start = 0;
        int end = 0;
        int res=sequence[0];
        int len=Integer.MAX_VALUE;
        
        while(start <= end){
            if(res < k){
                if(end != sequence.length-1){
                    end++;
                    res+=sequence[end];
                } else {
                    break;
                }
            } else if (res > k){
                res-=sequence[start];
                start++;
            } else {
                if(end-start+1<len){
                    answer[0] = start;
                    answer[1] = end;
                    len = end-start+1;
                }
                if(end != sequence.length-1){
                    end++;
                    res+=sequence[end];
                } else {
                    break;
                }  
            }
        }
        
        return answer;
    }
}