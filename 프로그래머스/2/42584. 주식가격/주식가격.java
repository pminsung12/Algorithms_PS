import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i=0; i<prices.length-1; i++){
            for(int j=i+1; j<prices.length; j++){
                // 일단 1초 뒤에 가격이 변동되기 때문에 +1은 무조건
                answer[i]+=1;
                if(prices[i]>prices[j]){ // 가격이 떨어졌을 때
                    break;
                }
            }
        }
        
        return answer;
    }
}