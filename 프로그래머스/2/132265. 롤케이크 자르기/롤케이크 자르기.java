import java.util.*;

class Solution {
    public int solution(int[] toppings) {
        int answer = 0;
        Map<Integer, Integer> oMap = new HashMap<>();
        Map<Integer, Integer> yMap = new HashMap<>();
        
        for(int topping: toppings){
            oMap.put(topping, oMap.getOrDefault(topping, 0) +1);
        }
        
        for(int topping: toppings){
            yMap.put(topping, yMap.getOrDefault(topping, 0) +1);
            if(oMap.get(topping)-1==0){
                oMap.remove(topping);
            } else {
                oMap.put(topping, oMap.getOrDefault(topping,0)-1);
            }
            
            if(yMap.size()==oMap.size()){
                answer++;
            }
            
        }
        
        return answer;
    }
}