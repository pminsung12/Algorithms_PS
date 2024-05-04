import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stkInt = new Stack<>();
        
        for(int i=0; i<prices.length; i++){
            while(!stkInt.empty() && prices[i]<prices[stkInt.peek()]){
                answer[stkInt.peek()]=i-stkInt.peek();
                stkInt.pop();
            }
            
            stkInt.push(i);
        }
        
        while(!stkInt.empty()){
            answer[stkInt.peek()] = prices.length- stkInt.peek() - 1;
            stkInt.pop();
        }
        
        
        return answer;
    }
}