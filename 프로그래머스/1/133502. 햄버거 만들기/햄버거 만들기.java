import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        Stack<Integer> stk = new Stack<>();
        
        for(int i: ingredient){
            stk.push(i);
            int len=stk.size();
            if(len>=4){
                if(stk.get(len-1)==1 && stk.get(len-2)==3 && stk.get(len-3)==2 && stk.get(len-4)==1){
                    answer+=1;
                    for(int j=0; j<4; j++) stk.pop();
                }
            }
        }
        
        return answer;
    }
}