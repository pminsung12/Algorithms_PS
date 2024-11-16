import java.util.*;

class Solution {
    
    public int solution(int n, int k) {
        int answer = 0;
        String[] arr = Integer.toString(n, k).split("0");
        
        for(String s: arr){
            if(s.equals("")) continue;
            long a = Long.parseLong(s);
            if(a==1) continue;
            
            boolean isPrime = true;
            for(long j=2; j<=Math.sqrt(a); j++){
                if(a%j==0){
                    isPrime=false;
                    break;
                }
            }
            if(isPrime) answer++;
        }
        
        return answer;
    }
    
    
    
}